package SourceCodes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.image.*;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;


public class signUpScreen extends JFrame implements ActionListener{
	
	private JLabel genderLabel,addressLabel,stateLabel,zipLabel,pastOSLabel,userNameLabel,userPassLabel,label1; //Declaring the label
	private JTextField fullNameField,streetTextField,cityTextField,zipTextField,userNameField;
	private JPanel northPanel, npOne, npTwo, centerPanel, cpOne,cpTwo, southPanel, spOne,spTwo,eastPanel,westPanel;
	private JTextArea commentArea;
	private JCheckBox macOSOption,windowsOption,linuxOption;
	private JComboBox stateOption,misterMisses;
	private JRadioButton femaleOption, maleOption;
	private ButtonGroup genderGroup;
	private JButton submitButton,clearButton,backButton;
	private JPasswordField userPassField;
	private ImageIcon logo;
	
	
	
	public signUpScreen() {
		
		super("Sign Up for AbisekOS");
		
		
		//-----------Full Name Option-------------------//
		
		
		northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2,1));
		
		npOne = new JPanel();
				
		String mrMiss[] = {"Mr/Miss","Mr", "Miss","Dr."};
		misterMisses = new JComboBox(mrMiss);
		fullNameField = new JTextField(15);
		fullNameField.setText("Full Name");
		fullNameField.setForeground(Color.GRAY);
		
			npOne.add(misterMisses);
			npOne.add(fullNameField);
			northPanel.add(npOne);
			
					fullNameField.addFocusListener(new FocusListener() {
		                public void focusGained(FocusEvent e) {
		                    if (fullNameField.getText().equals("Full Name")) {
		                    	fullNameField.setText("");
		                    	fullNameField.setForeground(Color.BLACK);
		                    }
		                }
		
		                public void focusLost(FocusEvent e) {
		                    if (fullNameField.getText().isEmpty()) {
		                    	fullNameField.setText("Full Name");
		                    	fullNameField.setForeground(Color.GRAY);
		                    }
		                }
					});
		
		//-----------Gender Option-------------------//

		npTwo = new JPanel();
		
		genderLabel = new JLabel("Enter Gender:");
		femaleOption = new JRadioButton("Female");
		maleOption = new JRadioButton("Male");
		genderGroup = new ButtonGroup();
		genderGroup.add(femaleOption);
		genderGroup.add(maleOption);
		
			npTwo.add(genderLabel);
			npTwo.add(femaleOption);
			npTwo.add(maleOption);
			northPanel.add(npTwo);
			
		add(northPanel, BorderLayout.NORTH);
		
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1,2));
		
		//-----------Address Option-------------------//

		cpOne = new JPanel();
		cpOne.setLayout(new GridLayout(4,2));
		
		addressLabel = new JLabel("Address: ");
		streetTextField = new JTextField(15);
		streetTextField.setText("Street");
		cityTextField = new JTextField(15);
		cityTextField.setText("City");
		
		String stateList[] = {"State","DC", "MD","VA"};
		stateLabel = new JLabel("State: ");
		stateOption = new JComboBox(stateList);
		
		zipLabel = new JLabel("Zip Code: ");
		zipTextField = new JTextField(10);
		
			cpOne.add(addressLabel);
			cpOne.add(streetTextField);
			cpOne.add(new JLabel());
			cpOne.add(cityTextField);
			cpOne.add(stateLabel);
			cpOne.add(stateOption);
			cpOne.add(zipLabel);
			cpOne.add(zipTextField);
			centerPanel.add(cpOne);
			
						streetTextField.addFocusListener(new FocusListener() {
		                public void focusGained(FocusEvent e) {
		                    if (streetTextField.getText().equals("Street")) {
		                    	streetTextField.setText("");
		                    	streetTextField.setForeground(Color.BLACK);
		                    }
		                }
		
		                public void focusLost(FocusEvent e) {
		                    if (streetTextField.getText().isEmpty()) {
		                    	streetTextField.setText("Street");
		                    	streetTextField.setForeground(Color.GRAY);
		                    }
		                }
					});
					
						cityTextField.addFocusListener(new FocusListener() {
		                public void focusGained(FocusEvent e) {
		                    if (cityTextField.getText().equals("City")) {
		                    	cityTextField.setText("");
		                    	cityTextField.setForeground(Color.BLACK);
		                    }
		                }
		
		                public void focusLost(FocusEvent e) {
		                    if (cityTextField.getText().isEmpty()) {
		                    	cityTextField.setText("City");
		                    	cityTextField.setForeground(Color.GRAY);
		                    }
		                }
					});
			
		
		//-----------Past OS Option-------------------//

		cpTwo = new JPanel();
		cpTwo.setLayout(new GridLayout(4,1));
		
		pastOSLabel = new JLabel("Past OS:");
		pastOSLabel.setToolTipText("Check all that apply");
		macOSOption = new JCheckBox("MacOS");
		windowsOption = new JCheckBox("Windows OS");
		linuxOption = new JCheckBox("Linus OS");
		
			cpTwo.add(pastOSLabel);
			cpTwo.add(macOSOption);
			cpTwo.add(windowsOption);
			cpTwo.add(linuxOption);
			centerPanel.add(cpTwo);
		
		add(centerPanel,BorderLayout.CENTER);
		
		
		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(2,1));
		
		spOne = new JPanel();
		spOne.setLayout(new GridLayout(2,2));
		
		userNameLabel = new JLabel("Set Username");
		userNameField = new JTextField(10);
		userPassLabel = new JLabel("Set Password");
		userPassField = new JPasswordField(10);
		
			spOne.add(userNameLabel);
			spOne.add(userNameField);
			spOne.add(userPassLabel);
			spOne.add(userPassField);
			southPanel.add(spOne);
			
		spTwo = new JPanel();
		
		submitButton = new JButton("Submit");
		clearButton = new JButton("Clear");
		backButton = new JButton("Back");
		
			spTwo.add(submitButton);
			spTwo.add(clearButton);
			spTwo.add(backButton);
			southPanel.add(spTwo);
			
		add(southPanel,BorderLayout.SOUTH);
		
		eastPanel = new JPanel();
        eastPanel.setLayout(new FlowLayout()); // Use FlowLayout to center the image
        ImageIcon imageIcon = resizeImage("abisekLogo.png", 100, 100); // Resize the image to 200x200
        JLabel imageLabel = new JLabel(imageIcon);
        eastPanel.add(imageLabel);
        add(eastPanel, BorderLayout.EAST);
		
		
		westPanel = new JPanel();
		westPanel.add(new JLabel());
		add(westPanel,BorderLayout.WEST);
		
			
		
		submitButton.addActionListener(this);
		clearButton.addActionListener(this);
		backButton.addActionListener(this);

		setVisible(true);
		setSize(500,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public class UserInformation {
	    private String fullName;

	    public UserInformation() {
	        fullName = "";
	    }

	    public void setFullName(String fullName) {
	        this.fullName = fullName;
	    }

	    public String getFullName() {
	        return fullName;
	    }
	}

	
	public static void main(String[] args) {
		signUpScreen app = new signUpScreen();
	}

	public void actionPerformed(ActionEvent event) {
	    if (event.getSource() == submitButton) {
	    	dispose();
	        System.out.println("Submit Button was clicked");
	        new desktop();
	    } else if (event.getSource() == clearButton) {
	        fullNameField.setText("Full Name");
	        misterMisses.setSelectedIndex(0);
	        stateOption.setSelectedIndex(0);
	        streetTextField.setText("Street");
	        cityTextField.setText("City");
	        zipTextField.setText("");	        
	        genderGroup.clearSelection();
	        userNameField.setText("");
	        userPassField.setText("");
	        
	    } else if (event.getSource() == backButton) {
	        dispose();
	        new loginOS();
	    }
	}

	private ImageIcon resizeImage(String imagePath, int width, int height) {
	    try {
	        BufferedImage originalImage = ImageIO.read(new File(imagePath));
	        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	        return new ImageIcon(scaledImage);
	    } catch (Exception e) {
	        e.printStackTrace(); // Print the exception for debugging
	        return null;
	    }
	}


}
