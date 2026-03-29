package ui;

import model.Ambassador;
import service.DataManager;

import javax.swing.*;
import java.awt.*;

public class AddAmbassadorFrame extends JFrame {

    public AddAmbassadorFrame() {
        setTitle("Add Ambassador");
        setSize(300, 200);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(15);
        JButton saveBtn = new JButton("Save");

        add(nameLabel);
        add(nameField);
        add(saveBtn);

        saveBtn.addActionListener(e -> {
            String name = nameField.getText().trim();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter name!");
                return;
            }

            // 🔥 Duplicate check
            for (Ambassador a : DataManager.ambassadors) {
                if (a.getName().equalsIgnoreCase(name)) {
                    JOptionPane.showMessageDialog(this, "Ambassador already exists!");
                    return;
                }
            }

            DataManager.addAmbassador(new Ambassador(name));
            JOptionPane.showMessageDialog(this, "Ambassador Added!");
            dispose();
        });

        setVisible(true);
    }
}