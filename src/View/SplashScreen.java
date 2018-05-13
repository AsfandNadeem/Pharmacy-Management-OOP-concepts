package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SplashScreen extends JFrame {
	private JLabel background;
	private JButton login;
	private JButton Newlogin;
	private ImageIcon medic;
	
public SplashScreen(){
	super("  ");
	setSize(300,300);
	setLayout(new BorderLayout());
	
	medic= new ImageIcon(getClass().getResource("medic.jpg"));
	background= new JLabel(medic);
	
	login= new JButton("Login");
	login.setBounds(30,30,100,20);
	login.addActionListener(new ButtonListener());
	
	Newlogin= new JButton("Sign Up");
	Newlogin.setBounds(160,30,100,20);
	Newlogin.addActionListener(new ButtonListener());
	
add(login);
add(Newlogin);
	add(background);
	setVisible (true);
}
private class ButtonListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==login){
			new Login().setVisible(true);
			dispose();
		}
		
		else if(e.getSource()==Newlogin){
			new AddLoginGUI().setVisible(true);
			dispose();
		}
		
	}
}


}
