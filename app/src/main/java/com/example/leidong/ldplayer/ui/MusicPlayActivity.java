package com.example.leidong.ldplayer.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;

import com.dl7.player.media.IjkPlayerView;
import com.example.leidong.ldplayer.R;
import com.example.leidong.ldplayer.beans.Music;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/6/28.
 */
public class MusicPlayActivity extends BaseActivity {
    private static final String TAG = MusicPlayActivity.class.getSimpleName();

    @BindView(R.id.playerview)
    IjkPlayerView mPlayerView;

    private Music mCurrentMusic = null;

    @Override
    protected int bindLayout() {
        return R.layout.activity_music_play;
    }

    @Override
    public void initWidgets() {
        obtainCurrentMusic();
    }

    /**
     * 得到当前的音乐
     */
    private void obtainCurrentMusic() {
        Intent intent = getIntent();
        mCurrentMusic = (Music) intent.getSerializableExtra("currentMusic");
    }

    @Override
    public void initActions() {
        String musicPath = mCurrentMusic.getPath();
        Uri mUri = Uri.parse(musicPath);

        mPlayerView.init()
                .setVideoPath(mUri)
                .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH)
                .enableDanmaku()
                .start();
    }

    @Override
    public void doBusiness() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
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
        return mPlayerView.handleVolumeKey(keyCode) || super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        if (mPlayerView.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }
}
