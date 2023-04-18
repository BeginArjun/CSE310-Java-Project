package checkout;

import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.*;

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
        try {
            File file = new File("reservations.txt");
            File tempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String lineToRemove = name + "," + room;
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            return tempFile.renameTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}