package com.github.janikibichi.learnakka.streams

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Flow,Source,Sink}

object CustomStagesApp extends App{
  implicit val actorSystem = ActorSystem("CustomStages")
  implicit val actorMaterializer = ActorMaterializer()

  val source = Source.fromGraph(new HelloAkkaStreamsApp())
  val upperCaseMapper = Flow[String].map(_.toUpperCase())
  val splitter = Flow[String].mapConcat(_.split(" ").toList)
  val punctuationMapper = Flow[String].map(_.replaceAll("""[p{Punct}&&[^.]]""","").replaceAll(System.lineSeparator(),""))
  val filterEmptyElements = Flow[String].filter(_.nonEmpty)
  val wordCounterSink = Sink.fromGraph(new WordCounterSink())

  val stream = source
    .via(upperCaseMapper)
    .via(splitter)
    .via(punctuationMapper)
    .via(filterEmptyElements)
    .to(wordCounterSink)

  stream.run()
}
