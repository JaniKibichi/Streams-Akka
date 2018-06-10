# Akka Streams
Akka Streams Model is built on top of Akka to make ingestion of streams easy.
A Stream is a set of components with different responsibilities. It includes the following:
- Source: And entry point to the stream.
- Sink: Exit point to the stream.
- Flow: Manipulating the stream
<br><br>
- Branch out to create a simple Akka Stream 
````
git checkout -b simple_akka_stream master

````
- Add the Akka Stream dependency:
````
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.5.12"
````    
- Create a file:<b>com.github.janikibichi.learnakka.streams.SimpleStreamsApp.scala</b>
- Create two files: testfile2.txt and testfile3.txt and add a string to testfile3.txt
- Run [the App](https://asciinema.org/a/EF4w7zfNVxXq3EzP08OeGDbe7): 
````
sbt "runMain com.github.janikibichi.learnakka.streams.SimpleStreamsApp"
````
<br><br>
- Branch out to create a transform and consume stream
````
git checkout -b transform_consume_streams simple_akka_stream 

````
- Create a resource in src/main/resources; gzipped-file.txt, fill with text and gzip it
- Create file: <b>com.github.janikibichi.learnakka.streams.TransformingStreamsApp.scala</b>
- [Run the App:](https://asciinema.org/a/ORtz1GvYAGwLUrBYo6hEi1kuD)
````
sbt "runMain com.github.janikibichi.learnakka.streams.TransformingStreamsApp"
````
<br><br>
- Branch out to create a modularizing stream app
````
git checkout -b modularizing_stream_app transform_consume_streams
````
- Use resource file: src/main/resources/gzipped-file.txt.gz
- Create a file: <b>com.github.janikibichi.learnakka.streams.ModularizingStreamsApp.scala</b>
- [Run the App:](https://asciinema.org/a/88UssGhUkevST3VRSRRF2WX5e)
````
sbt "runMain com.github.janikibichi.learnakka.streams.ModularizingStreamsApp"
````
<br><br>
- Branch out to explore custom streams
````
git checkout -b explore_custom_streams modularizing_stream_app
````
- Create file: <b>com.github.janikibichi.learnakka.streams.HelloAkkaStreamsApp.scala</b>
- Create file: <b>com.github.janikibichi.learnakka.streams.WordCounterSink.scala</b>
- Create file: <b>com.github.janikibichi.learnakka.streams.CustomStagesApp.scala</b>
- [Run the App:](https://asciinema.org/a/Pv5vZJo4GkQahyWJByL6Vm2pY)
````
sbt "runMain com.github.janikibichi.learnakka.streams.CustomStagesApp"
````
<br><br>
- Branch out to explore error handling in Akka streams
````
git checkout -b error_handling_streams explore_custom_streams 
````
- Create file: <b>com.github.janikibichi.learnakka.streams.HandlingErrorApp.scala</b>
- [Run the App:](https://asciinema.org/a/J7pIe3P8b1ChRcVx9BrsuqNxj)
````
sbt "runMain com.github.janikibichi.learnakka.streams.HandlingErrorApp"
````
<br><br>
-  Branch out to explore parallelizing and pipelining streams
````
git checkout -b pipelining_parallelizing error_handling_streams
````
- Create file: <b>com.github.janikibichi.learnakka.streams.PipeliningParallelizing.scala</b>
- Create file: <b>com.github.janikibichi.learnakka.streams.PipeliningParallelizingApp.scala</b>
- Run the [synchronous pipelining app:](https://asciinema.org/a/IvHLrehI2l5E7XJCdl6Peb6oo)
````
sbt "runMain com.github.janikibichi.learnakka.streams.SynchronousPipeliningApp"
````
- Run the [asynchronous pipelining app:](https://asciinema.org/a/moIpj9PxpaaCgRco4OLTDLx6J)
````
sbt "runMain com.github.janikibichi.learnakka.streams.AsynchronousPipeliningApp"
````
- Run the [parallelizing app](https://asciinema.org/a/cRVrubTdIPfEPXiuwjbV5IRRb)
````
sbt "runMain com.github.janikibichi.learnakka.streams.ParallelizingApp"
````
<br><br>
- Branch out to explore streaming i/o
````
git checkout -b streaming_io pipelining_parallelizing 
````
- Create file: <b>com.github.janikibichi.learnakka.streams.WorkingIOStreamsApp.scala</b>
- Run the [WorkingIOStreamsApp]() and Use netcat to push a stream to the TCP Server
````
sbt "runMain com.github.janikibichi.learnakka.streams.WorkingIOStreamsApp"
````
- On a [different terminal:]()
````
echo -n "A very very repetitive message to count words" | netcat 127.0.0.1 1234
````
<br><br>
- Branch out to explore streams and actors
````
git checkout -b streams_and_actors streaming_io 
````
- Create file: <b>com.github.janikibichi.learnakka.streams.StringCleanerActor.scala</b>
- Create file: <b>com.github.janikibichi.learnakka.streams.SourceActor.scala</b>
- Create file: <b>com.github.janikibichi.learnakka.streams.IntegrateActorApp.scala</b>
- Run the [IntegrateWithActors App](https://asciinema.org/a/SJCMRE2clgUKXF3U7a1Fv72ab)
````
sbt "runMain com.github.janikibichi.learnakka.streams.IntegrateActorApp"
````
<br><br>
- Branch out to explore working with graphs
````
git checkout -b working_with_graphs streams_and_actors
````
- Create file: <b>com.github.janikibichi.learnakka.streams.StatefulCounterFlow.scala</b>
- Create file: <b>com.github.janikibichi.learnakka.streams.WorkingWithGraphs.scala</b>
- Run [the App](https://asciinema.org/a/iffde1NdmHrRbiaafUc4PyE2s)
````
sbt "runMain com.github.janikibichi.learnakka.streams.WorkingWithGraphsApp"
````
<br><br>
- Branch out to explore working with RabbitMQ and streams
````
git checkout -b streams_and_rabbitmq working_with_graphs
````
- Run a [docker rabbitMQ container.](https://hub.docker.com/_/rabbitmq/)
