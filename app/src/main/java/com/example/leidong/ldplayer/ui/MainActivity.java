package com.example.leidong.ldplayer.ui;

import android.annotation.SuppressLint;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.leidong.ldplayer.R;
import com.example.leidong.ldplayer.fragments.ChannelFragment;
import com.example.leidong.ldplayer.fragments.MeFragment;
import com.example.leidong.ldplayer.fragments.MusicFragment;
import com.example.leidong.ldplayer.fragments.VideoFragment;

import butterknife.BindView;

/**
 * @author Lei Dong
 * @date 2018/6/14
 * @description 主界面
 */
public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.fl_main_container)
    FrameLayout mFlMainContainer;

    @BindView(R.id.rbt_video)
    RadioButton mRbtVideo;

    @BindView(R.id.rbt_music)
    RadioButton mRbtMusic;

    @BindView(R.id.rbt_channel)
    RadioButton mRbtChannel;

    @BindView(R.id.rbt_me)
    RadioButton mRbtMe;

    @BindView(R.id.rg_button_tag)
    RadioGroup mRgButtonTag;

    private FragmentManager mFragmentManager;

    private FragmentTransaction mFragmentTransaction;

    private VideoFragment mVideoFragment;

    private MusicFragment mMusicFragment;

    private ChannelFragment mChannelFragment;

    private MeFragment mMeFragment;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @SuppressLint("CommitTransaction")
    @Override
    public void initWidgets() {
        mRgButtonTag.check(R.id.rbt_video);

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mVideoFragment = new VideoFragment();
        mFragmentTransaction.replace(R.id.fl_main_container, mVideoFragment);
        mFragmentTransaction.commit();
    }

    @Override
    public void initActions() {
        mRgButtonTag.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mFragmentManager = getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                if (checkedId == R.id.rbt_video) {
                    mVideoFragment = new VideoFragment();
                    mFragmentTransaction.replace(R.id.fl_main_container, mVideoFragment);
                } else if (checkedId == R.id.rbt_music) {
                    mMusicFragment = new MusicFragment();
                    mFragmentTransaction.replace(R.id.fl_main_container, mMusicFragment);
                } else if (checkedId == R.id.rbt_channel) {
                    mChannelFragment = new ChannelFragment();
                    mFragmentTransaction.replace(R.id.fl_main_container, mChannelFragment);
                } else if (checkedId == R.id.rbt_me) {
                    mMeFragment = new MeFragment();
                    mFragmentTransaction.replace(R.id.fl_main_container, mMeFragment);
                } else {
                    mVideoFragment = new VideoFragment();
                    mFragmentTransaction.replace(R.id.fl_main_container, mVideoFragment);
                }
                mFragmentTransaction.commit();
            }
        });
    }

    @Override
    public void doBusiness() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
