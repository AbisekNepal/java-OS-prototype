package SourceCodes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class loginOS extends JFrame implements ActionListener {
	private JLabel userIDLabel,userPassLabel;
	private JTextField userIDText;
	private JPasswordField userPassText;
	private JButton loginButton,signUp;
	private JPanel northPanel1, northPanel2,northPanel3,northPanel;
	
	public loginOS() {
		super("Authenticate");
		userIDLabel = new JLabel("UserID");
		userIDText = new JTextField(10);
		
		userPassLabel = new JLabel("User Password");
		userPassText = new JPasswordField(10);
		
		northPanel = new JPanel();
		northPanel1 = new JPanel();
		northPanel2 = new JPanel();
		northPanel.setLayout(new GridLayout(3,1));

		northPanel1.add(userIDLabel);
		northPanel1.add(userIDText);
		northPanel2.add(userPassLabel);
		northPanel2.add(userPassText);
		
		northPanel.add(northPanel1);
		northPanel.add(northPanel2);
		
			add(northPanel,BorderLayout.NORTH);
		
		loginButton = new JButton("Login");
		signUp = new JButton("Sign Up");
				
		northPanel3 = new JPanel();
		northPanel3.add(loginButton);
		northPanel3.add(signUp);
			northPanel.add(northPanel3);
			
			add(northPanel,BorderLayout.NORTH);
			

			loginButton.addActionListener(this);
			signUp.addActionListener(this);
			setVisible(true);
			setSize(320,150);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	

	public static void main(String[] args) {
		loginOS app = new loginOS();
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user = userIDText.getText();
		String password = userPassText.getText();
		System.out.println(user + "," +password);
		
		if(e.getSource()==loginButton) {
		
							if(user.equals("Abisek") && password.equals("password123")) {
								dispose();
								new desktop();
								
							}
							else{
								JOptionPane.showMessageDialog(null, "Wrong Credentials");  
							}
		}
		else if(e.getSource()==signUp) {
			dispose();
			new	signUpScreen();
		}
	}


	

}
