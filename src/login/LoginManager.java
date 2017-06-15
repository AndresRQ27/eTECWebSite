package login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import main.MainManager;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Manages control flow for logins */
public class LoginManager {
  public final Scene scene;
  private String password = "password";

  public LoginManager(Scene scene) {
    this.scene = scene;
  }

  /**
   * Callback method invoked to notify that a user has been authenticated.
   * Will show the main application screen.
   */ 
  public void authenticated(String password) {
    if (Objects.equals(password, this.password)){
        new MainManager(this.scene).showMainScreen();
    }
  }

  //Función para abrir ventana
  public void showLoginScreen() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        scene.setRoot((loader.load()));
        LoginController controller = loader.getController();
        controller.initManager(this);

    }  catch (IOException ex) {
        Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

}
