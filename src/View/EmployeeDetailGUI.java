package View;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class EmployeeDetailGUI extends JFrame {
    
    private JButton addemployeebtn;
    private JButton deleteemployeebtn;
    private JPanel backpanel;
    private JButton searchemployeebtn;
    private JButton backbtn;
    private JButton exitbtn;
    private JButton editemployeebtn;
    private JLabel labeltop;
    private JMenuBar menuBar;
    
    public EmployeeDetailGUI ()
    {
        super("Employee Management Frmae");
       setSize(800,700);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        labeltop = new JLabel("Employee Record");
        labeltop.setFont(new Font("Ariel", Font.BOLD, 40));
        labeltop.setBounds(245, 50, 700, 50);
        
        add(labeltop);
	
	
	addemployeebtn=new JButton("Add Employee");
	addemployeebtn.setBounds(250, 270, 300, 35);
	addemployeebtn.setFont(new Font(null, Font.BOLD, 15));
  	add(addemployeebtn);
  	
  	deleteemployeebtn=new JButton("Delete Employee");
  	deleteemployeebtn.setBounds(250, 320, 300, 35);
  	deleteemployeebtn.setFont(new Font(null, Font.BOLD, 15));
  	add(deleteemployeebtn);
  	
  	editemployeebtn=new JButton("Edit Employee");
  	editemployeebtn.setFont(new Font(null, Font.BOLD, 15));
  	editemployeebtn.setBounds(250, 370, 300, 35);
	add(editemployeebtn);
	
	searchemployeebtn=new JButton("Search Employee");
  	searchemployeebtn.setFont(new Font(null, Font.BOLD, 15));
  	searchemployeebtn.setBounds(250, 420, 300, 35);
	add(searchemployeebtn);
  	
  	
  
  	
  	backbtn=new JButton("Back");
  	backbtn.setBounds(100, 520, 90, 25);
  	add(backbtn);
  	
  	
  	exitbtn=new JButton("Exit");
  	exitbtn.setBounds(600, 520, 90, 25);
  	add(exitbtn);
  	
  	Listener a=new Listener();
  	addemployeebtn.addActionListener(a);
  	deleteemployeebtn.addActionListener(a);
  	searchemployeebtn.addActionListener(a);
  	editemployeebtn.addActionListener(a);
  	backbtn.addActionListener(a);
  	exitbtn.addActionListener(a);
  	
	
  	menuBar = new JMenuBar();
  	setJMenuBar(menuBar);
	
  	JMenu optionsMenu = new JMenu("Options");
  		
	JMenuItem add = new JMenuItem("Add");
	JMenuItem edit = new JMenuItem("Edit");
	JMenuItem delete = new JMenuItem("Delete");
	JMenuItem search = new JMenuItem("Search");
	menuBar.add(optionsMenu);
	
	optionsMenu.add(add);
	optionsMenu.add(edit);
	optionsMenu.add(delete);
	optionsMenu.add(search);
	add(menuBar);
	
	menuBar.setVisible(true);
	setVisible(true);
  	
  	
  	
    }
    private class Listener implements ActionListener{           
        public void actionPerformed(ActionEvent e)
        {
            
            if (e.getSource()==addemployeebtn||e.equals("Add"))
            {
            	new AddEmployeeGUI().setVisible(true);
                dispose();
            }
            else if (e.getSource()==deleteemployeebtn||e.equals("Delete"))
            {
            	new  DeleteEmployeeGUI ().setVisible(true);
                dispose();
            }
            else if (e.getSource()==searchemployeebtn||e.equals("Search"))
            {
            	new SearchEmployeeGUI().setVisible(true);
                dispose();
            }
            else if (e.getSource()==editemployeebtn||e.equals("Search"))
            {
            	new EditEmployeeGUI().setVisible(true);
                dispose();
            }
            else if (e.getSource()==backbtn)
            {
                new MainMenu().setVisible(true);
                dispose();
            }
            else if (e.getSource()==exitbtn)
            {
                System.exit(1);
                }
        }

	
   
    }
    
}
