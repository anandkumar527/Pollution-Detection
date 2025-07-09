package com.company;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;


public class LATLON {
    Object lat;
    Object lon;
    Scanner sc = new Scanner(System.in); // To get city name.


    void getCoordinates() {
        try {
            String city = "";
            String state = "";
            System.out.println("Enter the city name to fetch the Pollution Meter:");
            city = sc.nextLine();
            System.out.println("Enter the state name to fetch the Pollution Meter:");
            state = sc.nextLine();
            URL url = new URL("https://api.thingspeak.com/channels/1906853/feeds.json?results=1");
            System.out.println(url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            int response = con.getResponseCode();
//            System.out.println(response);

            if (response != 200) {
                System.out.println(response);
            } else {
                String input = "";
                Scanner sc1 = new Scanner(url.openStream());

                while (sc1.hasNext()) {
                    input += sc1.nextLine();
                    System.out.println(input);
                }
                sc1.close();

                JSONParser par = new JSONParser();
                JSONArray data = (JSONArray) par.parse(input);
                JSONObject raw = (JSONObject) data.get(0);
                lat = raw.get("lat");
                lon = raw.get("lon");


            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void getWeatherInfo() {
        getCoordinates();
        try {
            URL url = new URL("https://api.thingspeak.com/channels/1906853/feeds.json?results=1");
            System.out.println(url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            int response = con.getResponseCode();
//            System.out.println(response);

            if (response != 200) {
                System.out.println(response);
            } else {
                String input = "";
                Scanner sc1 = new Scanner(url.openStream());

                while (sc1.hasNext()) {
                    input += sc1.nextLine();
                    System.out.println(input);
                }
                sc1.close();

                JSONParser par = new JSONParser();
                JSONObject data = (JSONObject) par.parse(input);
                JSONObject data2 = (JSONObject) data.get("main");
                Object temp = data2.get("temp");
                Object humidity = data2.get("humidity");
                System.out.println("Temperature = " + data2.get("temp"));
                System.out.println("Humidity = " + data2.get("humidity"));


            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getLATLON() {
    }
}