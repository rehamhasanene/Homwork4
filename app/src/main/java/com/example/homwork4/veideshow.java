package com.example.homwork4;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

public class veideshow extends AppCompatActivity {
    private PlayerView playerView;
    SimpleExoPlayer player;
    private String videoUrl;
    private boolean playWhenReady = true;
    private int currentWindow = 0;
    private long playPackPosition = 0;
    String uri1="https://firebasestorage.googleapis.com/v0/b/map4-b3cc2.appspot.com/o/%D8%B3%D9%88%D8%B1%D8%A9%20%D8%A7%D9%84%D8%A7%D8%AE%D9%84%D8%A7%D8%B5%20%D9%85%D9%83%D8%AA%D9%88%D8%A8%D8%A9%20_%20%20%D9%85%D8%A7%D9%87%D8%B1%20%D8%A7%D9%84%D9%85%D8%B9%D9%8A%D9%82%D9%84%D9%8A.mp4?alt=media&token=750bf58f-5cf3-4f71-939c-078179dfaee4";
    private String uri2 ="https://firebasestorage.googleapis.com/v0/b/map4-b3cc2.appspot.com/o/%D8%B3%D9%88%D8%B1%D8%A9%20%D8%A7%D9%84%D8%B9%D8%B5%D8%B1%20%D9%85%D9%83%D8%AA%D9%88%D8%A8%D8%A9%20_%20%20%20%D9%85%D8%A7%D9%87%D8%B1%20%D8%A7%D9%84%D9%85%D8%B9%D9%8A%D9%82%D9%84%D9%8A.mp4?alt=media&token=cee31cb8-202e-4bee-a80c-8198962ad70d";
    private String uri3 ="https://firebasestorage.googleapis.com/v0/b/map4-b3cc2.appspot.com/o/%D8%B3%D9%88%D8%B1%D8%A9%20%D8%A7%D9%84%D9%81%D9%84%D9%82%20%D9%85%D9%83%D8%AA%D9%88%D8%A8%D8%A9%20_%20%20%D9%85%D8%A7%D9%87%D8%B1%20%D8%A7%D9%84%D9%85%D8%B9%D9%8A%D9%82%D9%84%D9%8A.mp4?alt=media&token=b71335e1-d285-434c-bdfa-8bb848dc043b";
    private String uri4 ="https://firebasestorage.googleapis.com/v0/b/map4-b3cc2.appspot.com/o/%D8%B3%D9%88%D8%B1%D8%A9%20%D8%A7%D9%84%D9%86%D8%A7%D8%B3%20%D9%85%D9%83%D8%AA%D9%88%D8%A8%D8%A9%20_%20%20%D9%85%D8%A7%D9%87%D8%B1%20%D8%A7%D9%84%D9%85%D8%B9%D9%8A%D9%82%D9%84%D9%8A.mp4?alt=media&token=0e829bf9-c035-40fe-a2d9-02b790933ecb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veideshow);

        playerView = findViewById(R.id.playerView);
        String recUrl = getIntent().getStringExtra("uri");

        if (recUrl.equals(uri1)) {
            videoUrl = uri1;
        } else if (recUrl.equals(uri2)) {
            videoUrl = uri2;
        } else if (recUrl.equals(uri3)){
            videoUrl = uri3;
        }else if (recUrl.equals(uri4)){
            videoUrl = uri4;
        }

    }
    private void releaseVideo() {
        if (player != null) {
            playWhenReady = player.getPlayWhenReady();
            playPackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            player.release();
            player = null;

        }
    }

    private void initVideo() {
        player = ExoPlayerFactory.newSimpleInstance(this);
        playerView.setPlayer(player);
        Uri uri = Uri.parse(videoUrl);
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, "exoplayer_codelab");
        Log.e("uriiiiiiiiiiiiiiiiiiiii",videoUrl);
        Log.e("cureent",currentWindow +"");
        MediaSource mediaSource = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
        player.setPlayWhenReady(playWhenReady);
        player.seekTo(currentWindow, playPackPosition);
        player.prepare(mediaSource, false, false);

    }
    @Override
    protected void onStart() {
        super.onStart();
        initVideo();
    }
    @Override
    protected void onPause() {
        super.onPause();
        releaseVideo();
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseVideo();
    }
}