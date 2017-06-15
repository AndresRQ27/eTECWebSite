package login;

import general.ScreenSize;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by andres on 17/05/17.
 * DrApp
 * main.casosClinicos
 */
public class LoginDemoApplication extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage Stage) throws IOException {
    Stage.setTitle("eTECWebSite");

    Scene scene = new Scene(new AnchorPane(), ScreenSize.getWidth(), ScreenSize.getHeight());

    LoginManager loginManager = new LoginManager(scene);
    loginManager.showLoginScreen();

    Stage.setScene(scene);
    Stage.show();
  }
}

