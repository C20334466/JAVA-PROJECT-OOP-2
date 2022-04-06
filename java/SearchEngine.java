 * Title: Search Engine Program
 * Program Description:
 * 
 * This purpose of this Java Progrom is to be a search engine designed to go through a set of files to search for 
 * a word/phrase inputted by a user through the GUI interface. This tool will take things like Speeling errors 
 * ( see what i did there lol), Multiple words into consideration. 
 * 
 * Author: Emmanuel Igbinoba
 * Student NO. : C20334466
 * Date Last Modified: 07/04/22
 * 
 * 
 * 
 *                                        < ----- Citaition ------- >
 *
 *
 *public static final long serialVersionUID = 1L;
 *https://stackoverflow.com/questions/14274480/static-final-long-serialversionuid-1l
 *
 *.delimiter(string)
 *https://stackoverflow.com/questions/28766377/how-do-i-use-a-delimiter-with-scanner-usedelimiter-in-java
 * 
 */




package searchengine;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.File;

public class SearchEngine extends JFrame implements ActionListener {
	
	//gui attributes
	public static final long serialVersionUID = 1L;
	public JFrame frame;
	public FileProccessor f1 = new FileProccessor();
	public JPanel panel1, panel2;
	public JButton sbutton1,sbutton2;
	public JLabel label;
	public JTextField field1,field2;
	public String referencedWord;
	public JCheckBox cbox1, cbox2, cbox3, cbox4;
	public int counter = 0;
	public int i;
	public JTextArea textArea;
	
	//created array list
	ArrayList<Integer> counterlist = new ArrayList<Integer>();
	
	public void gui() {
		
			field1 = new JTextField("Enter Your Word Here");
			//setting up the frame of the GUI
			frame = new JFrame ("Search Engine");
			frame.setVisible(true);
			frame.setSize(400,400);
			//closes GUI when pressed X and stop its from running in the background
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//panel
			panel1 = new JPanel();
			panel1.setBackground(Color.PINK);
			add(panel1);
			
			//checkbox for file to search
			cbox1 = new JCheckBox("File 1");
			cbox2 = new JCheckBox("File 2");
			cbox3 = new JCheckBox("File 3");
			cbox4 = new JCheckBox("File 4");
			
			label = new JLabel("Type in a word to see if its in your File");
			label.setForeground(Color.white);
			
			//add checkbox to panel
			panel1.add(cbox1);
			panel1.add(cbox2);
			panel1.add(cbox3);
			panel1.add(cbox4);
			
			panel1.add(label);
			panel1.add(field1);
			
			sbutton1 = new JButton("Search");
			sbutton2 =  new JButton ("Clear");
			
			//method to listen out for button clicks
			sbutton1.addActionListener(this);
			sbutton2.addActionListener(this);
			cbox1.addActionListener(this);
			cbox2.addActionListener(this);
			cbox3.addActionListener(this);
			cbox4.addActionListener(this);
			
			panel1.add(sbutton1);
			panel1.add(sbutton2);
			
		    frame.add(panel1);
		    textArea = new JTextArea(25, 30);
		    panel1.add(textArea);
		    
		    textArea.setVisible(true);
		    textArea.setLocation(30, 110);
		    textArea.setSize(270, 200);
		    textArea.setEditable(false); //disallows the user to edit text area
		    setVisible(true);
		    
		    
			
	}

	
	public void actionPerformed(ActionEvent e) {
		
		//if button 2 gets clicked do...
		if(e.getSource() == sbutton2)
		{
			field1.setText("");
		}
		
			
				else if(e.getSource() == sbutton1)
				{
					referencedWord = field1.getText();
					
					//if checkbox 1 is selected do...
					if(cbox1.isSelected())
					{
							while(f1.myScanner1.hasNext())
							{
									String line1 = f1.myScanner1.nextLine();
									//check if line contains searched word
									if(line1.contains(referencedWord))
									{
											counter++;
									}
							}
							if(counter == 0)
							{
								textArea.append("\n"+ referencedWord+ " is not in file 1 ");
							}
							else {
								textArea.append("\n"+ referencedWord+ " is in file 1 and seen "+counter+ " time(s)");
							}
							counterlist.add(counter);
							
							counter = 0;
					}
					//if checkbox 2 is selected do...
					if(cbox2.isSelected())
					{
							while(f1.myScanner2.hasNext())
							{
									String line2 = f1.myScanner2.nextLine();
									//check if line contains searched word
									if(line2.contains(referencedWord))
									{
											counter++;
									}
							}
							if(counter == 0)
							{
								textArea.append("\n"+ referencedWord+ " is not in file 2 ");
							}
							else {
								textArea.append("\n"+ referencedWord+ " is in file 2 and seen "+counter+ " time(s)");
							}
							counterlist.add(counter);
							
							counter = 0;
				}	//if checkbox 3 is selected do...
					if(cbox3.isSelected())
					{
							while(f1.myScanner3.hasNext())
							{
									String line3 = f1.myScanner3.nextLine();
									//check if line contains searched word
									if(line3.contains(referencedWord))
									{
											counter++;
									}
							}
							if(counter == 0)
							{
								textArea.append("\n"+ referencedWord+ " is not in file 3 ");
							}
							else {
								textArea.append("\n"+ referencedWord+ " is in file 3 and seen "+counter+ " time(s)");
							}
							counterlist.add(counter);
							
							counter = 0;
						}
					//checkbox 4 is selected do....
					if(cbox4.isSelected())
					{
							while(f1.myScanner4.hasNext())
							{
									String line4 = f1.myScanner4.nextLine();
									//check if line contains searched word
									if(line4.contains(referencedWord))
									{
											counter++;
									}
							}
							if(counter == 0)
							{
								textArea.append("\n"+ referencedWord+ " is not in file 4 ");
							}
							else {
								textArea.append("\n"+ referencedWord+ " is in file 4 and seen "+counter+ " time(s)");
							}
							counterlist.add(counter);
							
							counter = 0;
					}
					textArea.setVisible(true);
					//Collections.sort(counterlist, Collections.reverseOrder());
					if(counterlist.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "You haven't Select Any File to be Searched");
					}
					else
						textArea.append("\n\nStrongest matching file displayed in the order below:");
						textArea.append("\n[file1, file2, file3, file4]");
						textArea.append("\n\n "+counterlist.toString());
					
				
				}
		//if checkbox 1 is pressed do...
		if(e.getSource() == cbox1)
		{
			
			//try catch method to scan the find 
			try{
				f1.myScanner1 = new Scanner(f1.myFile1);
			} catch(FileNotFoundException e1) {
				e1.printStackTrace();
			}
		//if a comma is seen, it creates a new line
		f1.myScanner1.useDelimiter(",");
		
		}
		//if checkbox 2 is pressed do...		
		if(e.getSource() == cbox2)
		{
			
			
			try{
				f1.myScanner2 = new Scanner(f1.myFile2);
			} catch(FileNotFoundException e1) {
				e1.printStackTrace();
			}
		//if a comma is seen, it creates a new line
		f1.myScanner2.useDelimiter(",");
		
		}
		//if checkbox 3 is pressed do...
		if(e.getSource() == cbox3)
		{
			
			
			try{
				f1.myScanner3 = new Scanner(f1.myFile3);
			} catch(FileNotFoundException e1) {
				e1.printStackTrace();
			}
		//if a comma is seen, it creates a new line
		f1.myScanner3.useDelimiter(",");
		
		}
		
		//if checkbox 4 is pressed do...
		if(e.getSource() == cbox4)
		{
			
			
			try{
				f1.myScanner4 = new Scanner(f1.myFile4);
			} catch(FileNotFoundException e1) {
				e1.printStackTrace();
			}
		//if a comma is seen, it creates a new line
		f1.myScanner4.useDelimiter(",");
		}
	}	
		
		//runs the GUI	
		public SearchEngine() 
		{
			gui();
		}
	
	
}
