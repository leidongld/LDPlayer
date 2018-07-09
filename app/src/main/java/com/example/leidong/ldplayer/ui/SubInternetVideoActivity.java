package com.example.leidong.ldplayer.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.leidong.ldplayer.MyApplication;
import com.example.leidong.ldplayer.R;
import com.example.leidong.ldplayer.adapters.SubInternetVideoAdapter;
import com.example.leidong.ldplayer.beans.Video;
import com.example.leidong.ldplayer.utils.DataUtils;
import com.example.leidong.webhero.callback.WebHeroCallback;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubInternetVideoActivity extends BaseActivity {
    private static final String TAG = SubInternetVideoActivity.class.getSimpleName();

    @BindView(R.id.iv_top_background)
    ImageView mIvTopBackground;

    @BindView(R.id.tv_name)
    TextView mTvName;

    @BindView(R.id.tv_desc)
    TextView mTvDesc;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    private ArrayList<Video> videosList = new ArrayList<>();

    @Override
    protected int bindLayout() {
        return R.layout.activity_sub_internet_video;
    }

    @Override
    public void initWidgets() {
        loadData();
    }

    /**
     * 加载数据
     *
     */
    private void loadData() {
        DataUtils.loadVideos(new WebHeroCallback() {
            @Override
            public void onSuccess(String content) {
                Gson gson = new Gson();
                videosList = gson.fromJson(content, new TypeToken<ArrayList<Video>>(){}.getType());

                Glide.with(SubInternetVideoActivity.this).load("https://images.pexels.com/photos/1103715/pexels-photo-1103715.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350").into(mIvTopBackground);

                mTvName.setText("热门");

                mTvDesc.setText("这里有你想要的热门视频！");

                mRecyclerview.setLayoutManager(new LinearLayoutManager(MyApplication.getContext()));
                mRecyclerview.setAdapter(new SubInternetVideoAdapter(MyApplication.getContext(), videosList));
            }
        });
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
