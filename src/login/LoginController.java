package login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/** Controls the login screen */
public class LoginController {
  @FXML private TextField password;
  @FXML private Button loginButton;
  @FXML private CheckBox admin;
  
  public void initialize() {}
  
  public void initManager(final LoginManager loginManager) {

      loginButton.setOnAction(event -> {
          if (!admin.isSelected()){
            password.setDisable(true);
          } else if (!password.getText().isEmpty()){
              loginManager.authenticated(password.getText());
          } else if (admin.isSelected()){
              password.setDisable(false);
          }
      });
  }
}
