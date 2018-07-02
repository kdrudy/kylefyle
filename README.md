# Kyle Fyle Images
Simple file display web server using http://sparkjava.com/

You specify a file anywhere on your computer that will then be read in and displayed as text broken up by lines.

To build the jar run the command:
```
mvn clean compile assembly:single
```

To run the jar use the command:
```
java -jar kylefyle-1.0-jar-with-dependencies.jar "<file to display>"
```
