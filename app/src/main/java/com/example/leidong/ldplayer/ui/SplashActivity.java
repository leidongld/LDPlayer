package com.example.leidong.ldplayer.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.leidong.ldplayer.R;

import butterknife.BindView;

/**
 * @author Lei Dong
 * @date 2018/6/14
 * @description
 */
public class SplashActivity extends BaseActivity {
    private static final String TAG = SplashActivity.class.getName();

    @BindView(R.id.tv_appname)
    TextView mTvAppname;

    @BindView(R.id.pb_loading)
    ProgressBar mPbLoading;

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public View bindView() {
        return null;
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void doBusiness(Context mContext) {

    }
}
