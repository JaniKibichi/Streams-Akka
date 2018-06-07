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