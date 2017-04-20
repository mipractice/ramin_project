package com.resud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/newForm.fxml"));
        primaryStage.setTitle("CRUD App");
        primaryStage.setResizable(false);
//        primaryStage.setMinHeight(405);
//        primaryStage.setMinWidth(600);
        primaryStage.setScene(new Scene(parent, 800,600));
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
