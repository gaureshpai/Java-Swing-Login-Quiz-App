import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class User {
    String username;
    String password;
    public User(String username, String password) {
        this.username = username;  // Use "this" to assign to object fields
        this.password = password;
    }
}

public class LoginApp extends JFrame implements ActionListener {
	
	JLabel L1,L2;
	JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;
    JLabel errorLabel;

    LinkedList<User> users = new LinkedList<>(); 
    
    public LoginApp() {
 
    	
        setTitle("Login");
        setLayout(new GridLayout(5,10,20,40));
        User a = new User("fakeuser","fakeuser123");
        users.add(a);

        add(L1 = new JLabel("Username:"));
        add(usernameField = new JTextField());

        add(L2 = new JLabel("Password:"));
        add(passwordField = new JPasswordField());
        
        add(new JLabel(""));
        add(loginButton = new JButton("Login"));
        add(errorLabel = new JLabel());
        errorLabel.setForeground(Color.RED);
        loginButton.addActionListener(this);

        setSize(400,350);
        setLocation(250,100);
//        setLocationRelativeTo(null); // Center the window
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
                    OnlineTest testapp = new OnlineTest("online test of java for "+user.username);
                    testapp.setVisible(true);
                    break;
                }
            }

            if (!found) {
                errorLabel.setText("Invalid username or password");
            }
        }
    }
    public static void main(String s[])
	{
    	new LoginApp().setVisible(true);
	}
}