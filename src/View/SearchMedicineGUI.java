package View;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.MedicineDetail;



public class SearchMedicineGUI extends JFrame {

	private JLabel label1;
	private JLabel NameL;
	private JLabel IDL;
	private JTextField searchNameT;
	private JTextField searchIDT;
	private JButton searchN;
	private JButton searchI;
	private JButton backbtn;
	private JButton exitbtn;
	
	public SearchMedicineGUI()
	{
		super("Search");
		setSize(800,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		label1 = new JLabel("Search a medicine");
        label1.setFont(new Font("Cambria", Font.BOLD, 40));
        label1.setBounds(240, 100, 800, 50);
        add(label1);
        
        NameL = new JLabel("Enter a name:");
        NameL.setFont(new Font("Ariel", Font.BOLD, 18));
        NameL.setBounds(250, 240, 800, 50);
        add(NameL);
        
		searchNameT = new JTextField(10);
	    searchNameT.setBounds(250, 280, 300, 35);
	    		
	  	searchN=new JButton("Search By Name");
	  	searchN.setBounds(250, 320, 300, 35);
	    	    
	  	 IDL = new JLabel("Enter an ID:");
	     IDL.setFont(new Font("Ariel", Font.BOLD, 18));
	     IDL.setBounds(250, 350, 800, 50);
	        add(IDL);
	        
		searchIDT = new JTextField(10);
		searchIDT.setBounds(250, 390, 300, 35);
		    		
		 searchI=new JButton("Search By ID");
		searchI.setBounds(250, 430, 300, 35);
	   
		
	  	backbtn=new JButton("Back");
	  	backbtn.setBounds(100, 520, 90, 25);
	  	  	
	  	exitbtn=new JButton("Exit");
	  	exitbtn.setBounds(600, 520, 90, 25);
	  	  	
		add(label1);
		add(searchNameT);
		add(searchN);
		add(searchIDT);
		add(searchI);
		add(backbtn);
		add(exitbtn);
		
		SearchListener S=new SearchListener();
		searchN.addActionListener(S);
		searchI.addActionListener(S);
		backbtn.addActionListener(S);
		exitbtn.addActionListener(S);
	}
	
	private class SearchListener implements ActionListener
	{
		public void actionPerformed( ActionEvent a)
		{

		if (a.getSource() == searchN) 
		{
			MedicineDetail MS;
			try {
				ObjectInputStream x = new ObjectInputStream(new FileInputStream("MList.ser"));
				while (true) 
				{
					MS = (MedicineDetail) x.readObject();
					if (MS.getName().equalsIgnoreCase(searchNameT.getText())) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Name : " + MS.getName() + "\nID : " + MS.getId() + "\nManufacturing Date :" + MS.getManufacturing().getDate()+"-"+MS.getManufacturing().getMonth()+"-"+MS.getManufacturing().getYear()+ "\nExpiry Date : "
										+ MS.getExpiry().getDate()+"-"+MS.getExpiry().getMonth()+"-"+MS.getExpiry().getYear() + "\nCompany Name : " + MS.getMa().getName() + "\nCompany License : " + MS.getMa().getLicense()
										+ "\nQuantity : " + MS.getQuantity() + "\nPrice : " + MS.getCost());
					
					break;
					}
				}
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(new JFrame(),"No Record Found!");
				return;
				}
		}
		if (a.getSource() == searchI) 
		{
			MedicineDetail MS;
			try {
				ObjectInputStream x = new ObjectInputStream(new FileInputStream("MList.ser"));
				while (true) 
				{
					MS = (MedicineDetail) x.readObject();
					if (MS.getId().equals(searchIDT.getText())) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Name : " + MS.getName() + "\nID : " + MS.getId() + "\nManufacturing Date :" + MS.getManufacturing().getDate()+"-"+MS.getManufacturing().getMonth()+"-"+MS.getManufacturing().getYear()+ "\nExpiry Date : "
										+ MS.getExpiry().getDate()+"-"+MS.getExpiry().getMonth()+"-"+MS.getExpiry().getYear() + "\nCompany Name : " + MS.getMa().getName() + "\nCompany License : " + MS.getMa().getLicense()
										+ "\nQuantity : " + MS.getQuantity() + "\nPrice : " + MS.getCost());
					
					break;
					}
				}
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(new JFrame(),"No Record Found!");
				return;
			}
		}
		else if(a.getSource()==backbtn)
		{
			new MedicineDetailGUI().setVisible(true);
			 dispose();
		}
		else if(a.getSource()==exitbtn)
		{
			System.exit(1);
		}
		}
		}
	}
               

			
		

