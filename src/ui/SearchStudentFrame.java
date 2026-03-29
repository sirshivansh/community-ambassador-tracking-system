package ui;

import model.Student;
import service.DataManager;

import javax.swing.*;
import java.awt.*;

public class SearchStudentFrame extends JFrame {

    public SearchStudentFrame() {
        setTitle("Search Student");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        JTextField searchField = new JTextField(15);
        JButton searchBtn = new JButton("Search");

        topPanel.add(new JLabel("Enter Name:"));
        topPanel.add(searchField);
        topPanel.add(searchBtn);

        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        // 🔍 Search Logic
        searchBtn.addActionListener(e -> {
            String name = searchField.getText().trim().toLowerCase();
            boolean found = false;

            StringBuilder result = new StringBuilder();

            for (Student s : DataManager.students) {
                if (s.getName().toLowerCase().equals(name)) {
                    result.append("Name: ").append(s.getName()).append("\n");
                    result.append("College: ").append(s.getCollege()).append("\n");
                    result.append("Ambassador: ").append(s.getAmbassador().getName()).append("\n");
                    result.append("Referral Code: ").append(s.getReferralCode()).append("\n\n");
                    found = true;
                }
            }

            if (!found) {
                result.append("Student not found!");
            }

            resultArea.setText(result.toString());
        });

        setVisible(true);
    }
}