package com.sigmaoutdoors.app;
import org.apache.commons.cli.*;

/**
 * App to call ReadFile to read the contents of a file and dump to screen.
 */
public class App {
	
	CommandLineParser mParser = new DefaultParser();  // Apache command line parser
	public CommandLine mCommandLine = null;           // The results of the parsed command line.
	
	/**
	 * The main
	 */
	public static void main(String[] args) {
		App a = new App();
		try {
		   a.ParseCommandLine(args);  // sets mCommandLine
			if (a.mCommandLine.hasOption("f")) {
				System.out.println("Has -f " + a.mCommandLine.getOptionValue("f"));
			}
		   a.Run(a.mCommandLine.getOptionValue("f"));											
		} catch (org.apache.commons.cli.ParseException ee) {
			if (ee.getMessage().contains("Unrecognized")) {
				System.out.println(ee.getMessage());
				System.out.println("Usage Example : file-reader -f README.txt");
			} else
				System.out.println("Unexpected exception :" + ee.getMessage());
			System.exit(1);
		} catch (Exception eee)
		{
			System.out.println("Unexpected exception :" + eee.getMessage());
			System.exit(2);
		}
	}

	/**
	 * Use the Apache cli to parse the command line and return it in the mCommandLine member variable
	 */
	public void ParseCommandLine(String[] args) throws org.apache.commons.cli.ParseException  {
		CommandLineParser mParser = new DefaultParser();
		// create the Options
		Options options = new Options();
		Option filename = Option.builder("f").hasArg() // tells that we have a arg with this flag
				.argName("FileName").required(true).desc("The filename/file spec to load").build();
		options.addOption(filename);
		
		mCommandLine = mParser.parse(options, args);
	}

	/**
	 * New up a ReadFile instance and pass in the path and filename allows us to mock the main passing in of path & filenmame
	 */
	public void Run(String fileName) throws Exception {
		ReadFile t = new ReadFile();
		System.out.println(t.readFile(fileName));

	}

}
