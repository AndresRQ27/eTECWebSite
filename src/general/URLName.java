package general;

/**
 * Created by andres on 26/05/17.
 * DrApp
 * general
 */
public class URLName {
    private static String ourInstance = "http://192.168.43.48:9080/eTECServer";

    public static String getInstance() {
        return ourInstance;
    }

    private URLName() {
    }
}
