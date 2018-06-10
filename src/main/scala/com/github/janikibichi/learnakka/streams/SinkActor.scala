package com.github.janikibichi.learnakka.streams

import akka.actor.Actor
import com.github.janikibichi.learnakka.streams.SinkActor.{AckSinkActor, InitSinkActor}

object SinkActor{
  case object CompletedSinkActor
  case object AckSinkActor
  case object InitSinkActor
}

class SinkActor extends Actor{
  def receive ={
    case InitSinkActor =>
      println("SinkActor initialized")
      sender ! AckSinkActor

    case something =>
      println(s"Received [$something] in SinkActor")
      sender ! AckSinkActor
  }
}
