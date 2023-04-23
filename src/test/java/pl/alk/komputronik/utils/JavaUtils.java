package pl.alk.komputronik.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import org.json.JSONException;
import org.json.JSONObject;

public class JavaUtils {

    public static String getCurrentIP(){
        String ipAddress = "";
        try {
            // Utworzenie połączenia z webservisem ipapi.co i wykonanie zapytania GET
            URL url = new URL("https://ipapi.co/ip/");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Pobranie odpowiedzi z serwera w postaci łańcucha znaków
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parsowanie odpowiedzi jako obiekt JSON i pobranie wartości adresu IP
            JSONObject jsonResponse = new JSONObject(response.toString());
            ipAddress = jsonResponse.getString("ip");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ipAddress;
    }

    public static String[] getLatLongFromIP(String ip) throws IOException {
        String location = "";
        try {
            // Utworzenie połączenia z webservisem ipapi.com i wykonanie zapytania GET z adresem IP jako parametrem
            URL url = new URL("https://ipapi.co/" + ip + "/json/");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Pobranie odpowiedzi z serwera i zdekodowanie jej jako obiekt JSON
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONObject jsonResponse = new JSONObject(response.toString());

            // Pobranie danych o lokalizacji z obiektu JSON i zwrócenie ich w postaci Stringa
            BigDecimal latitude = jsonResponse.getBigDecimal("latitude");
            BigDecimal longitude = jsonResponse.getBigDecimal("longitude");
            location = "Latitude: " + latitude + ", Longitude: " + longitude;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[]{location};
    }

    public static void main(String[] args) throws IOException {
        String ip = getCurrentIP().toString();
        System.out.println(ip);
        String location = Arrays.toString(getLatLongFromIP(ip));
        System.out.println(location);
    }

}
