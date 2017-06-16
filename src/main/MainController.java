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
class MainController {

    private String id;

    @FXML
    private
    CheckBox transit;
    @FXML
    private
    CheckBox received;
    @FXML
    private
    CheckBox delivered;
    @FXML
    private
    TextField packageId;
    @FXML
    private
    Button save;
    @FXML
    private
    Button search;

    public void initialize() {}

    public void initManager(final MainManager mainManager) {

        search.setOnAction(event -> {
            try {
                id = packageId.getText();
                mainManager.search(this, packageId.getText());
                save.setDisable(false);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });

        delivered.setOnAction(event -> {
            received.setSelected(false);
            transit.setSelected(false);
        });

        save.setOnAction(event -> {
            if (!delivered.isSelected()){
                try {
                    throw new IllegalStateException("For saving, you must change the state and it can't be null");
                } catch (Exception e){
                    e.printStackTrace();
                }
            } else {
                save.setDisable(true);
                mainManager.save(id);
            }
        });
    }

    @FXML
    public void onEnter(ActionEvent ae){
        search.fire();
    }

    public void setStatus(boolean transitStatus, boolean receivedStatus, boolean deliveredStatus){

        delivered.setDisable(false);
        delivered.setSelected(deliveredStatus);
        transit.setSelected(transitStatus);
        received.setSelected(receivedStatus);
    }
}
