package com.example.leidong.ldplayer.fragments;

import android.app.FragmentManager;
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
public class VideoFragment extends Fragment {
    private static final String TAG = VideoFragment.class.getSimpleName();

    @BindView(R.id.video_top_tabs)
    LinearLayout mVideoTopTabs;

    @BindView(R.id.video_viewpager)
    ViewPager mVideoViewpager;

    @BindView(R.id.tv_video_local)
    TextView mTvVideoLocal;

    @BindView(R.id.tv_video_internet)
    TextView mTvVideoInternet;

    Unbinder unbinder;

    ArrayList<Fragment> mFragmentList;

    private MyFragmentAdapter mMyFragmentAdapter;

    private LocalVideoFragment mLocalVideoFragment;

    private InternetVideoFragment mInternetVideoFragment;

    private FragmentManager mFragmentManager;

    private int mCurrentIndex = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initWidgets();
    }

    private void initWidgets() {
        mLocalVideoFragment = new LocalVideoFragment();
        mInternetVideoFragment = new InternetVideoFragment();

        mFragmentList = new ArrayList<>();
        mFragmentList.add(mLocalVideoFragment);
        mFragmentList.add(mInternetVideoFragment);

        mMyFragmentAdapter = new MyFragmentAdapter(getChildFragmentManager(), mFragmentList);
        mVideoViewpager.setAdapter(mMyFragmentAdapter);
        mVideoViewpager.setCurrentItem(mCurrentIndex);
        mTvVideoLocal.setTextColor(getResources().getColor(R.color.top_bar_text_press_color));
        mVideoViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCurrentIndex = position;
                if (mCurrentIndex == 0) {
                    mTvVideoInternet.setTextColor(getResources().getColor(R.color.top_bar_text_color));
                    mTvVideoLocal.setTextColor(getResources().getColor(R.color.top_bar_text_press_color));
                } else {
                    mTvVideoInternet.setTextColor(getResources().getColor(R.color.top_bar_text_press_color));
                    mTvVideoLocal.setTextColor(getResources().getColor(R.color.top_bar_text_color));
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
