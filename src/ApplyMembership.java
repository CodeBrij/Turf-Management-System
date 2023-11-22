import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplyMembership extends JFrame implements ActionListener {
    JButton back;
    JButton gold;
    JButton silver;
    JButton bronze;
    ApplyMembership() {
        back = new JButton("Back to Homepage");
        back.setBounds(10, 400, 210, 30);
        back.setHorizontalAlignment(JLabel.LEFT);
        back.setFocusable(false);

        gold = new JButton("Apply for Gold Membership");
        gold.setBounds(10, 100, 210, 30);
        gold.setHorizontalAlignment(JLabel.LEFT);
        gold.setBackground(new Color(250, 238, 0, 255));
        gold.setFocusable(false);

        silver = new JButton("Apply for Silver Membership");
        silver.setBounds(10, 200, 210, 30);
        silver.setBackground(new Color(225, 225, 225));
        silver.setFocusable(false);

        bronze = new JButton("Apply for Bronze Membership");
        bronze.setBounds(10, 300, 210, 30);
        bronze.setBackground(new Color(243, 155, 67));
        bronze.setFocusable(false);

        JLabel apply = new JLabel("Apply for Membership");
        apply.setSize(440, 100);
        apply.setFont(new Font(null, Font.BOLD, 20));
        apply.setHorizontalAlignment(JLabel.CENTER);

        JLabel label1 = new JLabel("Benefits : Free entry to 5 tournaments valid for 3 months");
        label1.setSize(440, 30);
        label1.setLocation(10, 130);
        label1.setFont(new Font(null, Font.PLAIN, 15));

        JLabel label2 = new JLabel("Benefits : Free entry to 3 tournaments valid for 1 month");
        label2.setSize(440, 30);
        label2.setLocation(10, 230);
        label2.setFont(new Font(null, Font.PLAIN, 15));

        JLabel label3 = new JLabel("Benefits : Free entry to 3 tournaments valid for 15 days");
        label3.setSize(440, 30);
        label3.setLocation(10, 330);
        label3.setFont(new Font(null, Font.PLAIN, 15));

        gold.addActionListener(this);
        silver.addActionListener(this);
        bronze.addActionListener(this);
        back.addActionListener(this);

        this.add(gold);
        this.add(silver);
        this.add(bronze);
        this.add(back);

        this.add(label1);
        this.add(label2);
        this.add(label3);

        this.add(apply);
        this.getContentPane().setBackground(new Color(24, 170, 170));
        this.setResizable(false);
        this.setTitle("Apply for Membership");
        this.setSize(500, 500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ApplyMembership();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            homepage homepage= new homepage();
            setVisible(false);
        }
        if(e.getSource()==gold){
            JOptionPane.showMessageDialog(null,"Memberships coming soon!!!","Coming Soon",JOptionPane.PLAIN_MESSAGE,null);
            setVisible(false);
        }
        if(e.getSource()==silver){
            JOptionPane.showMessageDialog(null,"Memberships coming soon!!!","Coming Soon",JOptionPane.PLAIN_MESSAGE,null);
            setVisible(false);
        }
        if(e.getSource()==bronze){
            JOptionPane.showMessageDialog(null,"Memberships coming soon!!!","Coming Soon",JOptionPane.PLAIN_MESSAGE,null);
            setVisible(false);
        }
    }
}