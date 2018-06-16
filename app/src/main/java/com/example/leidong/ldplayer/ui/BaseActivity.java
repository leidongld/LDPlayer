package com.example.leidong.ldplayer.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/6/16.
 */
abstract class BaseActivity extends AppCompatActivity {

    private boolean isFullScreen = true;

    private boolean isStatusBar = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initConfigs();
        setContentView(bindLayout());
        ButterKnife.bind(this);

        initWidgets();

        initActions();

        doBusiness();
    }

    private void initConfigs() {
        if (isFullScreen) {
            supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        if (isStatusBar) {
            steepStatusBar();
        }
    }

    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    protected abstract int bindLayout();

    public abstract void initWidgets();

    public abstract void initActions();

    public abstract void doBusiness();
}
