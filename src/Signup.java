import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {

    JTextField textname, textFname, textEmail, textAdd;

    JRadioButton r1, r2;
    JButton next;
    JDateChooser dateChooser;
    JPasswordField password;

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;

    String first = " " + Math.abs(first4);

    Signup() {
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10, 100, 100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO." + first);
        label1.setBounds(160, 20, 600, 40);
        label1.setFont(new Font("Ralway", Font.BOLD, 38));
        add(label1);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Ralway", Font.BOLD, 22));
        label3.setBounds(290, 90, 600, 30);
        add(label3);

        JLabel labelName = new JLabel("NAME : ");
        labelName.setFont(new Font("Ralway", Font.BOLD, 20));
        labelName.setBounds(100, 190, 100, 30);
        add(labelName);

        textname = new JTextField();
        textname.setFont(new Font("Ralway", Font.BOLD, 14));
        textname.setBounds(300, 190, 400, 30);
        add(textname);

        JLabel labelfName = new JLabel("USERNAME : ");
        labelfName.setFont(new Font("Ralway", Font.BOLD, 20));
        labelfName.setBounds(100, 240, 200, 30);
        add(labelfName);

        textFname = new JTextField();
        textFname.setFont(new Font("Ralway", Font.BOLD, 14));
        textFname.setBounds(300, 240, 400, 30);
        add(textFname);

        JLabel DOB = new JLabel("Date of Birth : ");
        DOB.setFont(new Font("Ralway", Font.BOLD, 20));
        DOB.setBounds(100, 340, 200, 30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 340, 400, 30);
        add(dateChooser);

        JLabel labelG = new JLabel("Gender :");
        labelG.setFont(new Font("Ralway", Font.BOLD, 20));
        labelG.setBounds(100, 290, 200, 30);
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Ralway", Font.BOLD, 14));
        r1.setBackground(new Color(222, 255, 228));
        r1.setBounds(300, 290, 90, 30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Ralway", Font.BOLD, 14));
        r1.setBackground(new Color(222, 255, 228));
        r2.setFocusable(false);
        r2.setBounds(450, 290, 90, 30);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel labelEmail = new JLabel("PHONE NO. :");
        labelEmail.setFont(new Font("Ralway", Font.BOLD, 20));
        labelEmail.setBounds(100, 390, 200, 30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Ralway", Font.BOLD, 14));
        textEmail.setBounds(300, 390, 400, 30);
        add(textEmail);

        JLabel labelMs = new JLabel("Fill your Address Details :");
        labelMs.setFont(new Font("Ralway", Font.BOLD, 20));
        labelMs.setBounds(100, 440, 250, 30);
        add(labelMs);

        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Ralway", Font.BOLD, 20));
        labelAdd.setBounds(100, 490, 200, 30);
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Ralway", Font.BOLD, 14));
        textAdd.setBounds(300, 490, 400, 30);
        add(textAdd);

        JLabel labelCity = new JLabel("PASSWORD :");
        labelCity.setFont(new Font("Ralway", Font.BOLD, 20));
        labelCity.setBounds(100, 540, 200, 30);
        add(labelCity);

        password = new JPasswordField();
        password.setFont(new Font("Ralway", Font.BOLD, 20));
        password.setBounds(300, 540, 400, 30);
        add(password);

        next = new JButton("Next");
        next.setFont(new Font("Ralway", Font.BOLD, 14));
        next.setOpaque(true);
        next.setContentAreaFilled(true);
        next.setFocusPainted(false);
        next.setBorderPainted(false);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        next.setBounds(620, 710, 80, 30);
        add(next);

        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next) {
            String name = textname.getText();
            String username = textFname.getText();
            String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            String gender = null;
            if (r1.isSelected()) {
                gender = "Male";
            } else if (r2.isSelected()) {
                gender = "Female";
            }
            String phn = textEmail.getText();
            String address = textAdd.getText();
            String Password = password.getText();
            try {
                if (textname.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the fields");
                } else {
                    ConUser con1 = new ConUser();
                    String q = "insert into user values('" + name + "','" + username + "','" + gender + "','" + dob + "','" + phn + "','" + address + "','" + Password + "')";
                    con1.statement.executeUpdate(q);
                    new Login();
                    setVisible(false);
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        }
}

    public static void main(String[] args){
        new Signup();

    }
}
