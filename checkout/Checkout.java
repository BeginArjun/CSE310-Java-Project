package checkout;

import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Checkout extends JFrame {
    JPanel panel = new JPanel();

    public Checkout() {
        // Create a panel to hold the components
        panel.setLayout(new GridLayout(0, 2));
        
         // Set background color
         panel.setBackground(Color.decode("#ffd8ec"));

         // Add labels and text fields for the checkout details
         JLabel nameLabel = new JLabel("Name:");
         nameLabel.setForeground(Color.decode("#ffffff"));
         panel.add(nameLabel);
         JTextField name = new JTextField();
         panel.add(name);
         JLabel roomLabel = new JLabel("Room:");
         roomLabel.setForeground(Color.decode("#ffffff"));
         panel.add(roomLabel);
         JTextField room = new JTextField();
         panel.add(room);

         // Add a button to submit the checkout
         JButton submitButton = new JButton("Submit Checkout");
         submitButton.setBackground(Color.decode("#ffa8cb"));
         
         submitButton.addActionListener(e -> {
             String enteredName = name.getText();
             String enteredRoom = room.getText();
             if (removeReservation(enteredName, enteredRoom)) {
                 JOptionPane.showMessageDialog(null, "Checkout successful!");
                 name.setText("");
                 room.setText("");
             } else {
                 JOptionPane.showMessageDialog(null, "Error: Reservation not found or invalid date/time.");
             }
         });
         
         panel.add(submitButton);
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public boolean removeReservation(String name, String room) {
        String filePath = "reservations.csv";
        File file = new File(filePath);
        try {
            List<String> out = Files.lines(file.toPath())
                    .filter(line -> !(line.contains(name) && line.contains(room)))
                    .collect(Collectors.toList());
            FileWriter writer = new FileWriter(filePath);
            for (String line : out) {
                writer.write(line + System.lineSeparator());
            }
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}