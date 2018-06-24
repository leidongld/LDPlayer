package com.example.leidong.ldplayer.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leidong.ldplayer.R;
import com.example.leidong.ldplayer.beans.Music;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/6/17.
 */
public class LocalMusicAdapter extends RecyclerView.Adapter<LocalMusicAdapter.ViewHolder> {
    private Context context;
    private Music[] localMusicArray;
    private ArrayList<Music> localMusicList;

    public LocalMusicAdapter(Context context, ArrayList<Music> localMusicList) {
        this.context = context;
        this.localMusicList = localMusicList;
        localMusicArray = new Music[localMusicList.size()];
        localMusicArray = localMusicList.toArray(localMusicArray);
    }

    @NonNull
    @Override
    public LocalMusicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LocalMusicAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_local_music, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.songName.setText(localMusicArray[position].getName());
        holder.songArtist.setText(localMusicArray[position].getArtist());
        holder.localMusicItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+ position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return localMusicList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView songName;

        @BindView(R.id.tv_artist)
        TextView songArtist;

        @BindView(R.id.ll_local_music_item)
        LinearLayout localMusicItem;


        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
