package com.example.leidong.ldplayer.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.example.leidong.foundation.musicplayer.MusicPlayer;
import com.example.leidong.ldplayer.R;
import com.example.leidong.ldplayer.beans.Music;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/6/28.
 */
public class MusicPlayActivity extends BaseActivity {
    private static final String TAG = MusicPlayActivity.class.getSimpleName();

    @BindView(R.id.wave1)
    ImageView wave1;

    @BindView(R.id.wave2)
    ImageView wave2;

    @BindView(R.id.wave3)
    ImageView wave3;

    @BindView(R.id.wave4)
    ImageView wave4;

    @BindView(R.id.wave5)
    ImageView wave5;

    @BindView(R.id.wave6)
    ImageView wave6;

    @BindView(R.id.wave7)
    ImageView wave7;

    private AnimationSet animationSet1, animationSet2, animationSet3, animationSet4, animationSet5, animationSet6, animationSet7;

    private static int offset = 1000;
    private static final int MSG_WAVE2_ANIMATION = 2;
    private static final int MSG_WAVE3_ANIMATION = 3;
    private static final int MSG_WAVE4_ANIMATION = 4;
    private static final int MSG_WAVE5_ANIMATION = 5;
    private static final int MSG_WAVE6_ANIMATION = 6;
    private static final int MSG_WAVE7_ANIMATION = 7;

    private Music mCurrentMusic = null;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_WAVE2_ANIMATION:
                    wave2.startAnimation(animationSet2);
                    break;
                case MSG_WAVE3_ANIMATION:
                    wave3.startAnimation(animationSet3);
                    break;
                case MSG_WAVE4_ANIMATION:
                    wave4.startAnimation(animationSet4);
                    break;
                case MSG_WAVE5_ANIMATION:
                    wave5.startAnimation(animationSet5);
                    break;
                case MSG_WAVE6_ANIMATION:
                    wave6.startAnimation(animationSet6);
                    break;
                case MSG_WAVE7_ANIMATION:
                    wave7.startAnimation(animationSet7);
                    break;
                default:
                    break;
            }
        }
    };

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
        animationSet1 = initAnimationSet();
        animationSet2 = initAnimationSet();
        animationSet3 = initAnimationSet();
        animationSet4 = initAnimationSet();
        animationSet5 = initAnimationSet();
        animationSet6 = initAnimationSet();
        animationSet7 = initAnimationSet();

        showWaveAnimation();
    }

    private void showWaveAnimation() {
        wave1.startAnimation(animationSet1);
        mHandler.sendEmptyMessageDelayed(MSG_WAVE2_ANIMATION, offset);
        mHandler.sendEmptyMessageDelayed(MSG_WAVE3_ANIMATION, offset * 2);
        mHandler.sendEmptyMessageDelayed(MSG_WAVE4_ANIMATION, offset * 3);
        mHandler.sendEmptyMessageDelayed(MSG_WAVE5_ANIMATION, offset * 4);
        mHandler.sendEmptyMessageDelayed(MSG_WAVE6_ANIMATION, offset * 5);
        mHandler.sendEmptyMessageDelayed(MSG_WAVE7_ANIMATION, offset * 6);
    }

    private AnimationSet initAnimationSet() {
        AnimationSet as = new AnimationSet(true);
        ScaleAnimation sa = new ScaleAnimation(1f, 2.3f, 1f, 2.3f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
        sa.setDuration(offset * 3);
        sa.setRepeatCount(Animation.INFINITE);// 设置循环
        AlphaAnimation aa = new AlphaAnimation(1, 0.1f);
        aa.setDuration(offset * 3);
        aa.setRepeatCount(Animation.INFINITE);//设置循环
        as.addAnimation(sa);
        as.addAnimation(aa);
        return as;
    }

    @Override
    public void doBusiness() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    MusicPlayer.playOnlineSong(MusicPlayActivity.this, mCurrentMusic.getPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        MusicPlayer.stop();
    }
}
