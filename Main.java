import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  
import checkin.Booking;

public class Main extends JFrame {
    public Main(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Hotel Management System");
        JPanel Menu = new JPanel();
        Menu.setLayout(new FlowLayout());
        JButton checkin = new JButton("CHECK IN");
        Menu.add(checkin);
        JButton checkout = new JButton("CHECK OUT");
        Menu.add(checkout);
        setContentPane(Menu);
        checkin.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Booking book = new Booking();
                setContentPane(book.getPanel());
                setSize(400,300);
                setTitle("Check In");
                revalidate();
                repaint();
            }
        });

        setSize(400, 100);
        setLocationRelativeTo(null); 
    }
    public static void main(String[] args) {
        Main homepage = new Main();
        homepage.setVisible(true);
    }
}