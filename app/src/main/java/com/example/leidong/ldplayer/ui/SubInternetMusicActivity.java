package com.example.leidong.ldplayer.ui;

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

    @Override
    protected int bindLayout() {
        return R.layout.activity_sub_internet_music;
    }

    @Override
    public void initWidgets() {
        loadData();

        Glide.with(SubInternetMusicActivity.this).load("https://y.gtimg.cn/music/photo_new/T001R300x300M000003Nz2So3XXYek.jpg?max_age=2592000").into(mIvTopBackground);

        mTvName.setText("陈奕迅");

        mTvDesc.setText("代表作品：《爱情转移》、《十年》、《浮夸》、《k歌之王》");

        mRecyclerview.setLayoutManager(new LinearLayoutManager(MyApplication.getContext()));
        mRecyclerview.setAdapter(new SubInternetMusicAdapter(MyApplication.getContext(), musicsList));
    }

    /**
     * 加载数据
     */
    private void loadData() {
        DataUtils.loadMusics(musicsList);
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
