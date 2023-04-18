import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  
import checkin.Booking;
import checkout.Checkout;

public class Main extends JFrame {
    public Main(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Hotel Management System");
        setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("home.jpg"));
        background.setLayout(new GridBagLayout());
        JPanel Menu = new JPanel();
        Menu.setLayout(new BoxLayout(Menu, BoxLayout.X_AXIS));
        Menu.setBackground(Color.pink);
        JButton checkin = new JButton("CHECK IN");
        checkin.setBackground(Color.white);
        checkin.setAlignmentX(Component.CENTER_ALIGNMENT);
        Menu.add(checkin);
        JButton checkout = new JButton("CHECK OUT");
        checkout.setBackground(Color.white);
        checkout.setAlignmentX(Component.CENTER_ALIGNMENT);
        Menu.add(checkout);
        background.add(Menu);
        add(background);
        setBackground(Color.pink);
        
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

        checkout.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Checkout cout = new Checkout();
                setContentPane(cout.getPanel());
                setSize(400,300);
                setTitle("Check Out");
                revalidate();
                repaint();
            }
        });

        setSize(279, 402);
        setLocationRelativeTo(null); 
    }
    public static void main(String[] args) {
        Main homepage = new Main();
        homepage.setVisible(true);
    }
}