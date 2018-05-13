package View;

import java.awt.*;
import javax.swing.*;

import Model.Address;
import Model.Date;
import Model.Employee;
import Model.LoginCreate;

import java.awt.event.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AddLoginGUI extends JFrame  {

private JTextField loginname;
private JTextField loginpassword;
private JLabel user;
private JLabel password;
private JButton loginbtn;
private JButton backbtn;


AddLoginGUI(){
	super("Create Log-in"); 
	setSize(520,150);
	setLayout(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	user=new JLabel("New Username");
	password= new JLabel("New Password");
	
	
	loginbtn=new JButton("Save Login");
	backbtn= new JButton("Back");
	
	
	loginname= new JTextField();
	loginpassword= new JTextField();
	
	
	
	
	
	user.setBounds(10,10,100,20);
	password.setBounds(10,30,100,20);
	
	loginname.setBounds(140, 10, 300, 20);
	loginpassword.setBounds(140, 30,300, 20);
	
	
	loginbtn.setBounds(140,55,100,20);
	
	backbtn.setBounds(340,55,100,20);
	
	
	

	add(user);
	add(password);
	add(loginname);
	add(loginpassword);
	add(loginpassword);
	add(loginbtn);
	
	add(backbtn);
	
	loginbtn.addActionListener(new buttonlistener());
	backbtn.addActionListener(new buttonlistener());
	setVisible(true);

}
public class buttonlistener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		
	LoginCreate L =new LoginCreate(loginname.getText(),loginpassword.getText());
				
	boolean success = false;
	ObjectOutputStream outputStream = null;
	if(e.getSource()==loginbtn)
	{
	try {
               // Read old objects
		ArrayList<LoginCreate> LoginCreateList = readAllData();
		// Append new object into existing list
		LoginCreateList.add(L);
		// Open Stream for writing
		outputStream = new ObjectOutputStream(new FileOutputStream("LoginCreateList.ser"));
		
		// Write all objects (old and new one) into the file
		for(int i = 0 ; i < LoginCreateList.size() ; i++) {
			outputStream.writeObject(LoginCreateList.get(i));
		}
	} catch(IOException a) {
		System.out.println("IO Exception while opening file");
	} finally { // cleanup code which closes output stream if its object was created
		try {
			if(outputStream != null) {
				outputStream.close();
				// flag of success
				
			}
			JOptionPane.showMessageDialog(new JFrame(),"Saved!");
		} catch (IOException a) {
			System.out.println("IO Exception while closing file");
		}
	}
	}
	
		
	else if (e.getSource() == backbtn)
			 {
		        	new SplashScreen().setVisible(true);
		            dispose();
				}
			 
			
			
		}
                   
	}
           

   public ArrayList<LoginCreate>  readAllData ()
                   {
                     //  ArrayList initialized with size 0
	ArrayList<LoginCreate> LoginCreateList = new ArrayList<LoginCreate>(0);
	// Input stream
	ObjectInputStream inputStream = null;
	try
	{
		// open file for reading
		inputStream = new ObjectInputStream(new FileInputStream("LoginCreateList.ser"));
		// End Of File flag
		boolean EOF = false;
		// Keep reading file until file ends
		while(!EOF) {
			try {
				// read object and type cast into CarDetails object
				LoginCreate myObj = (LoginCreate) inputStream.readObject();
				// add object into ArrayList
				LoginCreateList.add(myObj);
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
	return LoginCreateList;
}
	
}
	


