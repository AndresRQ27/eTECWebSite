package main;

import connection.NetClientGet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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

    public void cancel() {
        showMainScreen();
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
        NetClientGet.NetClientGet("/productos/");
    }
}
