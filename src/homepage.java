import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class homepage extends JFrame implements ActionListener{
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JButton btn5;
    JButton button1,button2,button3,button4;
    homepage()
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logo.png"));
        Image i2= i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setSize(150,150);
        icon.setLocation(15,100);
        icon.setHorizontalAlignment(JLabel.LEFT);
        this.add(icon);

        JLabel label2 = new JLabel("TurFit - Turf Management System");
        label2.setBounds(180, 140, 600, 30);
        label2.setFont(new Font("Raleway", 1, 22));
        this.add(label2);

        JLabel label1 = new JLabel("Come on and Unveil the Player");
        label1.setBounds(240, 160, 600, 30);
        label1.setFont(new Font("Times New Roman", 1, 15));
        this.add(label1);

        JPanel panel1=new JPanel();
        panel1.setBackground(new Color(24, 170, 170));
        panel1.setBounds(0,0,580,60);


        button1= new JButton("HOMEPAGE");
        button1.setBounds(10,15,120,30);
        button1.setFocusable(false);

        button2= new JButton("BOOKINGS");
        button2.setBounds(150,15,120,30);
        button2.setFocusable(false);

        button3= new JButton("TURF LIST");
        button3.setBounds(290,15,120,30);
        button3.setFocusable(false);

        button4= new JButton("REWARDS");
        button4.setBounds(430,15,120,30);
        button4.setFocusable(false);

        btn1=new JButton("Organise Tournaments");
        btn1.setFocusable(false);
        btn1.setBounds(70,300,420,30);

        btn2=new JButton("Check Tournaments");
        btn2.setFocusable(false);
        btn2.setBounds(70,350,420,30);

        btn3=new JButton("Apply for Membership");
        btn3.setFocusable(false);
        btn3.setBounds(70,400,420,30);

        btn4=new JButton("Book Tournament");
        btn4.setFocusable(false);
        btn4.setBounds(70,450,420,30);

        btn5 = new JButton("Back to Login");
        btn5.setFocusable(false);
        btn5.setBounds(70,500,420,30);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn5.addActionListener(this);
        btn4.addActionListener(this);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

        this.add(btn1);
        this.add(btn2);
        this.add(btn4);
        this.add(btn3);
        this.add(btn5);
        this.add(label2);

        this.setTitle("Homepage");

        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(panel1);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(580,600);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            organisetournaments organise = new organisetournaments();
            organise.setVisible(true);
            this.setVisible(false); // Hide the current frame
        }
        if (e.getSource() == btn2) {
            CheckTournaments checkTournaments = new CheckTournaments();
            checkTournaments.setVisible(true);
            this.setVisible(false);

        }
        if (e.getSource() == btn3) {
            ApplyMembership applyMembership = new ApplyMembership();
            applyMembership.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == btn4) {
            new BookTournament();
            this.setVisible(false);
        }
        if (e.getSource() == btn5) {
            Login login = new Login();
            login.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == button1) {
            this.setVisible(true);
        }
        if (e.getSource() == button2) {
            BookDisplayDatabase bookDisplayDatabase = new BookDisplayDatabase();
            bookDisplayDatabase.setVisible(true);
            this.setVisible(false);
            new homepage();
        }
        if (e.getSource() == button3) {
            new TurfListPage().setVisible(true);
            this.setVisible(false);
            new homepage();
        }
        if (e.getSource() == button4) {
            new RewardsPage().setVisible(true);
            this.setVisible(false);
            new homepage();
        }
    }

    public static void main(String[] args) {
        new homepage();
    }
}




