package com.example.leidong.ldplayer.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.leidong.ldplayer.R;
import com.example.leidong.ldplayer.beans.Artist;
import com.example.leidong.ldplayer.ui.SubInternetMusicActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/6/24.
 */
public class ArtistsAdapter extends RecyclerView.Adapter<ArtistsAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Artist> artistsList;
    private Artist[] artistsArray;

    public ArtistsAdapter(Context context, ArrayList<Artist> artistsList) {
        this.context = context;
        this.artistsList = artistsList;
        artistsArray = new Artist[artistsList.size()];
        artistsArray = artistsList.toArray(artistsArray);
    }

    @NonNull
    @Override
    public ArtistsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_artist, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ArtistsAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Glide.with(context).load(artistsArray[position].getImagePath()).into(holder.artistImage);

        holder.artistName.setText(artistsArray[position].getName());

        holder.songNumber.setText(artistsArray[position].getSongNumber() + " 首");

        holder.artistItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SubInternetMusicActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return artistsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.artist_image)
        ImageView artistImage;

        @BindView(R.id.artist_name)
        TextView artistName;

        @BindView(R.id.song_number)
        TextView songNumber;

        @BindView(R.id.artist_item)
        LinearLayout artistItem;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
