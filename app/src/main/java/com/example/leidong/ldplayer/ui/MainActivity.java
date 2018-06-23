package com.example.leidong.ldplayer.ui;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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

    @BindView(R.id.tb_main)
    Toolbar mTbMain;

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
        configToolBar();

        mRgButtonTag.check(R.id.rbt_video);

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mVideoFragment = new VideoFragment();
        mFragmentTransaction.replace(R.id.fl_main_container, mVideoFragment);
        mFragmentTransaction.commit();

    }

    /**
     * 配置ToolBar
     *
     */
    private void configToolBar() {
        setSupportActionBar(mTbMain);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mTbMain.setNavigationIcon(R.drawable.app_logo_small);

        mTbMain.setOnMenuItemClickListener(onMenuItemClick);
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()) {
                case R.id.action_edit:
                    startActivity(MainActivity.this, EditActivity.class);
                    break;
                case R.id.action_share:
                    startActivity(MainActivity.this, ShareActivity.class);
                    break;
                case R.id.action_settings:
                    startActivity(MainActivity.this, SettingsActivity.class);
                    break;
                default:
                    break;
            }
            return true;
        }
    };

    /**
     * 界面跳转
     *  @param fromActivity
     * @param toActivityClass
     */
    private void startActivity(Activity fromActivity, Class<?> toActivityClass) {
        Intent intent = new Intent(fromActivity, toActivityClass);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.base_toolbar_menu, menu);
        return true;
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
        int state = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (state != PackageManager.PERMISSION_GRANTED) {
            startSettings();
        }
    }


    private void startSettings() {
        Intent intent = new Intent(Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
