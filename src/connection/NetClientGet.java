package connection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SuppressWarnings("ALL")
public class NetClientGet {


    public static JSONArray NetClientGet(String url) throws ParseException {

        JSONArray jsonArray = new JSONArray();

        try {

            URL realURl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) realURl.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "Application/json");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String output = bufferedReader.readLine();

            try {

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(output);
                //noinspection unchecked
                jsonArray.add(jsonObject);

            } catch (Exception e) {
                return NetClientGetArray(connection, output);
            }

            connection.disconnect();
            return jsonArray;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonArray;
    }

    private static JSONArray NetClientGetArray(HttpURLConnection connection ,String jsonString) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(jsonString);
        connection.disconnect();
        return jsonArray;
    }
}
