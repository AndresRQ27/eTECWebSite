package main;

import general.ScreenSize;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by andres on 17/05/17.
 * DrApp
 * main.casosClinicos
 */
public class MainDemoApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage Stage) throws IOException {
        Stage.setTitle("DrApp");

        Scene scene = new Scene(new StackPane(), ScreenSize.getWidth(), ScreenSize.getHeight());

        MainManager mainManager = new MainManager(scene);
        mainManager.showMainScreen();

        Stage.setScene(scene);
        Stage.show();
    }
}

