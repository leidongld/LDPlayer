package com.example.leidong.ldplayer.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.leidong.ldplayer.R;
import com.example.leidong.ldplayer.beans.Channel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/6/27.
 */
public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Channel> channelsList;
    private Channel[] channelsArray;

    public ChannelAdapter(Context context, ArrayList<Channel> channelsList) {
        this.context = context;
        this.channelsList = channelsList;
        channelsArray = new Channel[channelsList.size()];
        channelsArray = channelsList.toArray(channelsArray);
    }

    @NonNull
    @Override
    public ChannelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChannelAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_channel, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChannelAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Glide.with(context).load(channelsArray[position].getImagePath()).into(holder.channelImage);
        holder.channelName.setText(channelsArray[position].getName());
        holder.channelItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return channelsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.channel_item)
        FrameLayout channelItem;

        @BindView(R.id.iv_background)
        ImageView channelImage;

        @BindView(R.id.tv_name)
        TextView channelName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
