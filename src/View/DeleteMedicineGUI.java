package View;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.io.*;

import Model.MedicineDetail;

import javax.swing.*;
import java.util.ArrayList;


public class DeleteMedicineGUI extends JFrame{
     
    private JButton searchbtn;
    private JButton backbtn;
    private JButton exitbtn;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField nameT;
    private  int i;
    
    public DeleteMedicineGUI()
    {
        super("Delete a Medicine");
        setSize(800,700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        label1 = new JLabel("Delete a medicine");
        label1.setFont(new Font("Cambria", Font.BOLD, 40));
        label1.setBounds(245, 50, 800, 50);
        add(label1);
	
	
        label3 = new JLabel("Enter Name:");
        label3.setFont(new Font("Cambira", Font.BOLD, 18));
        label3.setBounds(250, 240, 300, 25);
        add(label3);
        
        nameT = new JTextField(10);
        nameT.setBounds(250, 270, 300, 35);
        add(nameT);
	
  	searchbtn=new JButton("Search and Delete");
  	searchbtn.setBounds(250, 320, 300, 35);
         add(searchbtn);
  	
  	
  	backbtn=new JButton("Back");
  	backbtn.setBounds(100, 520, 90, 25);
  	add(backbtn);
  	
  	
  	exitbtn=new JButton("Exit");
  	exitbtn.setBounds(600, 520, 90, 25);
  	add(exitbtn);
  	
  	DelListener a=new DelListener();
  	searchbtn.addActionListener(a);
  	backbtn.addActionListener(a);
  	exitbtn.addActionListener(a);
  	
  	
  	setVisible(true);
    }
    private class DelListener implements ActionListener{
     public void actionPerformed(ActionEvent e)
    {
    	 if (e.getSource()==backbtn)
         {
             new MedicineDetailGUI().setVisible(true);
             dispose();
         }
        
        else if (e.getSource()==searchbtn)
        {
            MedicineDetail M;
            
            ArrayList<MedicineDetail> medicineList = readAllData() ;
            File file = new File("MList.ser");
            String name = nameT.getText();
            
            for(int i = 0 ; i<medicineList.size() ; i++){
            	if(medicineList.get(i).getName().equalsIgnoreCase(name))
            	{
            		medicineList.remove(i);
            		JOptionPane.showMessageDialog(new JFrame(),"Succesfully Deleted!");
            	}
            
            }
            
            try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
				for(int i = 0 ; i<medicineList.size() ; i++){
					out.writeObject(medicineList.get(i));
				}
	            }
				
             catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    	 
        else if (e.getSource()==exitbtn)
        {
           System.exit(1);
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
