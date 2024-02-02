import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;

class User {
    String username;
    char[] password;

    public User(String username, char[] password) {
        this.username = username;
        this.password = password;
    }
}

public class LoginApp extends JFrame implements ActionListener {

    private static final String USERNAME_LABEL_TEXT = "Username:";
    private static final String PASSWORD_LABEL_TEXT = "Password:";

    JLabel usernameLabel, passwordLabel, errorLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JCheckBox showPasswordCheckbox;
    JButton loginButton;

    // Use an array to store multiple users
    User[] users = {new User("user1", "password1".toCharArray()),new User("a","b".toCharArray()), new User("user2", "password2".toCharArray())};

    public LoginApp() {
        setTitle("Login");
        setLayout(new BorderLayout(20, 20));

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.add(new JLabel(USERNAME_LABEL_TEXT));
        inputPanel.add(usernameField = new JTextField());
        inputPanel.add(new JLabel(PASSWORD_LABEL_TEXT));
        inputPanel.add(passwordField = new JPasswordField());
        inputPanel.add(new JLabel()); // Empty label for spacing
        inputPanel.add(showPasswordCheckbox = new JCheckBox("Show Password"));

        // Change the background color and font style for the inputPanel
        inputPanel.setBackground(new Color(230, 230, 255));
        Font inputFont = new Font("Arial", Font.PLAIN, 14);
        usernameField.setFont(inputFont);
        passwordField.setFont(inputFont);
        inputPanel.setFont(inputFont);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        buttonPanel.add(loginButton);

        // Change the background color and font style for the buttonPanel
        buttonPanel.setBackground(new Color(200, 200, 255));
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        errorLabel = new JLabel();
        errorLabel.setForeground(Color.RED);
        // Change the font style for the errorLabel
        errorLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(errorLabel, BorderLayout.NORTH);

        // Add ActionListener to the checkbox
        showPasswordCheckbox.addActionListener(this);

        setSize(400, 250);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();

            boolean found = false;

            for (User user : users) {
                if (user.username.equals(username) && Arrays.equals(user.password, passwordChars)) {
                    found = true;
                    // Grant access here
                    dispose();
                    // Display a success message or navigate to the next screen
                    OnlineTest testApp = new OnlineTest("Online Test of Java for " + user.username);
                    testApp.setVisible(true);
                    break;
                }
            }

            if (!found) {
                errorLabel.setText("Invalid username or password");
                // Clear the password on unsuccessful login
                Arrays.fill(passwordChars, ' ');
                passwordField.setText("");
            }
        } else if (e.getSource() == showPasswordCheckbox) {
            // Toggle password visibility
            passwordField.setEchoChar(showPasswordCheckbox.isSelected() ? '\0' : '*');
        }
    }

    public static void main(String s[]) {
        SwingUtilities.invokeLater(() -> {
            new LoginApp().setVisible(true);
        });
    }
}
