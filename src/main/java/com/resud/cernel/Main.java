package com.resud.cernel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by RRM on 07.04.17.
 */
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("mainForm.fxml"));
        primaryStage.setTitle("CRUD");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(parent, 600,700));
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
