package com.example.leidong.ldplayer.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.leidong.ldplayer.MyApplication;
import com.example.leidong.ldplayer.R;
import com.example.leidong.ldplayer.adapters.ArtistsAdapter;
import com.example.leidong.ldplayer.beans.Artist;
import com.example.leidong.ldplayer.beans.Bann;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Lei Dong on 2018/6/17.
 */
public class InternetMusicFragment extends Fragment implements OnBannerListener {
    private static final String TAG = InternetMusicFragment.class.getSimpleName();

    @BindView(R.id.banner)
    Banner mBanner;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    private ArrayList<Bann> bannersList;

    private ArrayList<String> bannerImagePaths;

    private ArrayList<String> bannerNames;

    private ArrayList<Artist> artistsList;

    Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_internet_music, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        configBanner();

        configArtists();
    }

    /**
     * 配置艺术家信息
     *
     */
    private void configArtists() {
        artistsList = new ArrayList<>();

        artistsList.add(new Artist(
                1,
                "陈奕迅",
                278,
                "陈奕迅简介",
                "https://y.gtimg.cn/music/photo_new/T001R300x300M000003Nz2So3XXYek.jpg?max_age=2592000"));
        artistsList.add(new Artist(
                2,
                "邓紫棋",
                421,
                "邓紫棋简介",
                "https://y.gtimg.cn/music/photo_new/T001R150x150M000001fNHEf1SFEFN.jpg?max_age=2592000"));
        artistsList.add(new Artist(
                3,
                "薛之谦",
                166,
                "薛之谦简介",
                "https://y.gtimg.cn/music/photo_new/T001R150x150M000002J4UUk29y8BY.jpg?max_age=2592000"));
        artistsList.add(new Artist(
                4,
                "林俊杰",
                207,
                "林俊杰简介",
                "https://y.gtimg.cn/music/photo_new/T001R150x150M000001BLpXF2DyJe2.jpg?max_age=2592000"));
        artistsList.add(new Artist(
                5,
                "孙燕姿",
                519,
                "孙燕姿简介",
                "https://y.gtimg.cn/music/photo_new/T001R150x150M000001pWERg3vFgg8.jpg?max_age=2592000"));
        artistsList.add(new Artist(
                6,
                "刘惜君",
                62,
                "刘惜君简介",
                "https://y.gtimg.cn/music/photo_new/T001R150x150M000003x77MM2iIg6c.jpg?max_age=2592000"));
        artistsList.add(new Artist(
                7,
                "李荣浩",
                173,
                "李荣浩简介",
                "https://y.gtimg.cn/music/photo_new/T001R150x150M000000aHmbL2aPXWH.jpg?max_age=2592000"));
        artistsList.add(new Artist(
                8,
                "刘瑞琦",
                48,
                "刘瑞琦简介",
                "https://y.gtimg.cn/music/photo_new/T001R150x150M000003bQEFA3KrvLI.jpg?max_age=2592000"));
        artistsList.add(new Artist(
                9,
                "林忆莲",
                140,
                "林忆莲简介",
                "https://y.gtimg.cn/music/photo_new/T001R150x150M000002u0TJy47WWOj.jpg?max_age=2592000"));
        artistsList.add(new Artist(
                10,
                "张靓颖",
                120,
                "张靓颖简介",
                "https://y.gtimg.cn/music/photo_new/T001R150x150M000000aw4WC2EQYTv.jpg?max_age=2592000"));

        mRecyclerview.setLayoutManager(new GridLayoutManager(MyApplication.getContext(), 2));
        mRecyclerview.setAdapter(new ArtistsAdapter(MyApplication.getContext(), artistsList));
    }

    /**
     * 配置轮播图
     */
    private void configBanner() {
        bannersList = new ArrayList<>();
        bannerImagePaths = new ArrayList<>();
        bannerNames = new ArrayList<>();

        bannersList.add(new Bann(1, "音乐1", "https://images.pexels.com/photos/33597/guitar-classical-guitar-acoustic-guitar-electric-guitar.jpg?auto=compress&cs=tinysrgb&h=350"));
        bannersList.add(new Bann(2, "音乐2", "https://images.pexels.com/photos/111287/pexels-photo-111287.jpeg?auto=compress&cs=tinysrgb&h=350"));
        bannersList.add(new Bann(3, "音乐3", "https://images.pexels.com/photos/1047442/pexels-photo-1047442.jpeg?auto=compress&cs=tinysrgb&h=350"));
        bannersList.add(new Bann(4, "音乐4", "https://images.pexels.com/photos/625644/pexels-photo-625644.jpeg?auto=compress&cs=tinysrgb&h=350"));

        for (int i = 0; i < bannersList.size(); i++) {
            bannerImagePaths.add(bannersList.get(i).getBannerImagePath());
            bannerNames.add(bannersList.get(i).getBannerName());
        }

        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器，图片加载器在下方
        mBanner.setImageLoader(new MyLoader());
        //设置图片网址或地址的集合
        mBanner.setImages(bannerImagePaths);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        mBanner.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
        mBanner.setBannerTitles(bannerNames);
        //设置轮播间隔时间
        mBanner.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        mBanner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        mBanner.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                .setOnBannerListener(this)
                //必须最后调用的方法，启动轮播图。
                .start();
    }

    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(MyApplication.getContext(), "" + position, Toast.LENGTH_SHORT).show();
    }

    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
