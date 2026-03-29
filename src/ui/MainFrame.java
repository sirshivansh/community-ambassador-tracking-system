package ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Community Ambassador System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main Panel (instead of direct layout)
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        panel.setBackground(Color.WHITE);

        // Buttons
        JButton addAmbassadorBtn = createStyledButton("Add Ambassador");
        JButton addStudentBtn = createStyledButton("Add Student");
        JButton viewDataBtn = createStyledButton("View Data");
        JButton analyticsBtn = createStyledButton("Analytics");
        JButton searchBtn = createStyledButton("Search Student");

        // Actions
        addAmbassadorBtn.addActionListener(e -> new AddAmbassadorFrame());
        viewDataBtn.addActionListener(e -> new ViewFrame());
        addStudentBtn.addActionListener(e -> new AddStudentFrame());
        analyticsBtn.addActionListener(e -> new AnalyticsFrame());
        searchBtn.addActionListener(e -> new SearchStudentFrame());

        // Add buttons to panel
        panel.add(addAmbassadorBtn);
        panel.add(addStudentBtn);
        panel.add(viewDataBtn);
        panel.add(analyticsBtn);
        panel.add(searchBtn);

        // Add panel to frame
        add(panel);

        setVisible(true);
    }

    // 🔥 Button Styling Method
    private JButton createStyledButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 16));
        btn.setBackground(new Color(33, 150, 243)); // Blue
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return btn;
    }
}