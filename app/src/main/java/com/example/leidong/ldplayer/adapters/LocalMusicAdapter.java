package com.example.leidong.ldplayer.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leidong.ldplayer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/6/17.
 */
public class LocalMusicAdapter extends RecyclerView.Adapter<LocalMusicAdapter.ViewHolder> {
    private Context context;
    private String[] datas;

    public LocalMusicAdapter(Context context, String[] datas) {
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public LocalMusicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LocalMusicAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_local_music, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.text.setText(datas[position]);
        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, datas[position], Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        if (datas.length != 0) {
            return datas.length;
        }
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text)
        TextView text;


        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
