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
 