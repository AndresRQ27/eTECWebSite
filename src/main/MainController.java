package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import org.json.simple.parser.ParseException;

/**
 * Created by andres on 20/05/17.
 * DrApp
 * main
 */
public class MainController {

    @FXML
    CheckBox transit;
    @FXML
    CheckBox received;
    @FXML
    CheckBox delivered;
    @FXML
    TextField packageId;
    @FXML
    Button save;
    @FXML
    Button search;

    public void initialize() {}

    public void initManager(final MainManager mainManager) {

        search.setOnAction(event -> {
            try {
                mainManager.search(this, packageId.getText());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });

        delivered.setOnAction(event -> {
            received.setSelected(false);
            transit.setSelected(false);
        });


    }

    @FXML
    public void onEnter(ActionEvent ae){
        search.fire();
    }

    public void setStatus(boolean transitStatus, boolean recievedStatus, boolean deliveredStatus){

        delivered.setDisable(false);
        delivered.setSelected(deliveredStatus);
        transit.setSelected(transitStatus);
        received.setSelected(recievedStatus);
    }
}
