import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatbotGUI extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;

    public ChatbotGUI() {
        setTitle("Simple Chatbot");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(chatArea);
        add(scroll, BorderLayout.CENTER);

        inputField = new JTextField();
        add(inputField, BorderLayout.SOUTH);

        inputField.addActionListener(e -> handleInput());

        chatArea.append("Chatbot: Hi! I'm your Java Chatbot. Type 'bye' to exit.\n");
        setVisible(true);
    }

    private void handleInput() {
        String input = inputField.getText().toLowerCase();
        chatArea.append("You: " + input + "\n");

        String response;
        if (input.contains("hi") || input.contains("hello"))
            response = "Hello there! How can I help you?";
        else if (input.contains("how are you"))
            response = "I'm doing great! How about you?";
        else if (input.contains("time"))
            response = "I can’t tell time yet, but I run 24/7!";
        else if (input.contains("bye")) {
            response = "Goodbye! Have a nice day!";
            chatArea.append("Chatbot: " + response + "\n");
            inputField.setEditable(false);
            return;
        } else
            response = "Sorry, I didn’t understand that.";

        chatArea.append("Chatbot: " + response + "\n");
        inputField.setText("");
    }

    public static void main(String[] args) {
        new ChatbotGUI();
    }
}