package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{
private JFrame frame;
private JPanel centerpanel;
private JPanel exitpanel;
private JButton invoicebtn;
private JButton medicinebtn;
private JButton employeebtn;
private JButton exitbtn;
private ImageIcon invoicebck;
private ImageIcon medicinebck;
private ImageIcon employeebck;
private JLabel main;
public MainMenu(){
	super("Main Menu");

setSize(700,400);
	setLayout(new BorderLayout());

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main= new JLabel("         WELCOME TO THE PHARMACY");
	main.setFont(new Font("Ariel",Font.PLAIN,36));
	 add(main,BorderLayout.NORTH);
	 
	 centerpanel=new JPanel();
	 centerpanel.setLayout(new FlowLayout());
invoicebck= new ImageIcon(getClass().getResource("invoicej.jpg"));
medicinebck= new ImageIcon(getClass().getResource("Medicinejj.jpg"));
employeebck= new ImageIcon(getClass().getResource("employeej.jpg"));
employeebtn= new JButton(employeebck);
medicinebtn= new JButton(medicinebck);
invoicebtn=new JButton(invoicebck);
invoicebtn.setPreferredSize(new Dimension(175,175));
medicinebtn.setPreferredSize(new Dimension(175, 175));
employeebtn.setPreferredSize(new Dimension(175,175));
centerpanel.add(invoicebtn);
centerpanel.add(medicinebtn);
centerpanel.add(employeebtn);
add(centerpanel,BorderLayout.CENTER);
exitpanel=new JPanel();
exitbtn=new JButton("Exit");
	exitpanel.add(exitbtn);
	add(exitpanel,BorderLayout.SOUTH);

Listener h=new Listener();
invoicebtn.addActionListener(h);
medicinebtn.addActionListener(h);
employeebtn.addActionListener(h);
exitbtn.addActionListener(h);
	setVisible(true);
	
	
}


	
	private class Listener implements ActionListener{
	    public void actionPerformed(ActionEvent ae){
	        if (ae.getSource() == exitbtn){
	        	System.exit(1);
	        }
	        else if (ae.getSource() == invoicebtn){
	        	new InvoiceGUI().setVisible(true);
	            dispose();
	        }
	        else if (ae.getSource() == medicinebtn){
	            new MedicineDetailGUI().setVisible(true);
	            dispose();
	        }
	        else if (ae.getSource() == employeebtn){
	        	new EmployeeDetailGUI().setVisible(true);
	            dispose();
	        }
	}


}
}
