package connection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by andres on 27/05/17.
 * DrApp
 * connection
 */
public class NetClientDelete {

    public static void NetClientDelete(String url) {

        try {

            URL realURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) realURL.openConnection();
            connection.setRequestMethod("DELETE");

            if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + connection.getResponseCode());
            }

            connection.disconnect();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
