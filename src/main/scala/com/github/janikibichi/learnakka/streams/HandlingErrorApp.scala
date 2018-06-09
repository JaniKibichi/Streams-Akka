package com.github.janikibichi.learnakka.streams

import akka.actor.ActorSystem
import akka.stream.scaladsl.{Flow, Sink, Source}
import akka.stream.{ActorAttributes, ActorMaterializer, ActorMaterializerSettings, Supervision}

object HandlingErrorApp extends App {
  implicit val actorSystem = ActorSystem("HandlingErrors")

  val streamDecider: Supervision.Decider = {
    case e: IndexOutOfBoundsException =>
      println("Dropping element because of IndexOutOfBoundException. Resuming.")
      Supervision.Resume

    case _ => Supervision.Stop
  }

  val flowDecider: Supervision.Decider ={
    case e: IllegalArgumentException =>
      println("Dropping element because of IllegalArgumentException. Restarting.")
      Supervision.Restart

    case _ => Supervision.Stop
  }

  val actorMaterializerSettings = ActorMaterializerSettings(actorSystem).withSupervisionStrategy(streamDecider)
  implicit val actorMaterializer = ActorMaterializer(actorMaterializerSettings)

  val words = List("Handling", "Errors","In","Akka","Streams","")

  val flow = Flow[String].map(
    word => {
      if(word.length == 0) throw new IllegalArgumentException("Empty words are not allowed.")
      word
    }).withAttributes( ActorAttributes.supervisionStrategy(flowDecider))

  //Map and get third character with Array(2)
  Source(words).via(flow).map(array => array(2)).to(Sink.foreach(println)).run()

}
