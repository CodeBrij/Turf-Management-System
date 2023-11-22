import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends JFrame {
    private final JPanel contentPanel;
    AdminPage() {
        this.setTitle("Admin Dashboard");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo.png"));
        Image i2 = i1.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imageLabel = new JLabel(i3);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBackground(new Color(24, 170, 170));
        leftPanel.setPreferredSize(new Dimension(220, 600));
        leftPanel.add(imageLabel, BorderLayout.NORTH);

        JPanel navigationPanel = new JPanel();
        navigationPanel.setLayout(new GridLayout(5, 1, 20, 20));
        navigationPanel.setBackground(new Color(24, 170, 170));

        JButton turflistButton = createNavigationButton("Turf List");
        JButton checkButton = createNavigationButton("Check Tournaments");
        JButton earningButton = createNavigationButton("Check UserRewards");
        JButton userlistButton = createNavigationButton("User List");
        JButton maintenanceButton = createNavigationButton("Maintenance");

        navigationPanel.add(turflistButton);
        navigationPanel.add(checkButton);
        navigationPanel.add(earningButton);
        navigationPanel.add(userlistButton);
        navigationPanel.add(maintenanceButton);

        leftPanel.add(navigationPanel, BorderLayout.CENTER);
        this.add(leftPanel, BorderLayout.WEST);

        contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(null);
        this.add(contentPanel, BorderLayout.CENTER);

        this.setResizable(true);
        this.setVisible(true);
    }

    private JButton createNavigationButton(String text) {
        JButton button = new JButton(text);
        button.setFocusable(false);
        button.setForeground(Color.BLACK);
        button.setBackground(Color.LIGHT_GRAY);

        // Set the preferred size
        button.setPreferredSize(new Dimension(180, 30));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPanel.removeAll();

                if (text.equals("Turf List")) {
                    new TurfListPage();
                } else if (text.equals("Check Tournaments")) {
                    new CheckTournaments();
                } else if (text.equals("Check UserRewards")) {
                    TableDisplayFrame tableDisplayFrame = new TableDisplayFrame(); // Create an instance
                    tableDisplayFrame.setVisible(true);
                } else if (text.equals("User List")) {
//                    JLabel userListLabel = new JLabel("User List Content");
//                    userListLabel.setBounds(10, 10, 200, 30);
//                    contentPanel.add(userListLabel);
                        new DisplayDatabaseTable();
                } else if (text.equals("Maintenance")) {
//                    JLabel maintenanceLabel = new JLabel("Maintenance Content");
//                    maintenanceLabel.setBounds(10, 10, 250, 30);
//                    contentPanel.add(maintenanceLabel);
                    new MaintainencePage();
                }

                contentPanel.revalidate();
                contentPanel.repaint();
            }
        });
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AdminPage::new);
    }
}

