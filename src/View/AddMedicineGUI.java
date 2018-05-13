package View;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
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

import Model.Company;
import Model.Date;
import Model.MedicineDetail;
 

public class AddMedicineGUI extends JFrame {

	private JLabel name;
	private JLabel ID;
	private JLabel MDate;
	private JLabel MMonth;
	private JLabel MYear;
	private JLabel EDate;
	private JLabel EMonth;
	private JLabel EYear;
	private JLabel CName;
	private JLabel CLicense;
	private JLabel MQuantity;
	private JLabel MCost;
	
	private JTextField nameT;
	private JTextField IdT;
	private JTextField MDateT;
	private JTextField MMonthT;
	private JTextField MYearT;
	private JTextField EDateT;
	private JTextField EMonthT;
	private JTextField EYearT;
	private JTextField CNameT;
	private JTextField CLicenseT;
	private JTextField MQuantityT;
	private JTextField MCostT;
	
	private JButton save;
	private JButton backbtn;
	
	public AddMedicineGUI ()
	{
		super("Add a medicine");
		setSize(800,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(13,2));
		
		name=new JLabel("  Medicine Name: ");
		ID=new JLabel("  Medicine ID: ");
		MDate=new JLabel("  Manufacturing date: ");
		MMonth=new JLabel("  Manufacturing Month: ");
		MYear=new JLabel("  Manufacturing Year: ");
		EDate=new JLabel("  Expiry date: ");
		EMonth=new JLabel("  Expiry Month: ");
		EYear=new JLabel("  Expiry Year: ");
		CName=new JLabel("  Comapny name: ");
		CLicense=new JLabel("  Company License number: ");
		MQuantity=new JLabel("  Medicine Quantity: ");
		MCost=new JLabel("  Price: ");
		
		nameT=new JTextField();
		IdT=new JTextField();
		MDateT=new JTextField();
		MMonthT=new JTextField();
		MYearT=new JTextField();
		EDateT=new JTextField();
		EMonthT=new JTextField();
		EYearT=new JTextField();
		CNameT=new JTextField();
		CLicenseT=new JTextField();
		MQuantityT=new JTextField();
		MCostT=new JTextField();
		
		save=new JButton("Save");
		backbtn=new JButton("Back");
				
		add(name);
		add(nameT);
		add(ID);
		add(IdT);
		add(MDate);
		add(MDateT);
		add(MMonth);
		add(MMonthT);
		add(MYear);
		add(MYearT);
		add(EDate);
		add(EDateT);
		add(EMonth);
		add(EMonthT);
		add(EYear);
		add(EYearT);
		add(CName);
		add(CNameT);
		add(CLicense);
		add(CLicenseT);
		add(MQuantity);
		add(MQuantityT);
		add(MCost);
		add(MCostT);
		
		add(backbtn);
        add(save);
		Listener A=new Listener();
		save.addActionListener(A);
		backbtn.addActionListener(A);		
		
		setVisible(true);
	}
		
		private class Listener implements ActionListener
		{
			public void actionPerformed( ActionEvent a)
			{
				
				
	Date M=new Date(MDateT.getText(),MMonthT.getText(),MYearT.getText());
	Date E=new Date(EDateT.getText(),EMonthT.getText(),EYearT.getText());
	Company C=new Company(CNameT.getText(),CLicenseT.getText());
	MedicineDetail Me=new MedicineDetail(nameT.getText(),IdT.getText(),M,E,C,MQuantityT.getText(),MCostT.getText());
				
	
    boolean success = false;
		ObjectOutputStream outputStream = null;
		if(a.getSource()==save)
		{
		try {
                   // Read old objects
			ArrayList<MedicineDetail> MedicineList = readAllData();
			// Append new object into existing list
			MedicineList.add(Me);
			// Open Stream for writing
			outputStream = new ObjectOutputStream(new FileOutputStream("MList.ser"));
			
			// Write all objects (old and new one) into the file
			for(int i = 0 ; i < MedicineList.size() ; i++) {
				outputStream.writeObject(MedicineList.get(i));
			}
		} catch(IOException e) {
			System.out.println("IO Exception while opening file");
		} finally { // cleanup code which closes output stream if its object was created
			try {
				if(outputStream != null) {
					outputStream.close();
					// flag of success
					
				}
				JOptionPane.showMessageDialog(new JFrame(),"Saved!");
			} catch (IOException e) {
				System.out.println("IO Exception while closing file");
			}
		}
		}
		
			
		else if (a.getSource() == backbtn)
				 {
			        	new MedicineDetailGUI().setVisible(true);
			            dispose();
					}
				 
				
				
			}
                       
		}
               
	
       public ArrayList<MedicineDetail>  readAllData ()
                       {
                         //  ArrayList initialized with size 0
		ArrayList<MedicineDetail> MedicineList = new ArrayList<MedicineDetail>(0);
		// Input stream
		ObjectInputStream inputStream = null;
		try
		{
			// open file for reading
			inputStream = new ObjectInputStream(new FileInputStream("MList.ser"));
			// End Of File flag
			boolean EOF = false;
			// Keep reading file until file ends
			while(!EOF) {
				try {
					// read object and type cast into CarDetails object
					MedicineDetail myObj = (MedicineDetail) inputStream.readObject();
					// add object into ArrayList
					MedicineList.add(myObj);
					//System.out.println("Read: " + myObj.getName());
				} catch (ClassNotFoundException e) {
					//System.out.println("Class not found");
				} catch (EOFException end) {
					// EOFException is raised when file ends
					// set End Of File flag to true so that loop exits
					EOF = true;
				}
			}
		} catch(FileNotFoundException e) {
			//System.out.println("Cannot find file");
		} catch (IOException e) {
			//System.out.println("IO Exception while opening stream");
			//e.printStackTrace();
		} finally { // cleanup code to close stream if it was opened
			try {
				if(inputStream != null)
					inputStream.close( );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("IO Exception while closing file");
			}
		}
		// returns ArrayList
		return MedicineList;
	}
				
			
					
			
		
		
}
	


