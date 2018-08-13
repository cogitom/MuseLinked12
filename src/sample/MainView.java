package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MainView {

    private static BorderPane mainPane;
    private static GridPane centerPane;
    private static VBox bottomVbox;
    private static Button logInButton, signInButton;
    private static  TextField loginTxt;
    private static PasswordField passwField;
    private static Label logLb,passLb;

    public static BorderPane getMainPane(){
        return mainPane;
    }

    public static void initView () {
        mainPane = new BorderPane();

        centerPane = new GridPane();
        bottomVbox = new VBox();

        centerPane.setAlignment(Pos.CENTER);
        bottomVbox.setAlignment(Pos.CENTER);

        logLb = new Label("Login:");
        passLb = new Label("Password:");
        loginTxt = new TextField();
        passwField = new PasswordField();
        logInButton = new Button("LOG IN!");
        signInButton = new Button ("SIGN IN!");


        centerPane.add(logLb,0,0);
        centerPane.add(passLb,0,1);
        centerPane.add(loginTxt,1,0);
        centerPane.add(passwField,1,1);

        bottomVbox.getChildren().addAll(logInButton,signInButton);

        BorderPane.setAlignment(centerPane,Pos.CENTER);
        BorderPane.setAlignment(bottomVbox,Pos.CENTER);

        mainPane.setCenter(centerPane);
        mainPane.setBottom(bottomVbox);


        logInButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                String _login = loginTxt.getText();
                String _password = passwField.getText();

                if(DatabaseController.setConnection()) {
                    if(_login.length() != 0 && _password.length() != 0) {
                        DatabaseController.logInUser(_login,_password);
                    }
                    else{
                        System.out.print("Login and Password should be put!");
                    }
                }
                else{
                    System.out.print("Database Connection failed");
                }
            }
        });

        signInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }
}