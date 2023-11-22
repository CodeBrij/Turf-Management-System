import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaintainencePage {
    private DefaultListModel<String> todoListModel;
    private JList<String> todoList;

    public MaintainencePage() {
        JFrame frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JLabel titleLabel = new JLabel("Maintenance Checklist");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        todoListModel = new DefaultListModel<>();
        todoList = new JList<>(todoListModel);

        todoList.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));


        JTextField taskInput = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskInput.getText();
                if (!task.isEmpty()) {
                    todoListModel.addElement(task);
                    taskInput.setText("");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedIndices = todoList.getSelectedIndices();
                for (int i = selectedIndices.length - 1; i >= 0; i--) {
                    int selectedIndex = selectedIndices[i];
                    if (selectedIndex != -1) {
                        todoListModel.remove(selectedIndex);
                    }
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(taskInput);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        JPanel titlePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0);
        titlePanel.add(titleLabel, gbc);

        titlePanel.setBackground(new Color(24,170,170));

        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(todoList), BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MaintainencePage();
            }
        });
    }
}
