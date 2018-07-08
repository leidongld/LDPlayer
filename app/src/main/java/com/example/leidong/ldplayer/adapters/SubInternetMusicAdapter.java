package com.example.leidong.ldplayer.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.leidong.ldplayer.R;
import com.example.leidong.ldplayer.beans.Music;
import com.example.leidong.ldplayer.ui.MusicPlayActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/6/25.
 */
public class SubInternetMusicAdapter extends RecyclerView.Adapter<SubInternetMusicAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Music> musicsList;
    private Music[] musicsArray;

    public SubInternetMusicAdapter(Context context, ArrayList<Music> musicsList) {
        this.context = context;
        this.musicsList = musicsList;
        musicsArray = new Music[musicsList.size()];
        musicsArray = musicsList.toArray(musicsArray);
    }

    @NonNull
    @Override
    public SubInternetMusicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SubInternetMusicAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_music, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SubInternetMusicAdapter.ViewHolder holder, final int position) {
        holder.musicNumber.setText((1 + position) + "");
        holder.musicName.setText(musicsArray[position].getName());
        holder.musicArtist.setText(musicsArray[position].getArtist());
        holder.musicItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MusicPlayActivity.class);
                intent.putExtra("currentMusic", musicsArray[position]);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return musicsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.music_item)
        LinearLayout musicItem;

        @BindView(R.id.tv_number)
        TextView musicNumber;

        @BindView(R.id.tv_name)
        TextView musicName;

        @BindView(R.id.tv_artist)
        TextView musicArtist;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
