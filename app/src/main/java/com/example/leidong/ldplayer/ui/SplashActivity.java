package com.example.leidong.ldplayer.ui;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.leidong.ldplayer.R;

import butterknife.BindView;

/**
 * @author Lei Dong
 * @date 2018/6/14
 * @description 欢迎界面
 */
public class SplashActivity extends BaseActivity {
    private static final String TAG = SplashActivity.class.getSimpleName();

    private Handler handler = new Handler();

    @BindView(R.id.tv_appname)
    TextView mTvAppname;

    @BindView(R.id.pb_loading)
    ProgressBar mPbLoading;

    @Override
    protected int bindLayout() {
        return R.layout.activity_splash;
    }

    /**
     * 进入主界面
     */
    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEventAction  " + event.getAction());
        startMainActivity();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    @Override
    public void initWidgets() {

    }

    @Override
    public void initActions() {

    }

    @Override
    public void doBusiness() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 两秒后才执行到这里
                // 是在主线程中执行的
                startMainActivity();
                Log.d(TAG, "当前线程的名称==" + Thread.currentThread().getName());
            }
        }, 2000);
    }
}
