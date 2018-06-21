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
import com.example.leidong.ldplayer.adapters.LocalMusicAdapter;
import com.example.leidong.ldplayer.beans.Music;
import com.example.leidong.ldplayer.managers.FileManager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Lei Dong on 2018/6/17.
 */
public class LocalMusicFragment extends Fragment {
    private static final String TAG = LocalMusicFragment.class.getSimpleName();

    @BindView(R.id.local_music_container)
    RecyclerView mLocalMusicContainer;

    Unbinder unbinder;

    private static final String[] DATAS = {
            "001",
            "002",
            "003",
            "004",
            "005",
            "006",
            "007"
    };

    private ArrayList<Music> localMusicList = FileManager.getInstance(MyApplication.getContext()).getLocalMusic();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_local_music, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initWidgets();
    }

    private void initWidgets() {
        mLocalMusicContainer.setLayoutManager(new LinearLayoutManager(getContext()));
        mLocalMusicContainer.setAdapter(new LocalMusicAdapter(getContext(), localMusicList));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
