package View;
import java.awt.*;
import javax.swing.*;

import Model.Employee;
import Model.LoginCreate;

import java.awt.event.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Login extends JFrame  {

private JTextField loginname;
private JPasswordField loginpassword;
private JLabel user;
private JLabel password;
private JButton loginbtn;
private JButton exitbtn;
private JButton backbtn;


Login(){
	super("Log-in"); 
	setSize(520,150);
	setLayout(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	user=new JLabel("Username");
	password= new JLabel("Password");
	
	
	loginbtn=new JButton("Login");
	exitbtn= new JButton("Exit");
        backbtn= new JButton("Back");
        
	
	
	loginname= new JTextField();
	loginpassword= new JPasswordField();
	
	
	
	
	
	user.setBounds(10,10,100,20);
	password.setBounds(10,30,100,20);
	
	loginname.setBounds(140, 10, 300, 20);
	loginpassword.setBounds(140, 30,300, 20);
	
	
	backbtn.setBounds(140,55,100,20);
	
	exitbtn.setBounds(390,85,100,20);
        
        loginbtn.setBounds(340,55,100,20);
	
	
	

	add(user);
	add(password);
	add(loginname);
	add(loginpassword);
	add(loginpassword);
	add(loginbtn);
	add(backbtn);
	add(exitbtn);
	
	loginbtn.addActionListener(new buttonlistener());
	exitbtn.addActionListener(new buttonlistener());
                backbtn.addActionListener(new buttonlistener());
	setVisible(true);

}
public class buttonlistener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==exitbtn)
		{
			
						System.exit(1);
		}
		
		else if(e.getSource()==backbtn)
		{
			new SplashScreen().setVisible(true);
			 dispose();
		}
		
		
		else  if (e.getSource() == loginbtn) 
		{
			LoginCreate MS;
			try {
				ObjectInputStream x = new ObjectInputStream(new FileInputStream("LoginCreateList.ser"));
				while (true) 
				{
					MS = (LoginCreate) x.readObject();
					if (MS.getUsername().equals(loginname.getText())&& MS.getPassword().equals(loginpassword.getText()))
					{
						new MainMenu().setVisible(true);
						 dispose();
						 break;
					}
					
					
									}
			}catch(Exception a)
			{
				JOptionPane.showMessageDialog(new JFrame(),"Wrong Username or Password!");
				return;
			}
		}
		 
	
		 }
		 
	}



}
	


