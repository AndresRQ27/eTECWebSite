package connection;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by andres on 26/05/17.
 * DrApp
 * connection
 */
@SuppressWarnings("ALL")
public class NetClientPost {

    public static void NetClientPost(String url, String output) {

        try {

            URL realURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) realURL.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "Application/json");

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(output.getBytes());
            outputStream.flush();

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
