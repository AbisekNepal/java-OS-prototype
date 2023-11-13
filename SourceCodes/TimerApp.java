package SourceCodes;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerApp extends JFrame {

    private JLabel countdownLabel;
    private JButton startButton;
    private JButton backButton;
    private Timer timer;
    private int timeRemaining;
    private desktop desktop;

    public TimerApp() {
        super("Countdown Timer");
        setLayout(new FlowLayout());

        countdownLabel = new JLabel("Time Remaining: ");
        add(countdownLabel);

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTimer();
            }
        });
        add(startButton);

        backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backToMainMenu();
            }
        });
        add(backButton,BorderLayout.SOUTH);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTimer();
            }
        });

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startTimer() {
        String input = JOptionPane.showInputDialog("Enter countdown time (in seconds):");
        try {
            timeRemaining = Integer.parseInt(input);
            if (timeRemaining <= 0) {
                JOptionPane.showMessageDialog(null, "Please enter a positive integer.");
                return;
            }
            timer.start();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a positive integer.");
        }
    }

    private void updateTimer() {
        if (timeRemaining > 0) {
            timeRemaining--;
            countdownLabel.setText("Time Remaining: " + timeRemaining + " seconds");
        } else {
            timer.stop();
            countdownLabel.setText("Time's up!");
        }
    }

    private void backToMainMenu() {
        dispose(); // Close the timer app window
        new desktop();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TimerApp(); // The main menu reference is set to null here
            }
        });
    }
}
