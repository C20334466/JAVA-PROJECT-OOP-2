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
	
	SearchEngine(String title){
		
		// dimension of GUI
		super(title);
		setSize(500,500);
		setLayout(new FlowLayout());
		
		
		// search button
		sbutton = new JButton("SEARCH FOR MY FILE");
		
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
		// TODO Auto-generated method stub
		
		if(sbutton == e.getSource())
		{
			referenceWord = field1.getText();
			JOptionPane.showMessageDialog(this, referenceWord);
			/*
			FileProccessor fileProcess = new FileProccessor ("example.txt");
			fileProcess.openFile();
			String line = fileProcess.readLines();
			*/
		}
	}

}
