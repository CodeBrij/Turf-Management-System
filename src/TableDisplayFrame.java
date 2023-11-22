import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TableDisplayFrame extends JFrame {
    public JTable table;

    public TableDisplayFrame() {
        setTitle("User Counts Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Connect to your database (replace with your connection details)
        String url = "jdbc:mysql://localhost:3306/tournament";
        String user = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String query = "SELECT USERNAME, " +
                    "COUNT(USERNAME) AS CREDITS1, " +
                    "COUNT(USERNAME) AS CREDITS2, " +
                    "COUNT(USERNAME) AS CREDITS3, " +
                    "COUNT(USERNAME) AS CREDITS4, " +
                    "COUNT(USERNAME) AS CREDITS5 " +
                    "FROM booktournament " +
                    "GROUP BY USERNAME " +
                    "HAVING COUNT(USERNAME) >= 1 OR " +
                    "COUNT(USERNAME) >= 3 OR " +
                    "COUNT(USERNAME) >= 4 OR " +
                    "COUNT(USERNAME) >= 5 OR " +
                    "COUNT(USERNAME) >= 6";

            ResultSet resultSet = statement.executeQuery(query);

            // Create a DefaultTableModel and populate it with the query result
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"USERNAME", "CREDITS1", "CREDITS2", "CREDITS3", "CREDITS4", "CREDITS5"});

            while (resultSet.next()) {
                Object[] row = new Object[6];
                for (int i = 0; i < 6; i++) {
                    row[i] = resultSet.getObject(i + 1);
                }
                model.addRow(row);
            }

            // Create a JTable with the table model
            table = new JTable(model);

            // Add the JTable to a JScrollPane for scrolling
            JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane);

            pack();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TableDisplayFrame frame = new TableDisplayFrame();
            frame.setVisible(true);
        });
    }
}
