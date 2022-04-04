package com.test.OOP;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchEngine extends JFrame implements ActionListener {
	
	// attributes
	
	JButton sbutton;
	JPanel panel;
	JTextField field1;
	String referenceWord;
	static String l;
	
	SearchEngine(String title){
		
		// dimension of GUI
		super(title);
		setSize(500,500);
		setLayout(new FlowLayout());
		
		
		// search button
		sbutton = new JButton("SEARCH FOR MY FILE");
		
		//method to listen for button clicks
		sbutton.addActionListener(this);
		
		// text field
		field1 = new JTextField();
		field1.setText("Enter Words in the File");
		
		//panel
		panel = new JPanel(new FlowLayout());
		panel.setBackground(Color.pink);
		panel.add(sbutton);
		panel.add(field1);
		add(panel);
		
		// makes GUI visible
		setVisible(true);
		
		
	}

	public void actionPerformed(ActionEvent e) {
	
		//what happens when button is clicked
		if(sbutton == e.getSource())
		{
			FileProccessor fileProcess = new FileProccessor ("example.txt");
			fileProcess.openFile();
			String line = fileProcess.readLines();
			l = FileProccessor.line;
			
			referenceWord = field1.getText();
			System.out.println(referenceWord);
			
			//if statement to check if file contains referenced word
			if(l.contains(referenceWord)){
				JOptionPane.showMessageDialog(this, "Your file contains this word");
				
			}
			
			else {
				JOptionPane.showMessageDialog(this, "Your file does not contains this word");
			}		
			
	
			
		}
	}

}
