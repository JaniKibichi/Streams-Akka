package com.github.janikibichi.learnakka.streams

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Balance, Broadcast, Flow, GraphDSL, Merge, RunnableGraph, Sink, Source}
import akka.stream._

import scala.util.Random
import scala.concurrent.duration._

object WorkingWithGraphsApp extends App{
  implicit val actorSystem = ActorSystem("WorkingWithGraphs")
  implicit val actorMaterializer = ActorMaterializer()

  trait MobileMsg{
    def id = Random.nextInt(1000)
    def toGenMsg(origin: String) = GenericMsg(id, origin)
  }
  class AndroidMsg extends MobileMsg
  class IosMsg extends MobileMsg
  case class GenericMsg(id: Int, origin: String)

  val graph = RunnableGraph.fromGraph( GraphDSL.create(){ implicit builder =>
    import GraphDSL.Implicits._

    //Sources
    val androidNotification = Source.tick(2 seconds, 500 millis, new AndroidMsg)
    val iOSNotification = Source.tick(700 millis, 600 millis, new IosMsg)

    //Flow
    val groupAndroid = Flow[AndroidMsg].map(_.toGenMsg("ANDROID")).groupedWithin(5,5 seconds).async
    val groupIos = Flow[IosMsg].map(_.toGenMsg("IOS")).groupedWithin(5, 5 seconds).async
    def counter = Flow[Seq[GenericMsg]].via( new StatefulCounterFlow())
    val mapper = Flow[Seq[GenericMsg]].mapConcat(_.toList)

    //Junctions
    val aBroadcast = builder.add(Broadcast[Seq[GenericMsg]](2))
    val iBroadcast = builder.add(Broadcast[Seq[GenericMsg]](2))
    val balancer = builder.add(Balance[Seq[GenericMsg]](2))
    val notificationMerge = builder.add(Merge[Seq[GenericMsg]](2))
    val genericNotificationMerge = builder.add(Merge[GenericMsg](2))

    //Sink
    def counterSink(s: String) = Sink.foreach[Int](x => println(s"$s: [$x]"))

    //Graph
    androidNotification ~> groupAndroid ~> aBroadcast ~> counter ~> counterSink("Android")
                                           aBroadcast ~> notificationMerge
                                           iBroadcast ~> notificationMerge

    iOSNotification ~> groupIos ~> iBroadcast ~> counter ~> counterSink("IOS")

    notificationMerge ~> balancer ~> mapper.async ~> genericNotificationMerge
                         balancer ~> mapper.async ~> genericNotificationMerge

    genericNotificationMerge ~> Sink.foreach(println)

    ClosedShape
  })
  graph.run()
}
