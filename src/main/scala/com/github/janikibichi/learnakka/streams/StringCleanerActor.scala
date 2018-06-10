package com.github.janikibichi.learnakka.streams

import akka.actor.Actor

class StringCleanerActor extends Actor {
  def receive ={
    case s: String =>
      println(s"Cleaning [$s] in StringCleaner")
      sender ! s.replaceAll("""[p{Punct}&&[^.]]""","").replaceAll(System.lineSeparator(),"")
  }
}