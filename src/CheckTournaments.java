import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckTournaments extends JFrame implements ActionListener {
    private JTable table;
    private JScrollPane scrollPane;
    JButton button1;

    public CheckTournaments() {
        super("Check Tournaments");

        button1=new JButton("HOME");
        button1.setFont(new Font("ARIAL",Font.BOLD,14));
        button1.setForeground(Color.BLACK);
        button1.setBackground(Color.WHITE);
        button1.setBounds(50,500,100,30);
        button1.setFocusable(false);
        button1.addActionListener(this);
        add(button1);

        // Create a connection to the MySQL database
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tournament","root","root");
            Statement stmt = conn.createStatement();

            // Execute a SQL query to retrieve data from the table
            String query = "SELECT * FROM oragnisetour";
            ResultSet rs = stmt.executeQuery(query);

            // Create a JTable to display the data
            table = new JTable(buildTableModel(rs));
            scrollPane = new JScrollPane(table);
            getContentPane().add(scrollPane, BorderLayout.CENTER);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800, 600);
            setLocationRelativeTo(null);
            setVisible(true);

            // Close the database connection when done
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Convert ResultSet to a DefaultTableModel for JTable
    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        java.sql.ResultSetMetaData metaData = rs.getMetaData();

        // Get column names
        int columnCount = metaData.getColumnCount();
        String[] columnNames = new String[columnCount];
        for (int column = 1; column <= columnCount; column++) {
            columnNames[column - 1] = metaData.getColumnName(column);
        }

        // Get data rows
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                row[i] = rs.getObject(i + 1);
            }
            model.addRow(row);
        }

        return model;
    }

    public static void main(String[] args) {
        new CheckTournaments();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            new homepage();
            setVisible(false);
        }
    }
}

