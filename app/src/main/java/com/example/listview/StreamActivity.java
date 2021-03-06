package com.example.listview;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class StreamActivity extends AppCompatActivity {

    String[] streamArray = {
            "http://live.cdn.mobifonetv.vn/motv/myhtv1_hls.smil/chunklist_b1200000.m3u8",
            "http://live.cdn.mobifonetv.vn/motv/myhtv2_hls.smil/chunklist_b1200000.m3u8",
            "http://live.cdn.mobifonetv.vn/motv/myhtv3_hls.smil/chunklist_b1200000.m3u8",
            "http://cdn3.vtcplay.vn:1935/VTC/smil:VinhLong1HD.smil/playlist.m3u8",
            "http://cdn3.vtcplay.vn:1935/VTC/smil:VinhLong2HD.smil/playlist.m3u8"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);

        // extract
        String savedExtra1 = getIntent().getStringExtra("bleh1");
        String savedExtra2 = getIntent().getStringExtra("bleh2");

        // debug
        TextView myText = (TextView) findViewById(R.id.textID);
        myText.setText(savedExtra1);

        // set video path
        String video_url = streamArray[Integer.parseInt(savedExtra2)];

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
