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
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Address;
import Model.Company;
import Model.Date;
import Model.Employee;

 

public class AddEmployeeGUI extends JFrame {

	private JLabel name;
	private JLabel ID;
	private JLabel EDate;
	private JLabel EMonth;
	private JLabel EYear;
	private JLabel EHouse;
	private JLabel EStreet;
	private JLabel ETown;
	private JLabel EPhone;
	private JLabel EEmail;
	private JLabel ESalary;
	private JLabel EPost;
	
	private JTextField nameT;
	private JTextField IdT;
	private JTextField EDateT;
	private JTextField EMonthT;
	private JTextField EYearT;
	private JTextField EHouseT;
	private JTextField EStreetT;
	private JTextField ETownT;
	private JTextField EPhoneT;
	private JTextField EEmailT;
	private JTextField ESalaryT;
	private JTextField EPostT;
	
	private JButton save;
	private JButton backbtn;
	
	public AddEmployeeGUI ()
	{
		super("Add an Employee");
		setSize(800,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(13,2));
		
		name=new JLabel("  Employee Name: ");
		ID=new JLabel("  Employee ID: ");
		EDate=new JLabel("  Employee Date of Birth: ");
		EMonth=new JLabel("  Employee Month of Birth: ");
		EYear=new JLabel("  Employee Year of Birth: ");
		EHouse=new JLabel("  Employee House No.: ");
		EStreet=new JLabel("  Employee Street No.: ");
		ETown=new JLabel("  Employee Town No.: ");
		EPhone=new JLabel("  Phone no.: ");
		EEmail=new JLabel("  Email: ");
		ESalary=new JLabel("  Employee Salary: ");
		EPost=new JLabel("  Employee Post: ");
		
		
		
		nameT=new JTextField();
		IdT=new JTextField();
		Random r = new Random();
        int x = r.nextInt(10000);
        IdT.setText("" +x);
		EDateT=new JTextField();
		EMonthT=new JTextField();
		EYearT=new JTextField();
		EHouseT=new JTextField();
		EStreetT=new JTextField();
		ETownT=new JTextField();
		EPhoneT=new JTextField();
		EEmailT=new JTextField();
		ESalaryT=new JTextField();
		EPostT=new JTextField();
		
		save=new JButton("Save");
		backbtn=new JButton("Back");
				
		add(name);
		add(nameT);
		add(EDate);
		add(EDateT);
		add(EMonth);
		add(EMonthT);
		add(EYear);
		add(EYearT);
		add(EHouse);
		add(EHouseT);
		add(EStreet);
		add(EStreetT);
		add(ETown);
		add(ETownT);
		add(EPhone);
		add(EPhoneT);
		add(EEmail);
		add(EEmailT);
		add(ESalary);
		add(ESalaryT);
		add(ID);
		add(IdT);
		add(EPost);
		add(EPostT);
		
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
	Date D=new Date(EDateT.getText(),EMonthT.getText(),EYearT.getText());
	Address A=new Address(EHouseT.getText(),EStreetT.getText(),ETownT.getText());
	Employee Me=new Employee(nameT.getText(),D,A,EPhoneT.getText(),EEmailT.getText(),ESalaryT.getText(),IdT.getText(),EPostT.getText());
				
	boolean success = false;
	ObjectOutputStream outputStream = null;
	if(a.getSource()==save)
	{
	try {
               // Read old objects
		ArrayList<Employee> EmployeeList = readAllData();
		// Append new object into existing list
		EmployeeList.add(Me);
		// Open Stream for writing
		outputStream = new ObjectOutputStream(new FileOutputStream("EList.ser"));
		 
		// Write all objects (old and new one) into the file
		for(int i = 0 ; i < EmployeeList.size() ; i++) {
			outputStream.writeObject(EmployeeList.get(i));
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
		        	new EmployeeDetailGUI().setVisible(true);
		            dispose();
				}
			 
			
			
		}
                   
	}
           

   public ArrayList<Employee>  readAllData ()
                   {
                     //  ArrayList initialized with size 0
	ArrayList<Employee> EmployeeList = new ArrayList<Employee>(0);
	// Input stream
	ObjectInputStream inputStream = null;
	try
	{
		// open file for reading
		inputStream = new ObjectInputStream(new FileInputStream("EList.ser"));
		// End Of File flag
		boolean EOF = false;
		// Keep reading file until file ends
		while(!EOF) {
			try {
				// read object and type cast into CarDetails object
				Employee myObj = (Employee) inputStream.readObject();
				// add object into ArrayList
				EmployeeList.add(myObj);
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
	return EmployeeList;
}
			
		
				
		
		
}
	



