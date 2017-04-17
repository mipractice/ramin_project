package com.resud;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main extends Application{

    public static EntityManagerFactory entityManagerFactory;

    @Override
    public void start(Stage primaryStage) throws Exception {

        entityManagerFactory = Persistence.createEntityManagerFactory("CRUD");

        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/mainForm.fxml"));
        primaryStage.setTitle("CRUD App");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(parent, 600,405));
        primaryStage.show();

//        primaryStage.setOnCloseRequest(e -> {
//            entityManagerFactory.close();
//            Platform.exit();
//            System.exit(0);
//        });
    }

    public static void main(String[] args){
        launch(args);
    }
}
