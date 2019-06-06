package com.example.bilal.instagram.client.AsyncRest;

import android.os.AsyncTask;
import android.util.Log;

import com.example.bilal.instagram.client.RestInterface;
import com.example.bilal.instagram.MainActivity;
import com.example.bilal.instagram.utils.AppPreferences;
import com.example.bilal.instagram.utils.Utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class RequestInstagramAPI extends AsyncTask<Void, String, String> {

    private AppPreferences appPreferences;
    private String token;
    MainActivity mainActivity;
    RestInterface restInterface;


    public RequestInstagramAPI(AppPreferences appPreferences, String token, MainActivity mainActivity) {
        this.appPreferences = appPreferences;
        this.token = token;
        this.mainActivity = mainActivity;

    }

    @Override
    protected String doInBackground(Void... params) {


        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(Utils.GET_USER_INFO_URL + token);
        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();
            return EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        if (response != null) {
            try {
                JSONObject jsonObject = new JSONObject(response);
                Log.e("response", "--------------"+jsonObject.toString());
                JSONObject jsonData = jsonObject.getJSONObject("data");
                if (jsonData.has("id")) {
                    //сохранение данных пользователя
                    //appPreferences.putString(AppPreferences.USER_ID, jsonData.getString("id"));
                    appPreferences.putString(AppPreferences.USER_NAME, jsonData.getString("username"));
                    appPreferences.putString(AppPreferences.PROFILE_PIC, jsonData.getString("profile_picture"));
                    appPreferences.putString(AppPreferences.BIO, jsonData.getString("bio"));
                    appPreferences.putString(AppPreferences.FOLLOW,jsonData.getJSONObject("counts").getString("follows"));
                    appPreferences.putString(AppPreferences.FOLLOWERS, jsonData.getJSONObject("counts").getString("followed_by"));
                    appPreferences.putString(AppPreferences.MEDIA_COUNT, jsonData.getJSONObject("counts").getString("media"));
                    //appPreferences.putString(AppPreferences.ALL_RESPONSE, jsonObject.toString());
                    //TODO: сохранить еще данные
                    //login(); //---------------------------------cannnot did
                    mainActivity.login();

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else {
            Log.e("response", "-------------- Err: response is null");
        }
    }
}