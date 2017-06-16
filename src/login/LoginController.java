package login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/** Controls the login screen */
public class LoginController {
    @FXML
    private TextField password;
    @FXML
    private Button loginButton;
    @FXML
    private CheckBox admin;

    public void initialize() {
    }

    public void initManager(final LoginManager loginManager) {

        admin.setOnAction(event -> {
            if (!admin.isSelected()) {
                password.setDisable(true);
            } else if (admin.isSelected()) {
                password.setDisable(false);
            }
        });

        loginButton.setOnAction((ActionEvent event) -> {
            if (!password.getText().isEmpty()) {
                loginManager.authenticated(password.getText());

            }
        });
    }

    @FXML
    public void onEnter(){
        loginButton.fire();
    }
}
