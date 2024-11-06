package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class MainFrame extends JFrame {

    private JTextField idField, moneyField, bathField, rateField, firstNameField, lastNameField, ageField;
    private JComboBox<String> dayOpenBox, monthOpenBox, yearOpenBox, dayBirthBox, monthBirthBox, yearBirthBox;

    public MainFrame() {
        setTitle("Show Detail of Account Money");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("ID:"), gbc);

        gbc.gridx = 1;
        idField = new JTextField(15);
        panel.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("MONEY:"), gbc);

        gbc.gridx = 1;
        moneyField = new JTextField(15);
        panel.add(moneyField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("BATH:"), gbc);

        gbc.gridx = 1;
        bathField = new JTextField(15);
        panel.add(bathField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("ANNUAL INTEREST RATE:"), gbc);

        gbc.gridx = 1;
        rateField = new JTextField(15);
        panel.add(rateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("DAY OPEN ACCOUNT:"), gbc);

        gbc.gridx = 1;
        JPanel openDatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        dayOpenBox = new JComboBox<>(DateUtils.getDayOptions());
        monthOpenBox = new JComboBox<>(DateUtils.getMonthOptions());
        yearOpenBox = new JComboBox<>(DateUtils.getYearOptions());
        openDatePanel.add(dayOpenBox);
        openDatePanel.add(monthOpenBox);
        openDatePanel.add(yearOpenBox);
        panel.add(openDatePanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("FIRST NAME:"), gbc);

        gbc.gridx = 1;
        firstNameField = new JTextField(15);
        panel.add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("LAST NAME:"), gbc);

        gbc.gridx = 1;
        lastNameField = new JTextField(15);
        panel.add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("BIRTH DAY:"), gbc);

        gbc.gridx = 1;
        JPanel birthDatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        dayBirthBox = new JComboBox<>(DateUtils.getDayOptions());
        monthBirthBox = new JComboBox<>(DateUtils.getMonthOptions());
        yearBirthBox = new JComboBox<>(DateUtils.getYearOptions());
        birthDatePanel.add(dayBirthBox);
        birthDatePanel.add(monthBirthBox);
        birthDatePanel.add(yearBirthBox);
        panel.add(birthDatePanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("AGE:"), gbc);

        gbc.gridx = 1;
        ageField = new JTextField(15);
        panel.add(ageField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton saveButton = new JButton("SAVE");
        buttonPanel.add(saveButton);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });

        add(panel);
    }

    private void saveData() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.saveToDatabase(
            idField.getText(),
            Double.parseDouble(moneyField.getText()),
            Double.parseDouble(bathField.getText()),
            Double.parseDouble(rateField.getText()),
            LocalDate.of(
                Integer.parseInt((String) yearOpenBox.getSelectedItem()),
                monthOpenBox.getSelectedIndex() + 1,
                Integer.parseInt((String) dayOpenBox.getSelectedItem())
            ),
            firstNameField.getText(),
            lastNameField.getText(),
            LocalDate.of(
                Integer.parseInt((String) yearBirthBox.getSelectedItem()),
                monthBirthBox.getSelectedIndex() + 1,
                Integer.parseInt((String) dayBirthBox.getSelectedItem())
            ),
            Integer.parseInt(ageField.getText())
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame gui = new MainFrame();
            gui.setVisible(true);
        });
    }
}