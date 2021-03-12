package com.example.smartbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

public class VR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        setContentView(R.layout.activity_v_r);

        initView();
    }

    @Override
    protected void onResume () {

        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();
    }

    //对直播进行初始化
    private void initView() {
        String url1 = "http://ivi.bupt.edu.cn/hls/cctv5phd.m3u8";
        String url2 = "http://ivi.bupt.edu.cn/hls/cctv5phd.m3u8";
        VideoView videoView1 = findViewById(R.id.vr_left);
        videoView1.setVideoPath(url1);
        videoView1.requestFocus();


        VideoView videoView2 = findViewById(R.id.vr_right);
        videoView2.setVideoPath(url2);
        videoView2.requestFocus();
        videoView1.start();
        videoView2.start();

        videoView2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0f, 0f);
            }
        });

    }
}

