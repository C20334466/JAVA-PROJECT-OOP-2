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
	public JTextArea jt;
	
	ArrayList<Integer> counterlist = new ArrayList<Integer>();
	
	public void gui() {
		
			field1 = new JTextField("Enter Your Word Here");
			//setting up the frame of the GUI
			frame = new JFrame ("Search Engine");
			frame.setVisible(true);
			frame.setSize(400,400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//panel
			panel1 = new JPanel();
			panel1.setBackground(Color.PINK);
			add(panel1);
			
			cbox1 = new JCheckBox("File 1");
			cbox2 = new JCheckBox("File 2");
			cbox3 = new JCheckBox("File 3");
			cbox4 = new JCheckBox("File 4");
			
			label = new JLabel("Type in a word to see if its in your File");
			label.setForeground(Color.white);
			
			panel1.add(cbox1);
			panel1.add(cbox2);
			panel1.add(cbox3);
			panel1.add(cbox4);
			
			panel1.add(label);
			panel1.add(field1);
			
			sbutton1 = new JButton("Search");
			sbutton2 =  new JButton ("Clear");
			
			sbutton1.addActionListener(this);
			sbutton2.addActionListener(this);
			cbox1.addActionListener(this);
			cbox2.addActionListener(this);
			cbox3.addActionListener(this);
			cbox4.addActionListener(this);
			
			panel1.add(sbutton1);
			panel1.add(sbutton2);
			
		    frame.add(panel1);
		    jt = new JTextArea(25, 30);
		    panel1.add(jt);
		    
		    jt.setVisible(true);
		    jt.setLocation(30, 110);
		    jt.setSize(270, 200);
		    setVisible(true);
		    
		    
			
	}

	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == sbutton2)
		{
			field1.setText("");
		}
		
			
				else if(e.getSource() == sbutton1)
				{
					referencedWord = field1.getText();
					
					
					if(cbox1.isSelected())
					{
							while(f1.myScanner1.hasNext())
							{
									String line1 = f1.myScanner1.nextLine();
									
									if(line1.contains(referencedWord))
									{
											counter++;
									}
							}
							if(counter == 0)
							{
									jt.append("\n"+ referencedWord+ " is not in file 1 ");
							}
							else {
								jt.append("\n"+ referencedWord+ " is in file 1 and seen "+counter+ " time(s)");
							}
							counterlist.add(counter);
							
							counter = 0;
					}
					
					if(cbox2.isSelected())
					{
							while(f1.myScanner2.hasNext())
							{
									String line2 = f1.myScanner2.nextLine();
									
									if(line2.contains(referencedWord))
									{
											counter++;
									}
							}
							if(counter == 0)
							{
									jt.append("\n"+ referencedWord+ " is not in file 2 ");
							}
							else {
								jt.append("\n"+ referencedWord+ " is in file 2 and seen "+counter+ " time(s)");
							}
							counterlist.add(counter);
							
							counter = 0;
				}
					if(cbox3.isSelected())
					{
							while(f1.myScanner3.hasNext())
							{
									String line3 = f1.myScanner3.nextLine();
									
									if(line3.contains(referencedWord))
									{
											counter++;
									}
							}
							if(counter == 0)
							{
									jt.append("\n"+ referencedWord+ " is not in file 3 ");
							}
							else {
								jt.append("\n"+ referencedWord+ " is in file 3 and seen "+counter+ " time(s)");
							}
							counterlist.add(counter);
							
							counter = 0;
						}
					
					if(cbox4.isSelected())
					{
							while(f1.myScanner4.hasNext())
							{
									String line4 = f1.myScanner4.nextLine();
									
									if(line4.contains(referencedWord))
									{
											counter++;
									}
							}
							if(counter == 0)
							{
									jt.append("\n"+ referencedWord+ " is not in file 4 ");
							}
							else {
								jt.append("\n"+ referencedWord+ " is in file 4 and seen "+counter+ " time(s)");
							}
							counterlist.add(counter);
							
							counter = 0;
					}
					jt.setVisible(true);
					Collections.sort(counterlist, Collections.reverseOrder());
					if(counterlist.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "You haven't Select Any File to be Searched");
					}
					else
						jt.append("\n "+counterlist.toString()+" displays strongest to weakest matches");
					
				
				}
		
		if(e.getSource() == cbox1)
		{
			
			
			try{
				f1.myScanner1 = new Scanner(f1.myFile1);
			} catch(FileNotFoundException e1) {
				e1.printStackTrace();
			}
		f1.myScanner1.useDelimiter(",");
		
		}
				
		if(e.getSource() == cbox2)
		{
			
			
			try{
				f1.myScanner2 = new Scanner(f1.myFile2);
			} catch(FileNotFoundException e1) {
				e1.printStackTrace();
			}
		f1.myScanner2.useDelimiter(",");
		
		}
		
		if(e.getSource() == cbox3)
		{
			
			
			try{
				f1.myScanner3 = new Scanner(f1.myFile3);
			} catch(FileNotFoundException e1) {
				e1.printStackTrace();
			}
		f1.myScanner3.useDelimiter(",");
		
		}
		
		
		if(e.getSource() == cbox4)
		{
			
			
			try{
				f1.myScanner4 = new Scanner(f1.myFile4);
			} catch(FileNotFoundException e1) {
				e1.printStackTrace();
			}
		f1.myScanner4.useDelimiter(",");
		}
	}	
		public SearchEngine() {
			gui();
		}
	
	
}
