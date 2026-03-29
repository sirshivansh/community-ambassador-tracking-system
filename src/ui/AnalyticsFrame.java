package ui;

import model.Ambassador;
import model.Student;
import service.DataManager;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class AnalyticsFrame extends JFrame {

    public AnalyticsFrame() {
        setTitle("Analytics");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea area = new JTextArea();
        area.setEditable(false);

        HashMap<String, Integer> countMap = new HashMap<>();
        HashMap<String, Integer> collegeMap = new HashMap<>();

        // Count students per ambassador
        for (Student s : DataManager.students) {
            String ambName = s.getAmbassador().getName();
            String college = s.getCollege();

            // Ambassador count
            countMap.put(ambName, countMap.getOrDefault(ambName, 0) + 1);

            // College count
            collegeMap.put(college, collegeMap.getOrDefault(college, 0) + 1);
        }

        // Build output
        StringBuilder result = new StringBuilder();
        int max = 0;

        // First pass → find max
        for (Ambassador a : DataManager.ambassadors) {
            int count = countMap.getOrDefault(a.getName(), 0);
            if (count > max) {
                max = count;
            }
        }

        // Second pass → find all top ambassadors
        StringBuilder topAmbassadors = new StringBuilder();

        for (Ambassador a : DataManager.ambassadors) {
            int count = countMap.getOrDefault(a.getName(), 0);

            result.append(a.getName())
                    .append(" → ")
                    .append(count)
                    .append(" students\n");

            if (count == max && max > 0) {
                topAmbassadors.append(a.getName()).append(", ");
            }
        }

        // Remove last comma
        if (topAmbassadors.length() > 0) {
            topAmbassadors.setLength(topAmbassadors.length() - 2);
        }

        if (max == 0) {
            result.append("\nNo student data available yet.");
        } else {
            result.append("\n🏆 Top Ambassador(s): ")
                    .append(topAmbassadors)
                    .append(" (")
                    .append(max)
                    .append(" students)");

            if (collegeMap.isEmpty()) {
                result.append("\n\nNo college data available yet.");
            } else {
                result.append("\n\n📊 Students per College:\n");

                for (String college : collegeMap.keySet()) {
                    result.append(capitalize(college))
                            .append(" → ")
                            .append(collegeMap.get(college))
                            .append(" students\n");
                }
            }

            result.append("\n\n📌 Total Ambassadors: ")
                    .append(DataManager.ambassadors.size());

            result.append("\n📌 Total Students: ")
                    .append(DataManager.students.size());
        }

        // Final UI update
        area.setText(result.toString());
        add(new JScrollPane(area), BorderLayout.CENTER);

        setVisible(true);
    }

    //method of capitalize
    private String capitalize(String text) {
        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }

        return result.toString().trim();
    }
}