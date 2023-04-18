package checkin;
import javax.swing.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import fileHandle.*;
import Bill.Bill;

public class Booking extends JFrame{
    JPanel panel = new JPanel();
    public Booking() {
        // Create a panel to hold the components
        panel.setLayout(new GridLayout(0, 2));
        panel.setBackground(Color.decode("#ffd8ec"));

        // Add labels and text fields for the reservation details
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.decode("#ffffff"));
        panel.add(nameLabel);
        JTextField name=new JTextField();
        panel.add(name);
        JLabel dateLabel = new JLabel("Date :");
        dateLabel.setForeground(Color.decode("#ffffff"));
        panel.add(dateLabel);
        JFormattedTextField dateField = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        LocalDate currentDate = LocalDate.now();
        Date dateValue = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        dateField.setValue(dateValue);
        panel.add(dateField);
        JLabel timeLabel = new JLabel("Time:");
        timeLabel.setForeground(Color.decode("#ffffff"));
        panel.add(timeLabel);
        SpinnerDateModel model = new SpinnerDateModel();
        JSpinner timeSpinner = new JSpinner(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(editor);
        panel.add(timeSpinner);
        JLabel guestsLabel = new JLabel("Number of guests: ");
        guestsLabel.setForeground(Color.decode("#ffffff"));
        panel.add(guestsLabel);
        JTextField guests=new JTextField();
        panel.add(guests);
        
        // Add a dropdown list for available rooms
        JLabel roomLabel = new JLabel("Room: ");
        roomLabel.setForeground(Color.decode("#ffffff"));
        panel.add(roomLabel);
        String[] rooms = {"Room 1", "Room 2", "Room 3"};
        JComboBox<String> roomList = new JComboBox<>(rooms);
        panel.add(roomList);

        // Add a button to submit the reservation
        JButton submitButton = new JButton("Submit Reservation");
        
        submitButton.addActionListener(e -> {
            String selectedRoom = (String) roomList.getSelectedItem();
            String selectedDate = dateField.getText();
            if (fileHandle.isRoomAvailable(selectedRoom, selectedDate)) {
                String[] data = {name.getText(), selectedDate, editor.getFormat().format(timeSpinner.getValue()), guests.getText(), selectedRoom};
                fileHandle.writeToCSV(data);
                JOptionPane.showMessageDialog(null, "Reservation submitted!");
                Bill totalBill=new Bill();
            JOptionPane.showMessageDialog(null,"Your total Bill is : $"+totalBill.roomBill(Integer.parseInt(guests.getText())));
                name.setText("");
                dateField.setValue(dateValue);
                guests.setText("");
                roomList.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(null, "Sorry, the selected room is not available on the selected date.");
            }
            
        });
        
        submitButton.setBackground(Color.decode("#ffa8cb"));
        
        panel.add(submitButton);
    }

    public JPanel getPanel(){
        return this.panel;
    }
}