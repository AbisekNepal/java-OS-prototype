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


public class mailApp extends JFrame implements ActionListener{
	
	private JLabel sendToLabel,sendFromLabel,mailSubjectLabel,templatesLabel;
	private JButton templOne, templTwo, templThree, sendMailButton, discardMailButton, clearButton, backButton;
	private JTextField sendToText, sendFromText, subjectText;
	private JTextArea mainEmail;
	private JPanel northPanel,centerPanel,southPanel;
	
	public mailApp() {
		super("Mails");
		
		northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(3,2));
		
			sendToLabel = new JLabel("Send To: ");
			sendToText = new JTextField(10);
			sendFromLabel = new JLabel("Send From: ");
			sendFromText = new JTextField(10);
			mailSubjectLabel = new JLabel("Subject: ");
			subjectText = new JTextField(10);
			
			northPanel.add(sendToLabel);
			northPanel.add(sendToText);
			northPanel.add(sendFromLabel);
			northPanel.add(sendFromText);
			northPanel.add(mailSubjectLabel);
			northPanel.add(subjectText);
			
			add(northPanel,BorderLayout.NORTH);
			
		centerPanel = new JPanel();
			
			mainEmail = new JTextArea(10, 35);
			mainEmail.setText("Enter Email Here");
			centerPanel.add(mainEmail);
					
						mainEmail.addFocusListener(new FocusListener() {
			                public void focusGained(FocusEvent e) {
			                    if (mainEmail.getText().equals("Enter Email Here")) {
			                    	mainEmail.setText("");
			                    	mainEmail.setForeground(Color.BLACK);
			                    }
			                }
			
			                public void focusLost(FocusEvent e) {
			                    if (mainEmail.getText().isEmpty()) {
			                    	mainEmail.setText("Enter Email Here");
			                    	mainEmail.setForeground(Color.GRAY);
			                    }
			                }
						});
			
			add(centerPanel,BorderLayout.CENTER);
			
		
		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(2,4));
		
			templatesLabel = new JLabel("Email Templates:");
			templOne = new JButton("Sick Leave");
			templTwo = new JButton("Status Report");
			templThree = new JButton("Meeting Request");
			sendMailButton = new JButton("Send");
			discardMailButton = new JButton("Discard");
			clearButton = new JButton("Clear");
			backButton = new JButton("Back");
			
			southPanel.add(templatesLabel);
			southPanel.add(templOne);
			southPanel.add(templTwo);
			southPanel.add(templThree);
			southPanel.add(sendMailButton);
			southPanel.add(discardMailButton);
			southPanel.add(clearButton);
			southPanel.add(backButton);
			
		add(southPanel,BorderLayout.SOUTH);
		
		templOne.addActionListener(this);
		templTwo.addActionListener(this);
		templThree.addActionListener(this);
		sendMailButton.addActionListener(this);
		discardMailButton.addActionListener(this);
		clearButton.addActionListener(this);
		backButton.addActionListener(this);
			
		setVisible(true);
		setSize(550,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		mailApp app = new mailApp();
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == templOne) {
			subjectText.setText("Sick Leave");
	    	mainEmail.setText("Dear [Supervisor's Name],\n"
	    			+ "\n"
	    			+ "I'm unwell and need to take sick leave from [Start Date] to [End Date]."
	    			+ "\n"
	    			+"I'll ensure minimal disruption and remain reachable via email for any urgent matters.\n"
	    			+ "\n"
	    			+ "Thank you for your understanding.\n"
	    			+ "\n"
	    			+ "Best regards,\n"
	    			+ "[Your Name]");
	    } else if (event.getSource() == templTwo) {
	    	subjectText.setText("Status Report");
	    	mainEmail.setText("Dear [Recipient's Name],\n"
	    			+ "\n"
	    			+ "I'm writing to provide a brief status report on [Project Name or ID]. "
	    			+ "\n"
	    			+"Here's a quick overview:\n"
	    			+ "\n"
	    			+ "Project Progress: [Insert work in progress].\n"
	    			+ "\n"
	    			+ "please feel free to reach out.\n"
	    			+ "\n"
	    			+ "Best regards,\n"
	    			+ "[Your Name]");
	        
	    } else if (event.getSource() == templThree) {
	    	subjectText.setText("Meeting Request");
	    	mainEmail.setText("Dear [Recipient's Name],\n"
	    			+ "\n"
	    			+ "I'd like to schedule a meeting to discuss [briefly describe the topic].\n"
	    			+ "\n"
	    			+ "Proposed Details:\n"
	    			+ "\n"
	    			+ "Date: [Proposed Date]\n"
	    			+ "Time: [Proposed Time]\n"
	    			+ "Your availability and suggested changes are appreciated.\n"
	    			+ "\n"
	    			+ "Thank you.\n"
	    			+ "\n"
	    			+ "Best regards,\n"
	    			+ "[Your Name]");
	    } else if(event.getSource()==sendMailButton) {
	    	JOptionPane.showMessageDialog(null, "Email Sent");  
	    	
	    }else if(event.getSource()==discardMailButton) {
	    	mainEmail.setText("Enter Email Here");
	    }else if(event.getSource()==clearButton) {
	    	sendToText.setText("");
	    	sendFromText.setText("");
	    	subjectText.setText("");
	    	mainEmail.setText("Enter Email Here");
	    }else if(event.getSource()==backButton) {
	    	dispose();
	    	new desktop();
	    }
	}



}
