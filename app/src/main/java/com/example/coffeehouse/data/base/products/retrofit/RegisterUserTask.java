package com.example.coffeehouse.data.base.products.retrofit;
import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterUserTask extends AsyncTask<String, Void, Boolean> {

    @Override
    protected Boolean doInBackground(String... params) {
        String username = params[0];
        String email = params[1];
        String phoneNumber = params[2];
        String address = params[3];
        String password = params[4];

        try {
            URL url = new URL("http://127.0.0.1:8080/api/users/auth/register");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String requestBody = "{\"username\":\"" + username + "\","
                    + "\"email\":\"" + email + "\","
                    + "\"phone_number\":\"" + phoneNumber + "\","
                    + "\"address\":\"" + address + "\","
                    + "\"password\":\"" + password + "\"}";

            conn.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(requestBody);
            wr.flush();
            wr.close();

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
