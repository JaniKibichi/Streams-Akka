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
