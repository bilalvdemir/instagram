package com.example.bilal.instagram;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alexandra.instagramlogin.R;
import com.example.bilal.instagram.client.AsyncRest.RequestInstagramAPI;
import com.example.bilal.instagram.model.media.Data;
import com.example.bilal.instagram.model.self.UserSelf;
import com.example.bilal.instagram.client.ApiClient;
import com.example.bilal.instagram.client.RestInterface;
import com.example.bilal.instagram.configs.AuthenticationDialog;
import com.example.bilal.instagram.configs.AuthenticationListener;
import com.example.bilal.instagram.model.media.Image;
import com.example.bilal.instagram.model.media.MediaResponse;
import com.example.bilal.instagram.utils.AppPreferences;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements AuthenticationListener {

    private String token = null;
    private AppPreferences appPreferences = null;
    private AuthenticationDialog authenticationDialog = null;
    private TableLayout info = null;
    public ArrayList<Data> imageIDs = new ArrayList<>();
    RestInterface restInterface;
    Intent intent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this,PhotoActivity.class);
        info = findViewById(R.id.info);
        appPreferences = new AppPreferences(this);
        restInterface= ApiClient.getClient().create(RestInterface.class);
        token = appPreferences.getString(AppPreferences.TOKEN);
        if (token != null) {
            getUserInfoByAccessToken(token);
        }
    }

    public void login() {
        info.setVisibility(View.VISIBLE);
        ImageView pic = findViewById(R.id.pic);
        Picasso.with(this).load(appPreferences.getString(AppPreferences.PROFILE_PIC)).into(pic);

        TextView name = findViewById(R.id.name);
        name.setText(appPreferences.getString(AppPreferences.USER_NAME));

        TextView response = findViewById(R.id.response);
        //response.setText(appPreferences.getString(AppPreferences.ALL_RESPONSE));

        TextView bio = findViewById(R.id.bio);
        bio.setText(appPreferences.getString(AppPreferences.BIO));

        TextView follow = findViewById(R.id.follow);
        follow.setText(appPreferences.getString(AppPreferences.FOLLOW));

        TextView follower = findViewById(R.id.follower);
        follower.setText(appPreferences.getString(AppPreferences.FOLLOWERS));

        TextView media = findViewById(R.id.postcounter);
        media.setText(appPreferences.getString(AppPreferences.MEDIA_COUNT));
    }

    public void recentMediaCollected (){
        GridView androidGridView = (GridView) findViewById(R.id.gridView);
        androidGridView.setAdapter(new ImageAdapterGridView(this));
    }

    public void logout() {
        token = null;
        info.setVisibility(View.GONE);
        appPreferences.clear();
    }

    @Override
    public void onTokenReceived(String auth_token) {
        if (auth_token == null)
            return;
        appPreferences.putString(AppPreferences.TOKEN, auth_token);
        token = auth_token;
        getUserInfoByAccessToken(token);
    }

    public void onClickLogout(View view) {
        if(token!=null)
        {
            logout();
        }
        else {
            authenticationDialog = new AuthenticationDialog(this, this);
            authenticationDialog.setCancelable(true);
            authenticationDialog.show();
        }
    }

    public void onClickLike(View view) {
        Toast.makeText(getApplicationContext(), "Like Cliecked", Toast.LENGTH_SHORT).show();
    }

    public void onClickSettings(View view) {
        Toast.makeText(getApplicationContext(), "Settings Cliecked", Toast.LENGTH_SHORT).show();
    }

    public void onClickProfile(View view) {
        Toast.makeText(getApplicationContext(), "Profile Cliecked", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void onClickDiscovery(View view) {
        Toast.makeText(getApplicationContext(), "Discovery Cliecked", Toast.LENGTH_SHORT).show();
    }

    public void onClickLogo(View view) {
        Toast.makeText(getApplicationContext(), "Logo Cliecked", Toast.LENGTH_SHORT).show();
    }

    private void getUserInfoByAccessToken(String token) {
        Call<UserSelf> call= restInterface.getUserInfoSelf(token);
        call.enqueue(new Callback<UserSelf>() {
            @Override
            public void onResponse(Call<UserSelf> call, Response<UserSelf> response) {
                UserSelf result = response.body();
                appPreferences.putString(AppPreferences.USER_NAME,result.getData().getUsername());
                appPreferences.putString(AppPreferences.PROFILE_PIC,result.getData().getProfilePicture());
                appPreferences.putString(AppPreferences.BIO,result.getData().getBio());
                appPreferences.putString(AppPreferences.FOLLOW,result.getData().getCounts().getFollows().toString());
                appPreferences.putString(AppPreferences.FOLLOWERS,result.getData().getCounts().getFollowedBy().toString());
                appPreferences.putString(AppPreferences.MEDIA_COUNT,result.getData().getCounts().getMedia().toString());
                login();
            }
            @Override
            public void onFailure(Call<UserSelf> call, Throwable t) {
            }
        });

        Call<MediaResponse> callMedia= restInterface.getMediaRecent(token);
        callMedia.enqueue(new Callback<MediaResponse>() {
            @Override
            public void onResponse(Call<MediaResponse> call, Response<MediaResponse> response) {
                MediaResponse result = response.body();
                if(result.getData().size()>0){
                    imageIDs = result.getData();
                    recentMediaCollected();
                }
            }
            @Override
            public void onFailure(Call<MediaResponse> call, Throwable t) {
            }
        });
     // new RequestInstagramAPI(appPreferences, token,this).execute();
    }

    private class ImageAdapterGridView extends BaseAdapter {
        private Context mContext;

        public ImageAdapterGridView(Context c) {
            mContext = c;
        }

        public int getCount() {
            return imageIDs.size();
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView imageView = null;
           // if (convertView == null) {
                final Data data = imageIDs.get(position);
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.getLayoutParams().height = imageView.getLayoutParams().width;
                imageView.setMinimumHeight(imageView.getLayoutParams().width);
                imageView.setAdjustViewBounds(true);
                imageView.setPadding(1, 1, 1, 1);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("url",data.getImages().getStandardResolution().getUrl());
                        intent.putExtra("profile",data.getUser().getProfilePicture());
                        intent.putExtra("likeCount",data.getLikes().getCount());
                        intent.putExtra("commentCount",data.getComments().getCount());
                        intent.putExtra("hasLike",data.getUserHasLiked());
                        intent.putExtra("createdTime",data.getCreatedTime());
                        intent.putExtra("username",data.getUser().getUsername());
                        intent.putExtra("ratio",data.getImages().getStandardResolution().getHeight()/data.getImages().getStandardResolution().getWidth());

                        startActivity(intent);
                    }
                });
            //} else { imageView = (ImageView) convertView; }
            Picasso.with(mContext).load(imageIDs.get(position).getImages().getThumbnail().getUrl()).into(imageView);
            return imageView;
        }
    }
}
