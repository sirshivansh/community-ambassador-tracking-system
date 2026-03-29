package ui;

import model.Student;
import model.Ambassador;
import service.DataManager;

import javax.swing.*;
import java.awt.*;

public class AddStudentFrame extends JFrame {

    public AddStudentFrame() {
        setTitle("Add Student");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JTextField nameField = new JTextField(15);
        JTextField collegeField = new JTextField(15);

        JComboBox<Ambassador> ambassadorBox = new JComboBox<>();

        // Fill dropdown
        for (Ambassador a : DataManager.ambassadors) {
            ambassadorBox.addItem(a);
        }

        JButton saveBtn = new JButton("Save");

        add(new JLabel("Name:"));
        add(nameField);

        add(new JLabel("College:"));
        add(collegeField);

        add(new JLabel("Ambassador:"));
        add(ambassadorBox);

        add(saveBtn);

        saveBtn.addActionListener(e -> {
            String name = nameField.getText();
            String college = collegeField.getText().trim().toLowerCase();
            Ambassador selected = (Ambassador) ambassadorBox.getSelectedItem();

            if (!name.isEmpty() && !college.isEmpty() && selected != null) {

                String code = "AMB" + Math.abs(selected.getName().hashCode());
                DataManager.addStudent(new Student(name, college, selected, code));

                JOptionPane.showMessageDialog(this,
                        "Student Added!\nReferral Code: " + code);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Fill all fields!");
            }
        });

        setVisible(true);
    }
}