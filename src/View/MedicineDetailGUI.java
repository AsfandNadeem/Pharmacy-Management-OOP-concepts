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


public class MedicineDetailGUI extends JFrame {
    
    
	private JButton addmedicinebtn;
    private JButton deletemedicinebtn;
    private JButton editmedicinebtn;
    private JPanel backpanel;
    private JButton searchbtn;
    private JButton backbtn;
    private JButton exitbtn;
    private JLabel labeltop;
    private JMenuBar menuBar;
    
    public MedicineDetailGUI ()
    {
        super("Medicine Management Frmae");
       setSize(800,700);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        labeltop = new JLabel("Medicine Record");
        labeltop.setFont(new Font("Ariel", Font.BOLD, 40));
        labeltop.setBounds(245, 50, 700, 50);
        
        add(labeltop);
	
	
	addmedicinebtn=new JButton("Add Medicine");
	addmedicinebtn.setBounds(250, 270, 300, 35);
	addmedicinebtn.setFont(new Font(null, Font.BOLD, 15));
  	add(addmedicinebtn);
  	
  	deletemedicinebtn=new JButton("Delete Medicine");
  	deletemedicinebtn.setBounds(250, 320, 300, 35);
  	deletemedicinebtn.setFont(new Font(null, Font.BOLD, 15));
  	add(deletemedicinebtn);
  	
  	editmedicinebtn=new JButton("Edit Medicine");
  	editmedicinebtn.setFont(new Font(null, Font.BOLD, 15));
  	editmedicinebtn.setBounds(250, 370, 300, 35);
	add(editmedicinebtn);
  	
  	searchbtn=new JButton("Search Medicine");
  	searchbtn.setFont(new Font(null, Font.BOLD, 15));
  	searchbtn.setBounds(250, 420, 300, 35);
	add(searchbtn);
  	
  
  	
  	backbtn=new JButton("Back");
  	backbtn.setBounds(100, 520, 90, 25);
  	add(backbtn);
  	
  	
  	exitbtn=new JButton("Exit");
  	exitbtn.setBounds(600, 520, 90, 25);
  	add(exitbtn);
  	
  	Listener a=new Listener();
  	addmedicinebtn.addActionListener(a);
  	deletemedicinebtn.addActionListener(a);
  	editmedicinebtn.addActionListener(a);
  	searchbtn.addActionListener(a);
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
            
            if (e.getSource()==addmedicinebtn||e.equals("Add"))
            {
            	new AddMedicineGUI().setVisible(true);
                dispose();
            }
            else if (e.getSource()==deletemedicinebtn||e.equals("Delete"))
            {
            	new  DeleteMedicineGUI ().setVisible(true);
                dispose();
            }
            else if (e.getSource()==searchbtn||e.equals("Search"))
            {
            	new SearchMedicineGUI().setVisible(true);
                dispose();
            }
            else if (e.getSource()==editmedicinebtn||e.equals("Search"))
            {
            	new EditMedicineGUI().setVisible(true);
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
