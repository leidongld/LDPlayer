package com.example.leidong.ldplayer.ui;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.dl7.player.media.IjkPlayerView;
import com.example.leidong.ldplayer.R;

/**
 * Created by Lei Dong on 2018/7/1.
 */
public class TestIjkPlayerActivity extends AppCompatActivity{
    private IjkPlayerView mPlayerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ijkplayer_test);

        initWidgets();

        initActions();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPlayerView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        mPlayerView.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayerView.onDestroy();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mPlayerView.configurationChanged(newConfig);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mPlayerView.handleVolumeKey(keyCode)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void onBackPressed() {
        if (mPlayerView.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    private void initActions() {
        mPlayerView = (IjkPlayerView) findViewById(R.id.player_view);
        Uri mUri = Uri.parse("http://covertness.qiniudn" +
                ".com/android_zaixianyingyinbofangqi_test_baseline.mp4");

        mPlayerView.init()
                .setVideoPath(mUri)
                .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH)
                .enableDanmaku()
                .start();
    }

    private void initWidgets() {


    }
}
