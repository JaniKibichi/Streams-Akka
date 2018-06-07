package com.github.janikibichi.learnakka.streams

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Sink, Source}

object SimpleStreamsApp extends App {
  implicit val actorSystem = ActorSystem("SimpleStream")
  implicit val actorMaterializer = ActorMaterializer()

  val fileList = List("src/main/resources/testfile1.txt",
    "src/main/resources/testfile2.txt",
    "src/main/resources/testfile3.txt")

  val stream = Source(fileList).map(new java.io.File(_)) //open fileList
    .filter(_.exists()) //filter if file exists
    .filter(_.length() !=0) //if file has content
    .to(Sink.foreach(f => println(s"Absolute path: ${f.getAbsolutePath}")))

  //Run the stream
  stream.run()
}