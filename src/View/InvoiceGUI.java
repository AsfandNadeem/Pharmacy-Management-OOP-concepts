package View;
import javax.swing.*;
import javax.swing.text.Caret;

import Model.MedicineDetail;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Random;


public class InvoiceGUI extends JFrame {


	private JLabel salesid;
	private JLabel productid;
	private JLabel productname;
	private JLabel quantity;
	private JLabel price;
	private JLabel date;
	private JLabel Total;
	private JLabel blank;
	
	private JTextField salesidT;
	private JTextField productidT;
	private JTextField productnameT;
	private JTextField quantityT;
	private JTextField priceT;
	private JTextField dateT;
	private JTextField TotalT;
	
	private JButton newsales;
	private JButton mainmenu;
	private JButton addproduct;
	private JButton removeproduct;
	private JButton confirm;
	private JButton addmore;
	
	
	private JPanel medicine;
	private JPanel button;
	
	private JPanel panel;
	
	
	public InvoiceGUI(){
		super("Invoice");
		setSize(800,700);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		salesid= new JLabel("Sales ID");
		productid= new JLabel("Product ID");
		productname= new JLabel("Product Name");
		quantity= new JLabel("Quantity");
		price = new JLabel("Price");
		Total= new JLabel("Total Price");
		blank= new JLabel();
		
		salesidT=new JTextField();
		productidT=new JTextField();
		productnameT= new JTextField();
		quantityT= new JTextField();
		priceT= new JTextField();
		TotalT= new JTextField();
		
		salesid.setBorder(BorderFactory.createEtchedBorder(0));
		productid.setBorder(BorderFactory.createEtchedBorder(0));
		productname.setBorder(BorderFactory.createEtchedBorder(0));
		quantity.setBorder(BorderFactory.createEtchedBorder(0));
		price.setBorder(BorderFactory.createEtchedBorder(0));
		Total.setBorder(BorderFactory.createEtchedBorder(0));
		blank.setBorder(BorderFactory.createEtchedBorder(0));;
		
		
		
		
		salesidT.setBorder(BorderFactory.createEtchedBorder(0));
		productidT.setBorder(BorderFactory.createEtchedBorder(0));
		productnameT.setBorder(BorderFactory.createEtchedBorder(0));
		quantityT.setBorder(BorderFactory.createEtchedBorder(0));
		priceT.setBorder(BorderFactory.createEtchedBorder(0));
		TotalT.setBorder(BorderFactory.createEtchedBorder(0));
		
		
		
		salesid.setBounds(10, 10, 150, 35);	
	productid.setBounds(10,60,150,35);
		productname.setBounds(10,110,150,35);
		quantity.setBounds(10,160,150,35);
		price.setBounds(10,210,150,35);
		Total.setBounds(10,260,150,35);
		blank.setBounds(10, 160, 150, 35);
	
		salesidT.setBounds(150, 10, 200, 35);	
		productidT.setBounds(150,60,200,35);
			productnameT.setBounds(150,110,200,35);
			quantityT.setBounds(150,160,200,35);
			priceT.setBounds(150,210,200,35);
			TotalT.setBounds(150,260,200,35);
		
		
		newsales= new JButton("New Sales");
		addproduct= new JButton("Add Medicine");
		confirm= new JButton("Confirm Sales");
		mainmenu= new JButton("Main menu");
		addmore= new JButton("Next Medicine");
		
		newsales.setBorder(BorderFactory.createEtchedBorder(0));
		addproduct.setBorder(BorderFactory.createEtchedBorder(0));
		confirm.setBorder(BorderFactory.createEtchedBorder(0));
		mainmenu.setBorder(BorderFactory.createEtchedBorder(0));
		addmore.setBorder(BorderFactory.createEtchedBorder(0));
		
		newsales.setBounds(10, 300, 200, 35);
		addproduct.setBounds(10,350 , 200, 35);
		confirm.setBounds(10, 400, 200, 35);
		addmore.setBounds(10, 450, 200, 35);
		mainmenu.setBounds(10, 500, 200, 35);
		
		panel=new JPanel();
		panel.setSize(200,200);
		panel.setLayout(new GridLayout(10,5));
		panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		
		
		add(newsales);
		add(addproduct);
		add(confirm);
		add(addmore);
		add(mainmenu);
		
		
		add(salesid);
		add(productid);
		add(productname);
		add(quantity);
		add(price);
		add(Total);
		add(blank);
		
		add(salesidT);
		add(productidT);
		add(productnameT);
		add(quantityT);
		add(priceT);
		add(TotalT);
		add(blank);
		
		
		
		Listener A= new Listener();
		newsales.addActionListener(A);
		addproduct.addActionListener(A);
		confirm.addActionListener(A);
		mainmenu.addActionListener(A);
		addmore.addActionListener(A);
		
		
		setVisible(true);
		
	}
	private Object GridLayout(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
	public class Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent A){
			if(A.getSource()==mainmenu){
				new MainMenu().setVisible(true);
				dispose();
			}
			
			
			else if (A.getSource()==newsales){
				 Random r = new Random();
			        int x = r.nextInt(10000);
			        salesidT.setText("" +x);
			    }
			if (A.getSource()==newsales){
				productidT.setText("");
				productnameT.setText("");
				quantityT.setText("");
				priceT.setText("");
				TotalT.setText("");
			}
			if(A.getSource()==addproduct){
				MedicineDetail MS;
				try {
					ObjectInputStream x = new ObjectInputStream(new FileInputStream("MList.ser"));
					while (true) 
					{
						MS = (MedicineDetail) x.readObject();
						if (MS.getName().equalsIgnoreCase(productnameT.getText())) {
							Integer q= Integer.parseInt(MS.getQuantity());
						
							if(q<=0){
								JOptionPane.showMessageDialog(null, "No Quantity");
							}
							
							else {productidT.setText(MS.getId());
							priceT.setText(MS.getCost());}
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
			
			if(A.getSource()==confirm){
				
				
				int total;
				Integer q=Integer.parseInt(quantityT.getText());
				Integer p= Integer.parseInt(priceT.getText());
				
				total= q*p;
				String numberAsString = Integer.toString(total);
				TotalT.setText(numberAsString);

				
				
			
			}
			if(A.getSource()==addmore){
				productidT.setText(null);
				productnameT.setText(null);
				quantityT.setText(null);
				priceT.setText(null);
				
			
				
			}
				
			
			
			}
			}
		
		}


