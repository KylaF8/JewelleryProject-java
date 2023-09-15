package com.example.ca1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("displaycase.fxml"));
        primaryStage.setTitle("Jewellery Management System");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("displaycase.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 622 , 366);
        primaryStage.setTitle("Jewellery Store");
        primaryStage.setScene(scene);
        primaryStage.show();


    }



    public static void main(String[] args) {
        launch();
    }
}