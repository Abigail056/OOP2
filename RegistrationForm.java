import javax.swing.*;
import java.awt.*;

public class RegistrationForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Registration Form");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel titleLabel = new JLabel("Registration Form");
        titleLabel.setBounds(300, 10, 300, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(titleLabel);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 60, 100, 20);
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 60, 150, 20);
        frame.add(nameLabel);
        frame.add(nameField);

        // Mobile
        JLabel mobileLabel = new JLabel("Mobile:");
        mobileLabel.setBounds(50, 90, 100, 20);
        JTextField mobileField = new JTextField();
        mobileField.setBounds(150, 90, 150, 20);
        frame.add(mobileLabel);
        frame.add(mobileField);

        // Gender
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 120, 100, 20);
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(150, 120, 70, 20);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(220, 120, 80, 20);
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        frame.add(genderLabel);
        frame.add(male);
        frame.add(female);

        // DOB
        JLabel dobLabel = new JLabel("DOB:");
        dobLabel.setBounds(50, 150, 100, 20);
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) days[i] = String.valueOf(i + 1);
        JComboBox<String> day = new JComboBox<>(days);
        day.setBounds(150, 150, 50, 20);

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
                           "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        JComboBox<String> month = new JComboBox<>(months);
        month.setBounds(210, 150, 60, 20);

        String[] years = new String[100];
        for (int i = 0; i < 100; i++) years[i] = String.valueOf(2025 - i);
        JComboBox<String> year = new JComboBox<>(years);
        year.setBounds(280, 150, 60, 20);

        frame.add(dobLabel);
        frame.add(day);
        frame.add(month);
        frame.add(year);

        // Address
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 180, 100, 20);
        JTextArea addressArea = new JTextArea();
        addressArea.setBounds(150, 180, 190, 60);
        frame.add(addressLabel);
        frame.add(addressArea);

        // Terms
        JCheckBox terms = new JCheckBox("Accept Terms And Conditions.");
        terms.setBounds(50, 250, 250, 20);
        frame.add(terms);

        // Buttons
        JButton submit = new JButton("Submit");
        submit.setBounds(50, 280, 100, 25);
        JButton reset = new JButton("Reset");
        reset.setBounds(160, 280, 100, 25);
        frame.add(submit);
        frame.add(reset);

        // Placeholder for data display (we'll use JTable here later)
        JTextArea dataDisplay = new JTextArea();
        dataDisplay.setBounds(400, 60, 350, 200);
        frame.add(dataDisplay);

        frame.setVisible(true);
    }
}
