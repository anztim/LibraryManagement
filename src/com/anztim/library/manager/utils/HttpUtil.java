package com.anztim.library.manager.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author anztim
 */
public class HttpUtil {
    public static InputStream getInputStream(String urlStr) {
        HttpURLConnection connection;
        InputStream is = null;
        try {
            URL url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int statusCode = connection.getResponseCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                is = connection.getInputStream();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return is;
    }
}
