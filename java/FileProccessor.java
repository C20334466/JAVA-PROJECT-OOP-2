package searchengine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProccessor {

	
	public static final long serialVersionUID =1L;
	//file object to get file txt
	public File myFile1 = new File("src/example.txt");
	public File myFile2 = new File("src/example2.txt");
	public File myFile3 = new File("src/example3.txt");
	public File myFile4 = new File("src/example4.txt");
	
	//attributes
	public Scanner myScanner1, myScanner2, myScanner3, myScanner4;
	public String line1, line2, line3, line4;
	
	//method to open file
	public void filingCheck() {
		
		try
		{
			myScanner1 = new Scanner(myFile1);
			myScanner2 = new Scanner(myFile2);
			myScanner3 = new Scanner(myFile3);
			myScanner4 = new Scanner(myFile4);
			
			//delimter to tokenizes the scanner input
			myScanner1.useDelimiter(",");
			myScanner2.useDelimiter(",");
			myScanner3.useDelimiter(",");
			myScanner4.useDelimiter(",");
			
		}//error checking
		catch (FileNotFoundException event) { 
			
			System.out.println("Files Not Found");
		   }
		
	}
	//method to open file and scan it
	public FileProccessor() {
		filingCheck();
	}
}
