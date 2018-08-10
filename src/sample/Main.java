package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;


import java.awt.*;
import java.io.DataInput;
import java.io.PipedOutputStream;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane mainPane = new BorderPane();
        primaryStage.setTitle("Hello World");

        GridPane centerPane = new GridPane();

        centerPane.setAlignment(Pos.CENTER);

        Label log_lb = new Label ("Login:");
        Label passLb = new Label ("Password:");

        TextField loginTxt = new TextField();
        PasswordField passwField = new PasswordField();

        centerPane.add(log_lb,0,0);
        centerPane.add(passLb,0,1);

        centerPane.add(loginTxt,1,0);
        centerPane.add(passwField,1,1);

        mainPane.setLeft(null);
        BorderPane.setAlignment(centerPane, Pos.CENTER);

        mainPane.setCenter(centerPane);

        Button logInButton = new Button("LOG IN!");

        mainPane.setBottom(logInButton);


        primaryStage.setScene(new Scene(mainPane, 300, 275));

        primaryStage.show();

        DatabaseController dbController = new DatabaseController();

       logInButton.setOnAction(new EventHandler<ActionEvent>(){
          @Override
          public void handle(ActionEvent e){
             dbController.setConnection();
          }
        });

    }


    public static void main(String[] args) {
        launch(args);
    }
}
