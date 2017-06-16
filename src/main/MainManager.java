package main;

import connection.NetClientGet;
import connection.NetClientPut;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by andres on 21/05/17.
 * eTECWebSite
 * main
 */
public class MainManager {
    private final Scene scene;

    public MainManager(Scene scene) {
        this.scene = scene;
    }

    public void showMainScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
            scene.setRoot((loader.load()));
            MainController controller = loader.getController();
            controller.initManager(this);
        }  catch (IOException ex) {
            Logger.getLogger(MainManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void search(MainController mainController, String id) throws ParseException {

        JSONArray jsonArray;

        jsonArray = NetClientGet.NetClientGet("/productos/" + id);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        String status = (String) jsonObject.get("estado");

        switch (status) {
            case "En tránsito":
                mainController.setStatus(true, false, false);
            case "Recibido":
                mainController.setStatus(false, true, false);
            case "Entregado":
                mainController.setStatus(false, false, true);
        }
    }

    public void save(String id){
        NetClientPut.NetClientPut("/productos/" + id, "{\"Estado\":\"Entregado\"}");
    }
}
