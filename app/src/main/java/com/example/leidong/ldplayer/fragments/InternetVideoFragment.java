package com.example.leidong.ldplayer.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.leidong.ldplayer.MyApplication;
import com.example.leidong.ldplayer.R;
import com.example.leidong.ldplayer.adapters.ThemeAdapter;
import com.example.leidong.ldplayer.beans.Bann;
import com.example.leidong.ldplayer.beans.Theme;
import com.example.leidong.ldplayer.ui.SubInternetVideoActivity;
import com.example.leidong.ldplayer.utils.DataUtils;
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
 * Created by Lei Dong on 2018/6/16.
 */
public class InternetVideoFragment extends Fragment implements OnBannerListener {
    @BindView(R.id.banner)
    Banner mBanner;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    Unbinder unbinder;

    private ArrayList<Bann> bannersList;

    private ArrayList<String> bannerImagePaths;

    private ArrayList<String> bannerNames;

    private ArrayList<Theme> themesList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_internet_video, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        configBanner();

        configThemes();
    }

    /**
     * 配置视频主题
     */
    private void configThemes() {
        themesList = new ArrayList<>();

        DataUtils.loadThemes(themesList);

        mRecyclerview.setLayoutManager(new GridLayoutManager(MyApplication.getContext(), 2));
        mRecyclerview.setAdapter(new ThemeAdapter(MyApplication.getContext(), themesList));
    }

    /**
     * 配置轮播图
     */
    private void configBanner() {
        bannersList = new ArrayList<>();
        bannerImagePaths = new ArrayList<>();
        bannerNames = new ArrayList<>();

        DataUtils.loadInternetVideoBanners(bannersList);

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
        mBanner.setDelayTime(4000);
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
        Intent intent = new Intent(MyApplication.getContext(), SubInternetVideoActivity.class);
        MyApplication.getContext().startActivity(intent);
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
