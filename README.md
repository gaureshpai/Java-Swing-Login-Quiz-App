## Java Swing Login Application

This is a simple Java Swing-based login application designed for user authentication.
The application provides a user interface for entering a username and password, with an option to show/hide the password. 
Additionally, it includes a "Forgot Password?" feature allowing users to recover their passwords through a security question.

## Features

- **Login Form:** Users can enter their username and password to log in.
- **Show Password:** Checkbox to toggle the visibility of the entered password.
- **Forgot Password:** Users can recover their passwords by answering a security question.
- **Styling:** The application features a clean and intuitive user interface with proper styling.

## Components

- **Username and Password Fields:** Text fields for entering the username and password.
- **Show Password Checkbox:** Checkbox to show or hide the entered password.
- **Login Button:** Initiates the login process.
- **Forgot Password Button:** Allows users to recover their passwords.
- **Error Handling:** Displays error messages for invalid login attempts.

## Usage

1. Enter a valid username and password.
2. Click the "Login" button to log in.
3. Optionally, use the "Show Password" checkbox to reveal the entered password.
4. Click the "Forgot Password?" button to recover a forgotten password.

## Forgot Password

- The "Forgot Password" feature prompts the user to enter their username.
- If the username exists, a window will appear with a security question.
- Users can answer the security question to reset their password.

## Implementation Details

- The application is built using Java Swing for the graphical user interface.
- User authentication is handled through a simple array of predefined users.
- Background tasks, such as login validation, are executed using SwingWorker.

## Dependencies

- Java Development Kit (JDK) version 8 or later.

## How to Run

1. Ensure you have the Java Development Kit (JDK) installed.
2. Compile and run the `LoginApp` class.

   ```bash
   javac LoginApp.java
   java LoginApp

The application window will appear, allowing users to log in or recover their passwords.
Developer
Gauresh G Pai

## License
This project is licensed under the MIT License. Feel free to use, modify, and distribute the code. Contributions are welcome!
