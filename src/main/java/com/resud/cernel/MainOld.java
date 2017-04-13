package com.resud.cernel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by RRM on 08.04.17.
 */
public class MainOld extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/mainW.fxml"));

        primaryStage.setTitle("CRUD");
        primaryStage.setMinHeight(350);
        primaryStage.setMinWidth(558);
        primaryStage.setScene(new Scene(parent, 558,350));
        primaryStage.show();
    }
}
