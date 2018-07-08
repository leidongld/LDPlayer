package com.example.leidong.ldplayer.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leidong.ldplayer.MyApplication;
import com.example.leidong.ldplayer.R;
import com.example.leidong.ldplayer.adapters.ChannelAdapter;
import com.example.leidong.ldplayer.beans.Channel;
import com.example.leidong.ldplayer.utils.DataUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Lei Dong on 2018/6/17.
 */
public class MovieChannelFragment extends Fragment {
    private static final String TAG = MovieChannelFragment.class.getSimpleName();

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    Unbinder unbinder;

    private ArrayList<Channel> channelsList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_movie_channel, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initWidgets();
    }

    /**
     *
     */
    private void initWidgets() {
        configMovieChannels();

        mRecyclerview.setLayoutManager(new LinearLayoutManager(MyApplication.getContext()));
        mRecyclerview.setAdapter(new ChannelAdapter(MyApplication.getContext(), channelsList));
    }

    /**
     *
     */
    private void configMovieChannels() {
        DataUtils.loadMovieChannels(channelsList);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
