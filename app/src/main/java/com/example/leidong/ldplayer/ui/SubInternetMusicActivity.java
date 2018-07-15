package com.example.leidong.ldplayer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.leidong.ldplayer.MyApplication;
import com.example.leidong.ldplayer.R;
import com.example.leidong.ldplayer.adapters.SubInternetMusicAdapter;
import com.example.leidong.ldplayer.beans.Music;
import com.example.leidong.ldplayer.utils.DataUtils;
import com.example.leidong.webhero.callback.WebHeroCallback;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubInternetMusicActivity extends BaseActivity {
    private static final String TAG = SubInternetMusicActivity.class.getSimpleName();

    @BindView(R.id.iv_top_background)
    ImageView mIvTopBackground;

    @BindView(R.id.tv_name)
    TextView mTvName;

    @BindView(R.id.tv_desc)
    TextView mTvDesc;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    private ArrayList<Music> musicsList = new ArrayList<>();

    private int mArtistId;
    private String mArtistName;
    private int mArtistSongNumber;
    private String mArtistImagePath;
    private String mArtistDetail;

    @Override
    protected int bindLayout() {
        return R.layout.activity_sub_internet_music;
    }

    @Override
    public void initWidgets() {
        receiveDataFromIntent();
        loadData();
    }

    /**
     * 从Intent中接收数据
     */
    private void receiveDataFromIntent() {
        Intent intent = getIntent();
        mArtistId = intent.getIntExtra("artistId", 0);
        mArtistName = intent.getStringExtra("artistName");
        mArtistSongNumber = intent.getIntExtra("artistSongNumber", 0);
        mArtistImagePath = intent.getStringExtra("artistImagePath");
        mArtistDetail = intent.getStringExtra("artistDetail");
    }

    /**
     * 加载数据
     */
    private void loadData() {
        DataUtils.loadMusics(mArtistId ,new WebHeroCallback() {
            @Override
            public void onSuccess(String content) {
                Gson gson = new Gson();
                musicsList = gson.fromJson(content, new TypeToken<ArrayList<Music>>(){}.getType());

                Glide.with(SubInternetMusicActivity.this).load(mArtistImagePath).into(mIvTopBackground);

                mTvName.setText(mArtistName);

                mTvDesc.setText(mArtistDetail);

                mRecyclerview.setLayoutManager(new LinearLayoutManager(MyApplication.getContext()));
                mRecyclerview.setAdapter(new SubInternetMusicAdapter(MyApplication.getContext(), musicsList));
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
