package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{

        this.primaryStage = primaryStage;
        MainView.initView();
        this.primaryStage.setScene(new Scene(MainView.getMainPane(), 300, 275));
        this.primaryStage.show();

    }

    public void showLogInScene() {
        this.primaryStage.
    }



    public static void main(String[] args) {
        launch(args);
    }
}
