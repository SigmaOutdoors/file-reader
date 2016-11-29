package com.sigmaoutdoors.app;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.file.Files;

/**
 * ReadFile : perform read actions on a file,
 */
public class ReadFile {
	
	/**
	 * A Hello method to make sure all is well
	 */
	public String Hello() {
		String ss = "Hello from ReadFile. Current directory : " + System.getProperty("user.dir");
		System.out.println(ss);
		return (ss);
	}

	/**
	 * Read the contents of a file into a string.  NOTE this is for small files and not intended to perform massive 
	 * or chunk based reading of large files.
	 */
	public String readFile(String filename) throws IOException, FileNotFoundException {
		File f = new File(filename);
		byte[] bytes = Files.readAllBytes(f.toPath());
		return new String(bytes, "UTF-8");
	}
}
