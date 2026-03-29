package ui;

import model.Ambassador;
import model.Student;
import service.DataManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewFrame extends JFrame {

    public ViewFrame() {
        setTitle("View Data");
        setSize(500, 400);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        // ================= AMBASSADOR TABLE =================
        String[] ambCols = {"Name"};
        DefaultTableModel ambModel = new DefaultTableModel(ambCols, 0);

        for (Ambassador a : DataManager.ambassadors) {
            ambModel.addRow(new Object[]{a.getName()});
        }

        JTable ambTable = new JTable(ambModel);
        JScrollPane ambScroll = new JScrollPane(ambTable);

        // ================= STUDENT TABLE =================
        String[] stuCols = {"Name", "College", "Ambassador", "Referral Code"};
        DefaultTableModel stuModel = new DefaultTableModel(stuCols, 0);

        for (Student s : DataManager.students) {
            stuModel.addRow(new Object[]{
                    s.getName(),
                    s.getCollege(),
                    s.getAmbassador().getName(),
                    s.getReferralCode()
            });
        }

        JTable stuTable = new JTable(stuModel);
        JScrollPane stuScroll = new JScrollPane(stuTable);

        JButton deleteBtn = new JButton("Delete Selected Student");

        deleteBtn.addActionListener(e -> {
            int selectedRow = stuTable.getSelectedRow();

            if (selectedRow != -1) {
                DataManager.students.remove(selectedRow);
                stuModel.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Select a student first!");
            }
        });

        JPanel studentPanel = new JPanel(new BorderLayout());
        studentPanel.add(stuScroll, BorderLayout.CENTER);
        studentPanel.add(deleteBtn, BorderLayout.SOUTH);

        // Tabs
        tabbedPane.addTab("Ambassadors", ambScroll);
        tabbedPane.addTab("Students", studentPanel);

        add(tabbedPane, BorderLayout.CENTER);

        setVisible(true);
    }
}