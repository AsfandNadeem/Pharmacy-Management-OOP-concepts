package View;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.io.*;

import Model.Employee;
import Model.MedicineDetail;

import javax.swing.*;
import java.util.ArrayList;


public class EditEmployeeGUI extends JFrame{
     
    private JButton searchbtn;
    private JButton backbtn;
    private JButton exitbtn;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField nameT;
    private  int i;
    
    public EditEmployeeGUI()
    {
        super("Edit an Employee");
        setSize(800,700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        label1 = new JLabel("Edit an Employee");
        label1.setFont(new Font("Cambria", Font.BOLD, 40));
        label1.setBounds(240, 50, 800, 50);
        add(label1);
	
	
        label3 = new JLabel("Enter Name:");
        label3.setFont(new Font("Cambira", Font.BOLD, 18));
        label3.setBounds(250, 240, 300, 25);
        add(label3);
        
        nameT = new JTextField(10);
        nameT.setBounds(250, 270, 300, 35);
        add(nameT);
	
  	searchbtn=new JButton("Search and Edit");
  	searchbtn.setBounds(250, 320, 300, 35);
         add(searchbtn);
  	
  	
  	backbtn=new JButton("Back");
  	backbtn.setBounds(100, 520, 90, 25);
  	add(backbtn);
  	
  	
  	exitbtn=new JButton("Exit");
  	exitbtn.setBounds(600, 520, 90, 25);
  	add(exitbtn);
  	
  	EditListener a=new EditListener();
  	searchbtn.addActionListener(a);
  	backbtn.addActionListener(a);
  	exitbtn.addActionListener(a);
  	
  	
  	setVisible(true);
    }
    private class EditListener implements ActionListener{
    public void actionPerformed(ActionEvent e)
    	    {
    	    	 if (e.getSource()==backbtn)
    	         {
    	             new EmployeeDetailGUI().setVisible(true);
    	             dispose();
    	         }
    	        
    	        else if (e.getSource()==searchbtn)
    	        {
    	       	 Employee M;
    	            
    	            ArrayList<Employee> EmployeeList = readAllData() ;
    	            File file = new File("EList.ser");
    	            String name = nameT.getText();
    	          
    	           for(int i=0;i<EmployeeList.size();i++)
    	           {
    	              M = (Employee) EmployeeList.get(i);
    	               String x=M.getName();
    	               if (x.equals(name))
    	               {
    	                   new EditEmployeeForm(M).setVisible(true);
    	                   dispose();
    	                   break;
    	               }
    	           }
    	           if (i>=EmployeeList.size())
    	           {
    	           JOptionPane.showMessageDialog(null, "Record Not Found");
    	           }
    	       }
    	       
    	       else if (e.getSource()==exitbtn)
    	       {
    	       	System.exit(1);
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
