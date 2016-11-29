# file-reader
Just a simple java program built with Maven to read a file and dump the contents.
Download and change directory to where pom.xml file is and run
# mvn package
This will compile and run unit tests.  To run stand alone from same directory as above, use
# java -cp target/file-reader-2.2.jar;src/main/resources/commons-cli-1.3.1.jar com.sigmaoutdoors.app.App -f README.md
