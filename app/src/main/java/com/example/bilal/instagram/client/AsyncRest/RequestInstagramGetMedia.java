package com.example.bilal.instagram.client.AsyncRest;

import android.os.AsyncTask;
import android.util.Log;

import com.example.bilal.instagram.MainActivity;
import com.example.bilal.instagram.model.media.MediaResponse;
import com.example.bilal.instagram.utils.AppPreferences;
import com.example.bilal.instagram.utils.Utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class RequestInstagramGetMedia extends AsyncTask<Void, String, String> {

    private AppPreferences appPreferences;
    private String token;
    MainActivity mainActivity;

    public RequestInstagramGetMedia(AppPreferences appPreferences, String token, MainActivity mainActivity) {
        this.appPreferences = appPreferences;
        this.token = token;
        this.mainActivity = mainActivity;
        Log.e("TOKEN","-------------tokn----"+token);
    }

    @Override
    protected String doInBackground(Void... params) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(Utils.GET_USER_RECENT_MEDIA_URL + token);
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
                //Log.e("response", "----------////----"+jsonObject.toString());
                JSONArray jsonData = jsonObject.getJSONArray("data");
                MediaResponse s;
                if (jsonData.length()>0) {
                    ArrayList<String> imageUrlList = new ArrayList<>();
                    for (int i=0; i < jsonData.length(); i++) {
                        imageUrlList.add(jsonData.getJSONObject(i).getJSONObject("images").getJSONObject("thumbnail").getString("url").replace("\\/","/"));
                    }
                    Log.e("response", "----------*****----"+imageUrlList.toString());
                    //mainActivity.imageIDs = imageUrlList;
                    //hata verdigi icin kapattim
                    mainActivity.recentMediaCollected();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Log.e("response", "-------------- Err: response is null");
        }
    }
}