package checkin;
import javax.swing.*;
import java.awt.*;


public class Booking extends JFrame{
    JPanel panel = new JPanel();
    public Booking() {
        // Create a panel to hold the components
        panel.setLayout(new GridLayout(0, 2));

        // Add labels and text fields for the reservation details
        panel.add(new JLabel("Name:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Date:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Time:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Number of Guests:"));
        panel.add(new JTextField());

        // Add a button to submit the reservation
        JButton submitButton = new JButton("Submit Reservation");
        panel.add(submitButton);
    }

    public JPanel getPanel(){
        return this.panel;
    }
}