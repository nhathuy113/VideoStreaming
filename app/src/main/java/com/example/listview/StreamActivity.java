package com.example.listview;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class StreamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);

        // extract
        String savedExtra = getIntent().getStringExtra("bleh");

        // debug
        TextView myText = (TextView) findViewById(R.id.textID);
        myText.setText(savedExtra);

        // set video path
        String video_url = "rtsp://r5---sn-npoeen7r.googlevideo.com/Cj0LENy73wIaNAkLtUwKlqNOUxMYDSANFC0nColcMOCoAUIASARgkIrYzOPrr61bigELRXY3TDJSUHBPRjAM/C7859A1EDF3C12D192FA5F2B15FCC221137C2F49.8C874E07C4F1025C94BF1C9674B7517F3A583B9E/yt6/1/video.3gp";

        VideoView videoView = findViewById(R.id.video_view);
        //String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(video_url);
        videoView.setVideoURI(uri);
        videoView.start();

        // launch video
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}
