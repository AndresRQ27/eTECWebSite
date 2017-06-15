package messagePrompt;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


/**
 * Created by andres on 26/05/17.
 * DrApp
 * messagePrompt
 */
public class VentanaAvisoController {
    @FXML private Button entendido;
    @FXML private Label mensaje;

    public void initialize() {
    }

    public void initManager(VentanaAvisoManager avisoManager, String aviso){
        mensaje.setText(aviso);

        entendido.setOnAction(event -> closeButtonAction());
    }

    @FXML
    private void closeButtonAction(){
        // get a handle to the stage
        Stage stage = (Stage) entendido.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
