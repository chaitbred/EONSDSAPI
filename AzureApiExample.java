package bin.sdsapi;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AzureApiExample {
    public static void main(String[] args) {
        try {
            // Replace with the actual API endpoint
            String apiUrl = "https://sdsapimgmt.azure-api.net/execute_hardening/";
            URL url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Set any required headers (e.g., authentication headers)

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();

                // Process the API response
                System.out.println("API Response: " + responseCode);
                //System.out.println("API Response: " + response.toString());
            } else {
                System.out.println("HTTP Request Failed with Error Code: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

