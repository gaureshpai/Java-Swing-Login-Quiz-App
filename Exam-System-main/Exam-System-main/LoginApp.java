import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class User {
    String username;
    String password;

    public User(String username, String password) {
        this.username = username;  
        this.password = password;
    }
}

public class LoginApp extends JFrame implements ActionListener {

    JLabel L1, L2, errorLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    // Use an array to store multiple users
    User[] users = { new User("user1", "password1"), new User("user2", "password2") };

    public LoginApp() {

        setTitle("Login");
        setLayout(new GridLayout(5, 2, 20, 20));

        add(L1 = new JLabel("Username:"));
        add(usernameField = new JTextField());

        add(L2 = new JLabel("Password:"));
        add(passwordField = new JPasswordField());

        add(new JLabel("")); // Empty label for spacing
        add(loginButton = new JButton("Login"));
        loginButton.addActionListener(this);

        add(errorLabel = new JLabel());
        errorLabel.setForeground(Color.RED);

        setSize(400, 200);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            boolean found = false;

            for (User user : users) {
                if (user.username.equals(username) && user.password.equals(password)) {
                    found = true;
                    // Grant access here
                    dispose();
                    OnlineTest testapp = new OnlineTest("Online Test of Java for " + user.username);
                    testapp.setVisible(true);
                    break;
                }
            }

            if (!found) {
                errorLabel.setText("Invalid username or password");
            }
        }
    }

    public static void main(String s[]) {
        new LoginApp().setVisible(true);
    }
}
