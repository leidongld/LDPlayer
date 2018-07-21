package com.example.leidong.ldplayer.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.dl7.player.media.IjkPlayerView;
import com.example.leidong.ldplayer.R;
import com.example.leidong.ldplayer.beans.Video;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/6/28.
 */
public class VideoPlayActivity extends BaseActivity {
    private static final String TAG = VideoPlayActivity.class.getSimpleName();

    @BindView(R.id.playerview)
    IjkPlayerView mPlayerView;

    private Video mCurrentVideo = null;

    @Override
    protected int bindLayout() {
        return R.layout.activity_video_play;
    }

    @Override
    public void initWidgets() {
        obtainCurrentVideo();
    }

    /**
     * 获取当前的视频
     */
    private void obtainCurrentVideo() {
        Intent intent = getIntent();
        mCurrentVideo = (Video) intent.getSerializableExtra("currentVideo");
    }

    @Override
    public void initActions() {

    }

    @Override
    public void doBusiness() {
        String videoPath = mCurrentVideo.getPath();
        if (videoPath != null && videoPath.length() != 0) {
            Uri uri = Uri.parse(mCurrentVideo.getPath());
            mPlayerView
                    .init()
                    .setVideoPath(uri)
                    .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH)
                    .enableDanmaku()
                    .start();
        } else {
            Toast.makeText(this, "该视频地址失效！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
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
}
