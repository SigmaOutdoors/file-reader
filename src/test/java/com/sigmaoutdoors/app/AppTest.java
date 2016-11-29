package com.sigmaoutdoors.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.Arrays;
import java.io.StringWriter;
import java.io.PrintWriter;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	
	App a = new App();
	ReadFile rf = new ReadFile();
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

	/**
	 * Just a utility to get info on the stacktrace for failures
	 */
	private String getStackAsString(Exception ee)
	{	
           StringWriter sw = new StringWriter();
           ee.printStackTrace(new PrintWriter(sw));
           return(sw.toString());		
	}
	
	
    /**
     * Methods called to test, begin with "test" as called out in pom
     */
	 
	 
	 public void testCommandLine()
    {		
		String[] TestArg = {"-f", "C:\\2Do\\README.txt"};
		String TestSignature = "ParseCommandLine(" + Arrays.toString(TestArg) + ")";
		
		try {
		   a.ParseCommandLine(TestArg);
		   System.out.println("Success " + TestSignature);
           assertTrue( true );
		}
		catch(Exception ee){
           fail(TestSignature + "\n" + getStackAsString(ee));        
        }
    }
	
	
    public void testRun()
    {		
		String TestArg = "C:\\2Do\\README.txt";
		String TestSignature = "Run(\"" + TestArg + "\")";
		
		try {
		   a.Run(TestArg);
		   System.out.println("Success " + TestSignature);
           assertTrue( true );
		}
		catch(Exception ee){
           fail(TestSignature + "\n" + getStackAsString(ee));        
        }
    }
	
	
	public void testReadFile()
    {		
		String TestArg = "C:\\2Do\\README.txt";
		String TestSignature = "readFile(\"" + TestArg + "\")";
		
		try {
		   rf.readFile(TestArg);
		   System.out.println("Success " + TestSignature);
           assertTrue( true );
		}
		catch(Exception ee){
           fail(TestSignature + "\n" + getStackAsString(ee));        
        }
    }
	
		
	public void testHello()
    {
		String TestSignature = "Hello() ";
		String expected = "Hello from ReadFile.";
		String actual = rf.Hello();
  	    assertEquals(expected + " does not match " + actual, expected, actual);

		System.out.println("Success " + TestSignature);
    }
		
}
