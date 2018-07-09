package com.example.leidong.ldplayer.ui;

import android.content.Intent;
import android.os.Bundle;

import com.example.leidong.ldplayer.R;
import com.example.leidong.ldplayer.beans.Music;

import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/6/28.
 */
public class MusicPlayActivity extends BaseActivity {
    private static final String TAG = MusicPlayActivity.class.getSimpleName();

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
}
