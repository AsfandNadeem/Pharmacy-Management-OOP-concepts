package View;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
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

 

public class EditMedicineForm extends JFrame {

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
	private MedicineDetail medicine;
	
	private JButton save;
	private JButton backbtn;
	
	public EditMedicineForm (MedicineDetail M)
	{
		
		
		super("Add a medicine");
		setSize(800,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(13,2));
		medicine=M;
		
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
		
		save=new JButton("Edit and Save");
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
		
		nameT.setText(medicine.getName());
		IdT.setText(medicine.getId());
		MDateT.setText(medicine.getManufacturing().getDate());
		MMonthT.setText(medicine.getManufacturing().getMonth());
		MYearT.setText(medicine.getManufacturing().getYear());
		EDateT.setText(medicine.getExpiry().getDate());
		EMonthT.setText(medicine.getExpiry().getMonth());
		EYearT.setText(medicine.getExpiry().getYear());
		CNameT.setText(medicine.getMa().getName());
		CLicenseT.setText(medicine.getMa().getLicense());
		MQuantityT.setText(medicine.getQuantity());
		MCostT.setText(medicine.getCost());
		
	
		
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
				
				if (a.getSource()==backbtn)
		         {
		             new MedicineDetailGUI().setVisible(true);
		             dispose();
		         }
	
    boolean success = false;
		ObjectOutputStream outputStream = null;
		
	
		 if (a.getSource()==save)
        {
            MedicineDetail Ma;
            
            ArrayList<MedicineDetail> medicineList = readAllData() ;
            File file = new File("MList.ser");
            String name = nameT.getText();
            
            for(int i = 0 ; i<medicineList.size() ; i++){
            	if(medicineList.get(i).getName().equalsIgnoreCase(name))
            	{
            		medicineList.remove(i);
            		Date M=new Date(MDateT.getText(),MMonthT.getText(),MYearT.getText());
            		Date E=new Date(EDateT.getText(),EMonthT.getText(),EYearT.getText());
            		Company C=new Company(CNameT.getText(),CLicenseT.getText());
            		 medicineList.add( new MedicineDetail(nameT.getText(),IdT.getText(),M,E,C,MQuantityT.getText(),MCostT.getText()));
            		JOptionPane.showMessageDialog(new JFrame(),"Succesfully Edited!");
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
				
			
					
			
		
		
}}
	


