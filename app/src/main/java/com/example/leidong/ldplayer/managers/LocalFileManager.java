package com.example.leidong.ldplayer.managers;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.example.leidong.ldplayer.MyApplication;
import com.example.leidong.ldplayer.beans.Music;
import com.example.leidong.ldplayer.beans.Video;
import com.example.leidong.ldplayer.utils.FileUtils;

import java.util.ArrayList;

/**
 * Created by Lei Dong on 2018/6/18.
 */
public class LocalFileManager {
    @SuppressLint("StaticFieldLeak")
    private static LocalFileManager mInstance;

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    private static ContentResolver mContentResolver;

    private static final Object mLock = new Object();

    /**
     * 获取LocalFileManager实例
     *
     * @param context
     * @return
     */
    public static LocalFileManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (mLock) {
                if(mInstance == null) {
                    mInstance = new LocalFileManager();
                    mContext = context;
                    mContentResolver = MyApplication.getContext().getContentResolver();
                }
            }
        }
        return mInstance;
    }


    /**
     * 获取本地音乐
     *
     * @return
     */
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

                Music music = new Music();
                music.setId(0);
                music.setLocal(1);
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

    /**
     * 获取本机视频列表
     *
     * @return
     */
    public ArrayList<Video> getLocalVideos() {

        ArrayList<Video> videos = new ArrayList<Video>();

        Cursor c = null;
        try {
            c = mContentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, MediaStore.Video.Media.DEFAULT_SORT_ORDER);
            assert c != null;
            while (c.moveToNext()) {
                String path = c.getString(c.getColumnIndexOrThrow(MediaStore.Video.Media.DATA));// 路径

                if (!FileUtils.isExist(path)) {
                    continue;
                }

                String name = c.getString(c.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME)); // 视频名称
                String resolution = c.getString(c.getColumnIndexOrThrow(MediaStore.Video.Media.RESOLUTION)); //分辨率
                long size = c.getLong(c.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE));// 大小
                long duration = c.getLong(c.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION));// 时长
                long date = c.getLong(c.getColumnIndexOrThrow(MediaStore.Video.Media.DATE_MODIFIED));//修改时间

                Video video = new Video();
                video.setName(name);
                video.setLocal(1);
                video.setPath(path);
                video.setResolution(resolution);
                video.setSize(size);
                video.setDuration(duration);
                video.setDate(date);
                video.setImagePath(null);
                videos.add(video);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return videos;
    }
}


