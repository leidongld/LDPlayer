package com.example.leidong.ldplayer.managers;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.example.leidong.ldplayer.MyApplication;
import com.example.leidong.ldplayer.beans.Music;
import com.example.leidong.ldplayer.utils.FileUtils;

import java.util.ArrayList;

/**
 * Created by Lei Dong on 2018/6/18.
 */
public class FileManager {
    @SuppressLint("StaticFieldLeak")
    private static FileManager mInstance;

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    public static ContentResolver mContentResolver;

    private static final Object mLock = new Object();

    public static FileManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (mLock) {
                if(mInstance == null) {
                    mInstance = new FileManager();
                    mContext = context;
                    mContentResolver = MyApplication.getContext().getContentResolver();
                }
            }
        }
        return mInstance;
    }


    public ArrayList<Music> getLocalMusic() {
        ArrayList<Music> localMusicList = new ArrayList<>();
        Cursor cursor;
        cursor = mContentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
                MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        try {
            assert cursor != null;
            while(cursor.moveToNext()) {
                String path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));

                if(!FileUtils.isExist(path)){
                    continue;
                }

                String name = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));
                String album = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
                String artist = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
                long size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE));
                int duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
                int time = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID));
//            String name = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID));

                Music music = new Music();
                music.setId(0);
                music.setLocal(true);
                music.setName(name);
                music.setArtist(artist);
                music.setAlbum(album);
                music.setPath(path);
                music.setDuration(duration);
                music.setSize(size);
                music.setImagePath(null);

                localMusicList.add(music);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(cursor != null){
                cursor.close();
            }
        }
        return localMusicList;
    }
}


