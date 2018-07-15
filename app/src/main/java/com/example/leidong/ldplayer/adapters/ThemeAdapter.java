package com.example.leidong.ldplayer.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.leidong.ldplayer.R;
import com.example.leidong.ldplayer.beans.Theme;
import com.example.leidong.ldplayer.ui.SubInternetVideoActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/6/24.
 */
public class ThemeAdapter extends RecyclerView.Adapter<ThemeAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Theme> themesList;
    private Theme[] themesArray;

    public ThemeAdapter(Context context, ArrayList<Theme> themesList) {
        this.context = context;
        this.themesList = themesList;
        themesArray = new Theme[themesList.size()];
        themesArray = themesList.toArray(themesArray);
    }

    @NonNull
    @Override
    public ThemeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_theme, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ThemeAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.themeName.setText(themesArray[position].getName());
        holder.themeDesc.setText(themesArray[position].getDetail());
        Glide.with(context).load(themesArray[position].getImagePath()).into(holder.background);

        holder.themeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SubInternetVideoActivity.class);
                intent.putExtra("themeId", position+1);
                intent.putExtra("themeName", themesArray[position].getName());
                intent.putExtra("themeImagePath", themesArray[position].getImagePath());
                intent.putExtra("themeDetail", themesArray[position].getDetail());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return themesList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.theme_item)
        FrameLayout themeItem;

        @BindView(R.id.theme_name)
        TextView themeName;

        @BindView(R.id.theme_desc)
        TextView themeDesc;

        @BindView(R.id.background)
        ImageView background;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
