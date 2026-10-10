 import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Chatbot chatbot = new Chatbot();

        JFrame frame = new JFrame("NexaBot - Smart AI Chatbot");
        frame.setSize(650, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // Chat Area
        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 15));

        JScrollPane scrollPane = new JScrollPane(chatArea);

        // Input
        JTextField inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 15));

        // Buttons
        JButton sendButton = new JButton("Send");
        JButton clearButton = new JButton("Clear Chat");

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 0));
        buttonPanel.add(sendButton);
        buttonPanel.add(clearButton);

        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.EAST);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Welcome Message
        chatArea.append(
                "🤖 NexaBot: Hello! 👋 Welcome to NexaBot.\n"
                + "Ask me about Java, OOP, internships, placements or projects.\n\n"
        );

        DateTimeFormatter timeFormat =
                DateTimeFormatter.ofPattern("hh:mm a");

        // Send Button
        sendButton.addActionListener(e -> {

            String userMessage = inputField.getText().trim();

            if (userMessage.isEmpty()) {
                return;
            }

            String response = chatbot.getResponse(userMessage);
            String time = LocalTime.now().format(timeFormat);

            // User message
            chatArea.append(
                    "You [" + time + "]: "
                    + userMessage + "\n"
            );

            // Typing message
            chatArea.append(
                    "🤖 NexaBot is typing...\n"
            );

            inputField.setText("");

            // Typing delay
            Timer timer = new Timer(700, event -> {

                String currentTime =
                        LocalTime.now().format(timeFormat);

                String text = chatArea.getText();

                text = text.replace(
                        "🤖 NexaBot is typing...\n",
                        ""
                );

                chatArea.setText(text);

                chatArea.append(
                        "🤖 NexaBot [" + currentTime + "]: "
                        + response + "\n\n"
                );

                chatArea.setCaretPosition(
                        chatArea.getDocument().getLength()
                );
            });

            timer.setRepeats(false);
            timer.start();
        });

        // Enter key = Send
        inputField.addActionListener(e ->
                sendButton.doClick()
        );

        // Clear Chat
        clearButton.addActionListener(e -> {

            chatArea.setText("");

            chatArea.append(
                    "🤖 NexaBot: Chat cleared! "
                    + "How can I help you?\n\n"
            );
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}