import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DigitalClockGUI extends JFrame implements Runnable {
    private JLabel timeLabel;

    public DigitalClockGUI() {
        setTitle("Digital Clock");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        add(timeLabel, BorderLayout.CENTER);

        Thread t = new Thread(this);
        t.start();

        setVisible(true);
    }

    public void run() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        while (true) {
            LocalTime time = LocalTime.now();
            timeLabel.setText(time.format(formatter));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new DigitalClockGUI();
    }
}