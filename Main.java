package com.company;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class Main {
    public static void main(String[] args) {
        LATLON info = new LATLON();
        info.getLATLON();
    }

}
