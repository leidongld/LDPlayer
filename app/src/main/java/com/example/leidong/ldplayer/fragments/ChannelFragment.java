package com.example.leidong.ldplayer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.leidong.ldplayer.R;
import com.example.leidong.ldplayer.adapters.MyFragmentAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Lei Dong on 2018/6/16.
 */
public class ChannelFragment extends Fragment {
    @BindView(R.id.channel_top_tabs)
    LinearLayout mChannelTopTabs;

    @BindView(R.id.tv_channel_cctv)
    TextView mTvChannelCctv;

    @BindView(R.id.tv_channel_satellite)
    TextView mTvChannelSatellite;

    @BindView(R.id.tv_channel_movie)
    TextView mTvChannelMovie;

    @BindView(R.id.tv_channel_food)
    TextView mTvChannelFood;

    @BindView(R.id.channel_viewpager)
    ViewPager mChannelViewpager;

    private MyFragmentAdapter mMyFragmentAdapter;

    Unbinder unbinder;

    ArrayList<Fragment> mFragmentList;

    private CCTVChannelFragment mCctvChannelFragment;

    private SatelliteChannelFragment mSatelliteChannelFragment;

    private MovieChannelFragment mMovieChannelFragment;

    private FoodChannelFragment mFoodChannelFragment;

    private int mCurrentIndex;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_channel, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initWidgets();
    }

    /**
     * 初始化
     */
    private void initWidgets() {
        mCctvChannelFragment = new CCTVChannelFragment();
        mSatelliteChannelFragment = new SatelliteChannelFragment();
        mMovieChannelFragment = new MovieChannelFragment();
        mFoodChannelFragment = new FoodChannelFragment();

        mFragmentList = new ArrayList<>();
        mFragmentList.add(mCctvChannelFragment);
        mFragmentList.add(mSatelliteChannelFragment);
        mFragmentList.add(mMovieChannelFragment);
        mFragmentList.add(mFoodChannelFragment);

        mMyFragmentAdapter = new MyFragmentAdapter(getChildFragmentManager(), mFragmentList);
        mChannelViewpager.setAdapter(mMyFragmentAdapter);
        mChannelViewpager.setCurrentItem(mCurrentIndex);
        mTvChannelCctv.setTextColor(getResources().getColor(R.color.top_bar_text_press_color));
        mChannelViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCurrentIndex = position;
                if (mCurrentIndex == 0) {
                    mTvChannelCctv.setTextColor(getResources().getColor(R.color.top_bar_text_press_color));
                    mTvChannelSatellite.setTextColor(getResources().getColor(R.color.top_bar_text_color));
                    mTvChannelMovie.setTextColor(getResources().getColor(R.color.top_bar_text_color));
                    mTvChannelFood.setTextColor(getResources().getColor(R.color.top_bar_text_color));
                } else if (mCurrentIndex == 1) {
                    mTvChannelCctv.setTextColor(getResources().getColor(R.color.top_bar_text_color));
                    mTvChannelSatellite.setTextColor(getResources().getColor(R.color.top_bar_text_press_color));
                    mTvChannelMovie.setTextColor(getResources().getColor(R.color.top_bar_text_color));
                    mTvChannelFood.setTextColor(getResources().getColor(R.color.top_bar_text_color));
                } else if (mCurrentIndex == 2) {
                    mTvChannelCctv.setTextColor(getResources().getColor(R.color.top_bar_text_color));
                    mTvChannelSatellite.setTextColor(getResources().getColor(R.color.top_bar_text_color));
                    mTvChannelMovie.setTextColor(getResources().getColor(R.color.top_bar_text_press_color));
                    mTvChannelFood.setTextColor(getResources().getColor(R.color.top_bar_text_color));
                } else {
                    mTvChannelCctv.setTextColor(getResources().getColor(R.color.top_bar_text_color));
                    mTvChannelSatellite.setTextColor(getResources().getColor(R.color.top_bar_text_color));
                    mTvChannelMovie.setTextColor(getResources().getColor(R.color.top_bar_text_color));
                    mTvChannelFood.setTextColor(getResources().getColor(R.color.top_bar_text_press_color));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
