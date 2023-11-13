package SourceCodes;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {

    private JTextField display;
    private JPanel buttonPanel;
    private JButton backButton; // New back button

    private double num1 = 0;
    private double num2 = 0;
    private String operator = "";
    private boolean newInput = true;

    public CalculatorGUI() {
        super("Calculator");
        setLayout(new BorderLayout());

        display = new JTextField(20);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };
        backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the calculator window
                new desktop(); // Open the main menu window
            }
        });
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onButtonClick(label);
                }
            });
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);

        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    private void onButtonClick(String label) {
        if (label.matches("[0-9]+") || label.equals(".")) {
            if (newInput) {
                display.setText("");
                newInput = false;
            }
            display.setText(display.getText() + label);
        } else if (label.equals("=")) {
            calculate();
        } else {
            if (!operator.isEmpty()) {
                calculate();
            }
            operator = label;
            num1 = Double.parseDouble(display.getText());
            newInput = true;
        }
    }

    private void calculate() {
        if (!operator.isEmpty()) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case "+":
                    num1 += num2;
                    break;
                case "-":
                    num1 -= num2;
                    break;
                case "*":
                    num1 *= num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        num1 /= num2;
                    } else {
                        JOptionPane.showMessageDialog(null, "Cannot divide by zero.");
                    }
                    break;
            }
            display.setText(String.valueOf(num1));
            operator = "";
            newInput = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculatorGUI();
            }
        });
    }
}
