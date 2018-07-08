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
import com.example.leidong.ldplayer.beans.Video;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/6/17.
 */
public class LocalVideoAdapter extends RecyclerView.Adapter<LocalVideoAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Video> localVideoList;
    private Video[] localVideoArray;

    public LocalVideoAdapter(Context context, ArrayList<Video> localVideoList) {
        this.context = context;
        this.localVideoList = localVideoList;
        localVideoArray = new Video[localVideoList.size()];
        localVideoArray = localVideoList.toArray(localVideoArray);
    }

    @NonNull
    @Override
    public LocalVideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_local_video, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LocalVideoAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.videoName.setText(localVideoArray[position].getName());
        // TODO: 2018/6/22  这边应该装化为 hh：mm：ss 的格式
        holder.videoDuration.setText(localVideoArray[position].getDuration() + "");
        holder.localVideoItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, localVideoArray[position].getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return localVideoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView videoName;

        @BindView(R.id.tv_duration)
        TextView videoDuration;

        @BindView(R.id.ll_local_video_item)
        LinearLayout localVideoItem;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
