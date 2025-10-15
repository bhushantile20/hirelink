package com.hirelink.ui;

import com.hirelink.dao.EmployeeDAO;
import com.hirelink.dao.CandidateDAO;
import com.hirelink.model.Employee;
import com.hirelink.model.Candidate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class HireLinkUI {

    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private Label messageLabel;

    private Employee loggedInEmployee;

    @FXML
    public void handleLogin(ActionEvent event) throws IOException {
        EmployeeDAO dao = new EmployeeDAO();
        Employee emp = dao.login(emailField.getText(), passwordField.getText());
        if (emp != null) {
            loggedInEmployee = emp;
            messageLabel.setText("Login successful!");
            openDashboard();
        } else {
            messageLabel.setText("Invalid email or password.");
        }
    }

    @FXML
    public void handleRegister(ActionEvent event) {
        EmployeeDAO dao = new EmployeeDAO();
        Employee emp = new Employee("New User", emailField.getText(), passwordField.getText());
        if (dao.registerEmployee(emp)) messageLabel.setText("Registered Successfully!");
        else messageLabel.setText("Registration Failed!");
    }

    private void openDashboard() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/hirelink/ui/fxml/dashboard.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) emailField.getScene().getWindow();
        stage.setScene(new Scene(root, 400, 300));
    }
}
