package com.example.homwork4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button1, button2, button3, button4;
    private String u1 ="https://firebasestorage.googleapis.com/v0/b/map4-b3cc2.appspot.com/o/%D8%B3%D9%88%D8%B1%D8%A9%20%D8%A7%D9%84%D8%A7%D8%AE%D9%84%D8%A7%D8%B5%20%D9%85%D9%83%D8%AA%D9%88%D8%A8%D8%A9%20_%20%20%D9%85%D8%A7%D9%87%D8%B1%20%D8%A7%D9%84%D9%85%D8%B9%D9%8A%D9%82%D9%84%D9%8A.mp4?alt=media&token=750bf58f-5cf3-4f71-939c-078179dfaee4";
    private String u2 ="https://firebasestorage.googleapis.com/v0/b/map4-b3cc2.appspot.com/o/%D8%B3%D9%88%D8%B1%D8%A9%20%D8%A7%D9%84%D8%B9%D8%B5%D8%B1%20%D9%85%D9%83%D8%AA%D9%88%D8%A8%D8%A9%20_%20%20%20%D9%85%D8%A7%D9%87%D8%B1%20%D8%A7%D9%84%D9%85%D8%B9%D9%8A%D9%82%D9%84%D9%8A.mp4?alt=media&token=cee31cb8-202e-4bee-a80c-8198962ad70d";
    private String u3 ="https://firebasestorage.googleapis.com/v0/b/map4-b3cc2.appspot.com/o/%D8%B3%D9%88%D8%B1%D8%A9%20%D8%A7%D9%84%D9%81%D9%84%D9%82%20%D9%85%D9%83%D8%AA%D9%88%D8%A8%D8%A9%20_%20%20%D9%85%D8%A7%D9%87%D8%B1%20%D8%A7%D9%84%D9%85%D8%B9%D9%8A%D9%82%D9%84%D9%8A.mp4?alt=media&token=b71335e1-d285-434c-bdfa-8bb848dc043b";
    private String u4 ="https://firebasestorage.googleapis.com/v0/b/map4-b3cc2.appspot.com/o/%D8%B3%D9%88%D8%B1%D8%A9%20%D8%A7%D9%84%D9%86%D8%A7%D8%B3%20%D9%85%D9%83%D8%AA%D9%88%D8%A8%D8%A9%20_%20%20%D9%85%D8%A7%D9%87%D8%B1%20%D8%A7%D9%84%D9%85%D8%B9%D9%8A%D9%82%D9%84%D9%8A.mp4?alt=media&token=0e829bf9-c035-40fe-a2d9-02b790933ecb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.butFirst);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.butSecand);
        button2.setOnClickListener(this);

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);

        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.butFirst:
                GoToShowVideo(u1);
                break;
            case R.id.butSecand:
                //Stop MediaPlayer
                GoToShowVideo(u2);
                break;
            case R.id.button3:
                GoToShowVideo(u3);
                break;
            case R.id.button4:
                GoToShowVideo(u4);

                break;

        }
    }

    private void GoToShowVideo(String uri) {
        Intent intent = new Intent(this, veideshow.class);
        intent.putExtra("uri", uri);
        startActivity(intent);
    }
}