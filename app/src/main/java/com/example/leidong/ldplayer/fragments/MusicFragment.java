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
public class MusicFragment extends Fragment {
    @BindView(R.id.tv_music_local)
    TextView mTvMusicLocal;

    @BindView(R.id.tv_music_internet)
    TextView mTvMusicInternet;

    @BindView(R.id.music_top_tabs)
    LinearLayout mMusicTopTabs;

    @BindView(R.id.music_viewpager)
    ViewPager mMusicViewpager;

    Unbinder unbinder;

    ArrayList<Fragment> mFragmentList;

    private MyFragmentAdapter mMyFragmentAdapter;

    private LocalMusicFragment mLocalMusicFragment;

    private InternetMusicFragment mInternetMusicFragment;

    private int mCurrentIndex;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initWidgets();
    }

    private void initWidgets() {
        mLocalMusicFragment = new LocalMusicFragment();
        mInternetMusicFragment = new InternetMusicFragment();

        mFragmentList = new ArrayList<>();
        mFragmentList.add(mLocalMusicFragment);
        mFragmentList.add(mInternetMusicFragment);

        mMyFragmentAdapter = new MyFragmentAdapter(getChildFragmentManager(), mFragmentList);
        mMusicViewpager.setAdapter(mMyFragmentAdapter);
        mMusicViewpager.setCurrentItem(mCurrentIndex);
        mTvMusicLocal.setTextColor(getResources().getColor(R.color.top_bar_text_press_color));
        mMusicViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCurrentIndex = position;
                if (mCurrentIndex == 0) {
                    mTvMusicInternet.setTextColor(getResources().getColor(R.color.top_bar_text_color));
                    mTvMusicLocal.setTextColor(getResources().getColor(R.color.top_bar_text_press_color));
                } else {
                    mTvMusicInternet.setTextColor(getResources().getColor(R.color.top_bar_text_press_color));
                    mTvMusicLocal.setTextColor(getResources().getColor(R.color.top_bar_text_color));
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
