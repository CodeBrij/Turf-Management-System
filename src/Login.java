import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener {

    ResultSet rs = null;
    PreparedStatement pst = null;
    JLabel label1, label2, label3;
    JTextField textField2;

    JButton button1, button2, button3, button4;

    JPasswordField passwordField3;

    public Login() {
        super("Turf Management System");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 100, 100);
        add(image);

        label1 = new JLabel("WELCOME TO TURFIT");
        label1.setBounds(230, 125, 450, 40);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
        add(label1);

        label2 = new JLabel("Username: ");
        label2.setBounds(150, 190, 375, 30);
        label2.setFont(new Font("Ralway", Font.BOLD, 28));
        label2.setForeground(Color.WHITE);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(325, 190, 230, 30);
        textField2.setFont(new Font("arial", Font.BOLD, 14));
        add(textField2);

        label3 = new JLabel("Password: ");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Ralway", Font.BOLD, 28));
        label3.setBounds(150, 250, 375, 30);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(325, 250, 230, 30);
        passwordField3.setFont(new Font("arial", Font.BOLD, 14));
        add(passwordField3);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("ARIAL", Font.BOLD, 14));
        button1.setForeground(Color.BLACK);
        button1.setBackground(Color.WHITE);
        button1.setBounds(300, 300, 100, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("ARIAL", Font.BOLD, 14));
        button2.setForeground(Color.BLACK);
        button2.setBackground(Color.WHITE);
        button2.setBounds(430, 300, 100, 30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("ARIAL", Font.BOLD, 14));
        button3.setForeground(Color.BLACK);
        button3.setBackground(Color.WHITE);
        button3.setBounds(300, 350, 230, 30);
        button3.addActionListener(this);
        add(button3);

        button4 = new JButton("ADMIN LOGIN");
        button4.setFont(new Font("ARIAL", Font.BOLD, 14));
        button4.setForeground(Color.BLACK);
        button4.setBackground(Color.WHITE);
        button4.setBounds(300, 400, 230, 30);
        button4.addActionListener(this);
        add(button4);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0, 0, 850, 480);
        add(iiimage);

        setLayout(null);
        setSize(850, 480);
        setLocation(450, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button3){
            new Signup();
            setVisible(false);
        }
        if(e.getSource()==button4){
            new Adminlogin();
            setVisible(false);
        }
        String un = textField2.getText();
        String ps = new String(passwordField3.getPassword()); // Get the password as a String
        try {
            String sql = "SELECT * FROM user WHERE USERNAME=? AND PASSWORD=?";
            PreparedStatement pst = ConUser.mycon().prepareStatement(sql); // Use mycon() to get the connection
            pst.setString(1, un);
            pst.setString(2, ps);
            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(rootPane, "Logged In !");
                new homepage().setVisible(true);
                setEnabled(false); // Disable the login window
                setVisible(false);
            } else if(e.getSource()==button1){
                JOptionPane.showMessageDialog(rootPane, "Login failed. Please check your credentials.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Database Error: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
