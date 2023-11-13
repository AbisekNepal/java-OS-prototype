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

public class greetingScreen extends JFrame implements ActionListener{
	
	private JLabel fullNameLabel; //Declaring the label
	private JPanel centerPanel,southPanel;
	private JButton letsGo;
	
	public greetingScreen() {
		
		super("AbisekOS");

		fullNameLabel = new JLabel("Hello !\n Welcome !\n Namaste !");
		fullNameLabel.setForeground(Color.white);
		centerPanel = new JPanel();
		centerPanel.add(fullNameLabel);
		centerPanel.setBackground(Color.blue);

			add(centerPanel, BorderLayout.CENTER);
			
		letsGo = new JButton("Let's Go>>>");
		southPanel = new JPanel();
		southPanel.add(letsGo);
		
			add(southPanel,BorderLayout.SOUTH);
			
			
		letsGo.addActionListener(this);
		setLocationRelativeTo(null);
		setVisible(true);
		setSize(250,120);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	public static void main(String[] args) {
		greetingScreen app = new greetingScreen();
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==letsGo) {
			openLoginScreen();
		}
	}

	private void openLoginScreen() {
		dispose();
        new loginOS();
	}

}
