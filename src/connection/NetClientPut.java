package connection;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by andres on 27/05/17.
 * DrApp
 * connection
 */
public class NetClientPut {

    public static void NetClientPut(String url, String output) {

        try {

            URL realURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) realURL.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("PUT");
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
