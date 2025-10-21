import javax.swing.*;
import java.awt.*;

public class GradeCalculatorGUI extends JFrame {
    private JTextField sub1, sub2, sub3;
    private JLabel resultLabel;

    public GradeCalculatorGUI() {
        setTitle("Grade Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Marks in Subject 1:"));
        sub1 = new JTextField();
        add(sub1);

        add(new JLabel("Marks in Subject 2:"));
        sub2 = new JTextField();
        add(sub2);

        add(new JLabel("Marks in Subject 3:"));
        sub3 = new JTextField();
        add(sub3);

        JButton calcBtn = new JButton("Calculate Grade");
        add(calcBtn);

        resultLabel = new JLabel("Result will appear here");
        add(resultLabel);

        calcBtn.addActionListener(e -> calculateGrade());

        setVisible(true);
    }

    private void calculateGrade() {
        try {
            double m1 = Double.parseDouble(sub1.getText());
            double m2 = Double.parseDouble(sub2.getText());
            double m3 = Double.parseDouble(sub3.getText());
            double avg = (m1 + m2 + m3) / 3;

            char grade;
            if (avg >= 90)
                grade = 'A';
            else if (avg >= 75)
                grade = 'B';
            else if (avg >= 60)
                grade = 'C';
            else if (avg >= 45)
                grade = 'D';
            else
                grade = 'F';

            resultLabel.setText("Average: " + avg + " | Grade: " + grade);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid marks!");
        }
    }

    public static void main(String[] args) {
        new GradeCalculatorGUI();
    }
}