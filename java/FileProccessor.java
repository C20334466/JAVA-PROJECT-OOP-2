package com.test.OOP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileProccessor {

		
		//attributes
		String fileName;   
		File myFile;
		static String line;
		
		
		//constructors
		public FileProccessor(String fileName)
		{
				this.fileName = fileName;
		}
		
		//open file method
		public void openFile()
		{
			myFile = new File(fileName);	
		}
		
		//read line method
		public String readLines()
		{
				  //right now we are just reading one line from the file
				
				try {
					Scanner myScanner = new Scanner(myFile);
					 
					while(myScanner.hasNextLine())
					{
						line = myScanner.nextLine();
						System.out.println(line);
					}
					myScanner.close();
					
				//error checking
				} catch (FileNotFoundException e) { 
					e.printStackTrace();
					System.out.println("Error Caught "+ e.getMessage());
				}
				return line;
		}
		
	}


