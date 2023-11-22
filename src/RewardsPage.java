import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RewardsPage extends JFrame implements ActionListener {
    JLabel label1,label2,label3,label4,label5;
    JButton button1;
    RewardsPage() {
        label1=new JLabel("REWARDS");
        label1.setBounds(400,50,450,40);
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("AvantGarde",Font.BOLD,38));
        add(label1);
        label2=new JLabel("With the accumulation of credit points, you unlock a world of rewards and exclusive opportunities." );
        label2.setBounds(20,90,900,100);
        label2.setFont(new Font("Ralway",Font.BOLD,20));

        //   label2.setFont(new Font("Ralway",Font.BOLD,14));
        label2.setForeground(Color.BLACK);
        add(label2);

        button1=new JButton("HOME");
        button1.setFont(new Font("ARIAL",Font.BOLD,14));
        button1.setForeground(Color.BLACK);
        button1.setBackground(Color.WHITE);
        button1.setBounds(50,40,100,30);
        button1.setFocusable(false);
        add(button1);

        label3=new JLabel("T-shirts         Shoes         Cash Prizes         Discount Coupons         VIP Experience ");
        label3.setForeground(Color.black);
        label3.setFont(new Font("Ralway",Font.BOLD,18));
        label3.setBounds(150,250,850,30);
        add(label3);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("tshirt.png"));
        Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(135,275,100,100);
        add(image);

        ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("shoes1.png"));
        Image ii2= ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3= new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(265,275,100,100);
        add(iimage);

        ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("cash.png"));
        Image iii2= iii1.getImage().getScaledInstance(95,95,Image.SCALE_DEFAULT);
        ImageIcon iii3= new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(395,275,100,100);
        add(iiimage);

        ImageIcon iiii1=new ImageIcon(ClassLoader.getSystemResource("discount.png"));
        Image iiii2= iiii1.getImage().getScaledInstance(95,95,Image.SCALE_DEFAULT);
        ImageIcon iiii3= new ImageIcon(iiii2);
        JLabel iiiimage = new JLabel(iiii3);
        iiiimage.setBounds(565,275,100,100);
        add(iiiimage);

        ImageIcon iiiii1=new ImageIcon(ClassLoader.getSystemResource("vip.png"));
        Image iiiii2= iiiii1.getImage().getScaledInstance(95,95,Image.SCALE_DEFAULT);
        ImageIcon iiiii3= new ImageIcon(iiiii2);
        JLabel iiiiimage = new JLabel(iiiii3);
        iiiiimage.setBounds(740,275,100,100);
        add(iiiiimage);

        label4=new JLabel("   100                    150                  200                          250                                  300 ");
        label4.setForeground(Color.black);
        label4.setFont(new Font("Ralway",Font.BOLD,18));
        label4.setBounds(150,400,850,30);
        add(label4);

        label5=new JLabel("   Exclusive T-Shirts             Turfit Shoes              Cashback upto ₹200            Win exciting coupons                       Access to private events ");
        label5.setForeground(Color.black);
        label5.setFont(new Font("Ralway",Font.ITALIC,12));
        label5.setBounds(110,450,850,30);
        add(label5);

        button1.addActionListener(this::actionPerformed);

        setLayout(null);
        setSize(1000, 700);
        setLocation(200, 50);
        setVisible(true);
    }



    public static void main(String[] args) {
        new RewardsPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            homepage home = new homepage();
            setVisible(false);
        }
    }
}
