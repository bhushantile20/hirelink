package com.hirelink.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HireLinkApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/hirelink/ui/fxml/login.fxml"));
        primaryStage.setScene(new Scene(loader.load(), 400, 300));
        primaryStage.setTitle("HireLink - Employee Portal");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

