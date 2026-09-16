package com.patient.patientdoctor;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;

public class loginController {
    @FXML
    private Label error;
    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private TextField employeeid;
    @FXML private Label passwordwarning;
    @FXML private Label employeeidwarning;
    @FXML private Label  usernamewarning;
    @FXML private Button clear;
    @FXML private static final String PasswordRegex= "^. {8,}$";
    @FXML public void initialize(){
        password.textProperty().addListener((obs,oldVal,newVal) ->
                validatePassword(newVal));
        username.textProperty().addListener((obs,oldVal,newVal) ->
                validateUsername(newVal));
        employeeid.textProperty().addListener((obs,oldVal,newVal)->
                validateEmployeeId(newVal));


    }

    private void validateEmployeeId(String eId) {
        if(!eId.matches("^Emp/[A-Z]/\\d{4}/\\d{4}$\n")){
            employeeidwarning.setText("Wrong format please try again. Eg Emp/D/1234/2009");
        }else{
            employeeidwarning.setText("");
        }
    }


    @FXML
    protected void onLoginClick() {
        String usernameText = username.getText();
        if(usernameText.isEmpty() && password.getText().isEmpty()){
            error.setText("Please enter your name!!");
        }
        else{
            if(!isPasswordValidation()){
                error.setText("Please enter a strong password!");
            }
            //saving it to the database.
            error.setText("the login username is valid");
        }
    }
    @FXML public void validatePassword(String password){
        if(password.length()<8){
            passwordwarning.setText("password should have eight and above digits");
        }
        if (!password.matches(".*\\d*.*")) {
            passwordwarning.setText("password should contain at least one digit");
        }
        if (!password.matches(".*[A-Z].*")) {
            passwordwarning.setText("password should contain at least one uppercase letter");

        }
         if(password.matches(".*[A-Z].*") && password.matches(".*\\d*.*") && password.length()>=8){
            passwordwarning.setText("");}
    }
    @FXML public void validateUsername(String username){
        if(username.isEmpty()){
            usernamewarning.setText("Please fill in your username!!");
        }else{
            usernamewarning.setText("");
        }

    }
    @FXML public boolean isPasswordValidation(){
        return password.getText().matches(PasswordRegex);

    }
    @FXML public void clearbtn(){
        username.setText("");
        employeeid.setText("");
        password.setText("");
    }


}
