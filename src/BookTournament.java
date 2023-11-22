import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BookTournament extends JFrame implements ActionListener{

    JButton submitbutton;
    JButton cancelbutton;
    JTextField text1;
    JTextField text3;
    JTextField text4;
    JTextField text5,text2;
    public BookTournament() {

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

        JLabel nlabel2 = new JLabel("UserName");
        nlabel2.setBounds(40, 150, 200, 40);
        nlabel2.setFont(new Font(null,Font.BOLD,15));

        JLabel nlabel4 = new JLabel("Date");
        nlabel4.setBounds(40, 200, 200, 40);
        nlabel4.setFont(new Font(null,Font.BOLD,15));

        JLabel nlabel5 = new JLabel("Time");
        nlabel5.setBounds(40, 250, 200, 40);
        nlabel5.setFont(new Font(null,Font.BOLD,15));

        JLabel nlabel6 = new JLabel("Turf Name");
        nlabel6.setBounds(40, 300, 200, 40);
        nlabel6.setFont(new Font(null,Font.BOLD,15));

        JLabel toplabel = new JLabel("Book Tournament");
        toplabel.setBounds(170,0,440,100);
        toplabel.setFont(new Font(null,Font.BOLD,20));

        text1 = new JTextField();
        text1.setBounds(225, 100, 200, 40);
        text1.setText("Tournament Name");
        text1.setHorizontalAlignment(JTextField.CENTER);

        text2 = new JTextField();
        text2.setBounds(225, 150, 200, 40);
        text2.setText("Username");
        text2.setHorizontalAlignment(JTextField.CENTER);

        text3 = new JTextField();
        text3.setBounds(225, 200, 200, 40);
        text3.setText("DD/MM/YYYY");
        text3.setHorizontalAlignment(JTextField.CENTER);

        text4 = new JTextField();
        text4.setBounds(225, 250, 200, 40);
        text4.setText("HOUR:MINUTE");
        text4.setHorizontalAlignment(JTextField.CENTER);

        text5 = new JTextField();
        text5.setBounds(225, 300, 200, 40);
        text5.setText("Name of Turf");
        text5.setHorizontalAlignment(JTextField.CENTER);

        submitbutton.addActionListener(this);
        cancelbutton.addActionListener(this);

        this.add(nlabel2);
        this.add(nlabel1);
        this.add(nlabel4);
        this.add(nlabel5);
        this.add(nlabel6);

        this.add(cancelbutton);
        this.add(submitbutton);

        this.add(toplabel);

        this.add(text2);
        this.add(text1);
        this.add(text3);
        this.add(text4);
        this.add(text5);

        this.setResizable(false);
        this.setTitle("Booked Tournaments");
        this.setSize(500, 500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelbutton) {
            JOptionPane.showMessageDialog(null, "Are you sure?", "Form Submission", JOptionPane.QUESTION_MESSAGE, null);
            new homepage();
            setVisible(false);
        }
        if (e.getSource() == submitbutton) {
            JOptionPane.showMessageDialog(null, "Tournament booked", "Form Submission", JOptionPane.PLAIN_MESSAGE, null);
            setVisible(false);

            String name = text1.getText();
            String username = text2.getText();
            String date = text3.getText();
            String time = text4.getText();
            String turf = text5.getText();
            try{
                if(name.isEmpty())
                {JOptionPane.showMessageDialog(null,"Fill all the fields");}
                else{
                    BookConnection bookConnection = new BookConnection();
                    String q ="insert into booktournament values('"+name+"','"+username+"','"+date+"','"+time+"','"+turf+"')";
                    bookConnection.statement.executeUpdate(q);
                    new BookTournament();
                    setVisible(false);
                }

            }catch (Exception E)
            {
                E.printStackTrace();
            }
        }}
    public static void main(String[] args) {
        new BookTournament();
    }
}




