package com.example.leidong.ldplayer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leidong.ldplayer.R;
import com.example.leidong.ldplayer.adapters.LocalVideoAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Lei Dong on 2018/6/16.
 */
public class LocalVideoFragment extends Fragment {
    private static final String TAG = LocalVideoFragment.class.getSimpleName();

    @BindView(R.id.local_video_container)
    RecyclerView mLocalVideoContainer;

    Unbinder unbinder;

    /*测试数据*/
    private static final String[] DATATS = {
            "001",
            "002",
            "003",
            "004",
            "005",
            "006",
            "007"
    };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_local_video, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initWidgets();
    }

    private void initWidgets() {
        mLocalVideoContainer.setLayoutManager(new LinearLayoutManager(getContext()));
        mLocalVideoContainer.setAdapter(new LocalVideoAdapter(getContext(), DATATS));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
