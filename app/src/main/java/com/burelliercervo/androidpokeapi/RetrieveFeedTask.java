package com.burelliercervo.androidpokeapi;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.R.attr.data;

/**
 * Created by iem on 18/10/2017.
 */

class RetrieveFeedTask extends AsyncTask<String, Void, String> {
public String test;

    protected String doInBackground(String... urls) {
        try {
            URL url = new URL(urls[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            }
            finally{
                urlConnection.disconnect();
            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }
    }

    protected void onPostExecute(String response) {
        if(response == null) {
            response = "THERE WAS AN ERROR";
        }
        Log.i("INFO", response);
        try {

            /*JSONObject jsonObject = new JSONObject(url1);

            String response = jsonObject.getString("response");
            tvApi.setText(response);*/

            JSONObject json= (JSONObject) new JSONTokener(response).nextValue();
            JSONObject json2 = json.getJSONObject("results");
            test = (String) json2.get("name");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        //responseView.setText(response);
    }
}