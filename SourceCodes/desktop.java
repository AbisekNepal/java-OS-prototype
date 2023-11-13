package SourceCodes;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class desktop extends JFrame implements ActionListener {
    private JLabel dateTimeLabel,greetingLabel; // Label to display date and time
    private JButton calculatorButton, notesButton, timerButton, mailButton, quitButton;
    private JPanel northPanel, eastPanel, centerPanel, southPanel;
    

    public desktop() {
        super("Main Menu");
        greetingLabel = new JLabel("");
        // DateTime Label
        northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,1));
        dateTimeLabel = new JLabel();
        updateDateTimeLabel(); // Initial update
        northPanel.add(greetingLabel);
	        Font labelFont = new Font("Serif", Font.BOLD, 24);
	        greetingLabel.setFont(labelFont);
	        greetingLabel.setForeground(Color.BLUE);
	        greetingLabel.setHorizontalAlignment(JLabel.CENTER); // Center the text
	        greetingLabel.setVerticalAlignment(JLabel.CENTER);
	        dateTimeLabel.setHorizontalAlignment(JLabel.CENTER);
        northPanel.add(dateTimeLabel);
        add(northPanel, BorderLayout.NORTH);

        // Image in Center Panel
        centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout()); // Use FlowLayout to center the image
        ImageIcon imageIcon = resizeImage("liberty.jpg", 400, 250); // Resize the image to 200x200
        JLabel imageLabel = new JLabel(imageIcon);
        centerPanel.add(imageLabel);
        add(centerPanel, BorderLayout.CENTER);

        // Other Buttons in East Panel
        eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(4, 1));
        calculatorButton = createSquareButton("Calculator");
        notesButton = createSquareButton("Notes");
        timerButton = createSquareButton("Timer");
        mailButton = createSquareButton("Mails");
        eastPanel.add(calculatorButton);
        eastPanel.add(notesButton);
        eastPanel.add(timerButton);
        eastPanel.add(mailButton);
        add(eastPanel, BorderLayout.EAST);

        // Quit Button in South Panel
        southPanel = new JPanel();
        quitButton = new JButton("Quit");
        southPanel.add(quitButton);
        add(southPanel, BorderLayout.SOUTH);


        // Create a timer to update the date and time label every second
        Timer timer = new Timer(1000, e -> updateDateTimeLabel());
        timer.start();
        
        quitButton.addActionListener(this);
        calculatorButton.addActionListener(this);
		notesButton.addActionListener(this);
		timerButton.addActionListener(this);
		mailButton.addActionListener(this);
        setVisible(true);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JButton createSquareButton(String label) {
        JButton button = new JButton(label);
        Dimension size = new Dimension(100, 100); // Set the preferred size to create a square button
        button.setPreferredSize(size);
        return button;
    }

    // Method to resize an image
    private ImageIcon resizeImage(String imagePath, int width, int height) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to update the date and time label
    private void updateDateTimeLabel() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String formattedDate = dateFormat.format(now);
        dateTimeLabel.setText(formattedDate);

        // Get the current hour of the day
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        // Set the greeting based on the time of day
        if (hour >= 6 && hour < 12) {
            greetingLabel.setText("Good Morning");
        } else if (hour >= 12 && hour < 18) {
            greetingLabel.setText("Good Afternoon");
        } else {
            greetingLabel.setText("Good Night");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new desktop();
            }
        });
    }
    public void actionPerformed(ActionEvent event) {
    	if (event.getSource() == calculatorButton) {
	    	dispose();
	        new CalculatorGUI();
	    } else if (event.getSource() == notesButton) {
	       dispose();
	       new NotesApp();
	        
	    } else if (event.getSource() == timerButton) {
	        dispose();
	        new TimerApp();
	    }else if(event.getSource()== quitButton) {
	    	dispose();
	    }
	    else if(event.getSource()== mailButton) {
	    	dispose();
	    	new mailApp();
	    }
    }
}
