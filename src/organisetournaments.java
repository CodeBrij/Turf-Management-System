import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class organisetournaments extends JFrame implements ActionListener{

    JButton submitbutton;
    JButton cancelbutton;
    JTextField text1;
    JTextField text2;
    JTextField text3;
    JTextField text4;
    JTextField text5;
    JRadioButton radioButton1;
    JRadioButton radioButton2;
    organisetournaments() {

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logo.png"));
        Image i2= i1.getImage().getScaledInstance(75,75,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setSize(75,75);
        icon.setLocation(80,10);
        icon.setHorizontalAlignment(JLabel.LEFT);
        this.add(icon);

        submitbutton = new JButton("Submit");
        submitbutton.setBounds(75,400,125,30);
        submitbutton.setFocusable(false);

        cancelbutton = new JButton("Cancel");
        cancelbutton.setBounds(250,400,125,30);
        cancelbutton.setFocusable(false);

        JLabel nlabel1 = new JLabel("Tournament Name");
        nlabel1.setBounds(40, 100, 200, 40);
        nlabel1.setFont(new Font(null,Font.BOLD,15));

        JLabel nlabel2 = new JLabel("Sport");
        nlabel2.setBounds(40, 150, 200, 40);
        nlabel2.setFont(new Font(null,Font.BOLD,15));

        JLabel nlabel3 = new JLabel("Type");
        nlabel3.setBounds(40, 200, 200, 40);
        nlabel3.setFont(new Font(null,Font.BOLD,15));

        JLabel nlabel4 = new JLabel("Date");
        nlabel4.setBounds(40, 250, 200, 40);
        nlabel4.setFont(new Font(null,Font.BOLD,15));

        JLabel nlabel5 = new JLabel("Time");
        nlabel5.setBounds(40, 300, 200, 40);
        nlabel5.setFont(new Font(null,Font.BOLD,15));

        JLabel nlabel6 = new JLabel("Turf Name");
        nlabel6.setBounds(40, 350, 200, 40);
        nlabel6.setFont(new Font(null,Font.BOLD,15));

        JLabel toplabel = new JLabel("Tournament Details");
        toplabel.setBounds(170,0,440,100);
        toplabel.setFont(new Font(null,Font.BOLD,20));

        radioButton1 = new JRadioButton();
        radioButton1.setText("Private");
        radioButton1.setBounds(225, 200, 100, 40);
        radioButton1.setFocusable(false);

        radioButton2 = new JRadioButton();
        radioButton2.setText("Public");
        radioButton2.setBounds(325, 200, 100, 40);
        radioButton2.setFocusable(false);

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);

        text1 = new JTextField();
        text1.setBounds(225, 100, 200, 40);
        text1.setHorizontalAlignment(JTextField.CENTER);

        text2 = new JTextField();
        text2.setBounds(225, 150, 200, 40);
        text2.setHorizontalAlignment(JTextField.CENTER);

        text3 = new JTextField();
        text3.setBounds(225, 250, 200, 40);
        text3.setText("DD/MM/YYYY");
        text3.setHorizontalAlignment(JTextField.CENTER);

        text4 = new JTextField();
        text4.setBounds(225, 300, 200, 40);
        text4.setText("HOUR:MINUTE");
        text4.setHorizontalAlignment(JTextField.CENTER);

        text5 = new JTextField();
        text5.setBounds(225, 350, 200, 40);
        text5.setHorizontalAlignment(JTextField.CENTER);

        submitbutton.addActionListener(this);
        cancelbutton.addActionListener(this);


        this.add(nlabel1);
        this.add(nlabel2);
        this.add(nlabel3);
        this.add(nlabel4);
        this.add(nlabel5);
        this.add(nlabel6);

        this.add(cancelbutton);
        this.add(submitbutton);

        this.add(toplabel);

        this.add(radioButton1);
        this.add(radioButton2);

        this.add(text1);
        this.add(text2);
        this.add(text3);
        this.add(text4);
        this.add(text5);

        this.setResizable(false);
        this.setTitle("Organise Tournaments");
        this.setSize(500, 500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == submitbutton) {
//            JOptionPane.showMessageDialog(null, "Tournament created", "Form Submission", JOptionPane.PLAIN_MESSAGE, null);
//            setVisible(false);
//        }
        if (e.getSource() == cancelbutton) {
            JOptionPane.showMessageDialog(null, "Are you sure?", "Form Submission", JOptionPane.QUESTION_MESSAGE, null);
            new homepage();
            setVisible(false);
        }
        if (e.getSource() == submitbutton) {
            JOptionPane.showMessageDialog(null, "Tournament created", "Form Submission", JOptionPane.PLAIN_MESSAGE, null);
            setVisible(false);

            String name = text1.getText();
            String sport = text2.getText();
            String date = text3.getText();
            String time = text4.getText();
            String turf = text5.getText();
            String type = "Public";
            if(radioButton1.isSelected())
                type = "Private";
            if(radioButton2.isSelected())
                type = "Public";
            try{
                if(name.isEmpty())
                {JOptionPane.showMessageDialog(null,"Fill all the fields");}
                else{
                    Con con1 = new Con();
                    String q ="insert into oragnisetour values('"+name+"','"+sport+"','"+date+"','"+type+"','"+time+"','"+turf+"')";
                    con1.statement.executeUpdate(q);
                    new organisetournaments();
                    setVisible(false);
                }

            }catch (Exception E)
            {
                E.printStackTrace();
            }
        }}
    public static void main(String[] args) {

        new organisetournaments();
    }
}




