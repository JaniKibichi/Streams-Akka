package com.github.janikibichi.learnakka.streams

import akka.stream.scaladsl.Flow

object SynchronousPipeliningApp extends PipeliningParallelizing {
  runGraph(Flow[Wash]
    .via(washStage)
    .via(dryStage))
}

object AsynchronousPipeliningApp extends PipeliningParallelizing {
  runGraph(Flow[Wash]
    .via(washStage.async)
    .via(dryStage.async))
}

object ParallelizingApp extends PipeliningParallelizing {
  runGraph(Flow[Wash]
    .via(parallelStage))
}