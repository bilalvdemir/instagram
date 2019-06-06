package com.example.bilal.instagram;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alexandra.instagramlogin.R;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PhotoActivity extends AppCompatActivity {

    private Context mContext;
    String url;
    String profile;
    String username;
    int likeCount;
    int commentCount ;
    boolean hasLike ;
    long createdTime ;
    Double ratio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_photo);
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        profile = intent.getStringExtra("profile");
        likeCount = intent.getIntExtra("likeCount",0);
        commentCount = intent.getIntExtra("commentCount",0);
        hasLike = intent.getBooleanExtra("hasLike",false);
        createdTime = new Long(intent.getStringExtra("createdTime"));
        username = intent.getStringExtra("username");
        ratio = intent.getDoubleExtra("ratio",0);

        TextView tvlikeCount = (TextView) findViewById(R.id.likedCount);
        tvlikeCount.setText(likeCount+"");

        TextView tvUsername = (TextView) findViewById(R.id.username);
        tvUsername.setText(username);

        TextView tvCreatedTime = (TextView) findViewById(R.id.createdTime);
        tvCreatedTime.setText(new SimpleDateFormat("dd MM yyyy").format(new Date(createdTime*1000)));

        ImageView imgPhoto = (ImageView) findViewById(R.id.photo);
        Picasso.with(this).load(url).into(imgPhoto);

        ImageView imgUser = (ImageView) findViewById(R.id.profilePic);
        Picasso.with(this).load(profile).into(imgUser);

        imgPhoto.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
        imgPhoto.setScaleType(ImageView.ScaleType.FIT_XY);
        imgPhoto.setAdjustViewBounds(true);
        imgPhoto.setPadding(0, 1, 0, 1);

    }

    public void onClickLogo(View view) {
    }

    public void onClickDiscovery(View view) {
    }

    public void onClickLike(View view) {
    }

    public void onClickProfile(View view) {
    }

    public void onClickSettings(View view) {
    }
}
