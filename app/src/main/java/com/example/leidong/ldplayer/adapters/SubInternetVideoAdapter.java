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
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.leidong.ldplayer.R;
import com.example.leidong.ldplayer.beans.Video;
import com.example.leidong.ldplayer.ui.VideoPlayActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/6/26.
 */
public class SubInternetVideoAdapter extends RecyclerView.Adapter<SubInternetVideoAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Video> videosList;
    private Video[] videosArray;

    public SubInternetVideoAdapter(Context context, ArrayList<Video> videosList) {
        this.context = context;
        this.videosList = videosList;
        videosArray = new Video[videosList.size()];
        videosArray = videosList.toArray(videosArray);
    }

    @NonNull
    @Override
    public SubInternetVideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_video, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SubInternetVideoAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.videoName.setText(videosArray[position].getName());
        Glide.with(context).load(videosArray[position].getImagePath()).into(holder.videoImage);
        holder.videoRank.setRating(videosArray[position].getStars());
        holder.videoRank.setEnabled(false);
        holder.videoDetail.setText(videosArray[position].getDetail());
        holder.videoItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VideoPlayActivity.class);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return videosList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.video_item)
        LinearLayout videoItem;

        @BindView(R.id.tv_name)
        TextView videoName;

        @BindView(R.id.iv_background)
        ImageView videoImage;

        @BindView(R.id.rb_rank)
        RatingBar videoRank;

        @BindView(R.id.tv_detail)
        TextView videoDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
