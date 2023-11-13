package SourceCodes;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NotesApp extends JFrame {

    private JTextArea textArea;
    private JButton addButton;
    private JButton backButton; // New back button

    private List<String> notes;

    public NotesApp() {
        super("Notes App");
        notes = new ArrayList<>();
        setLayout(new BorderLayout());

        textArea = new JTextArea(20, 40);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        addButton = new JButton("Add Note");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNote();
            }
        });
        add(addButton, BorderLayout.NORTH);
        backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the notes app window
                new desktop(); // Open the main menu window
            }
        });
        
        
        add(backButton, BorderLayout.SOUTH);

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    private void addNote() {
        String note = JOptionPane.showInputDialog("Enter a new note:");
        if (note != null && !note.isEmpty()) {
            notes.add(note);
            updateTextArea();
        }
    }

    private void updateTextArea() {
        StringBuilder sb = new StringBuilder();
        for (String note : notes) {
            sb.append(note).append("\n");
        }
        textArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NotesApp();
            }
        });
    }
}
