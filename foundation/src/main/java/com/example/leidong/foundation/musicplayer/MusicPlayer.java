package com.example.leidong.foundation.musicplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.IOException;

/**
 * Created by Lei Dong on 2018/7/16.
 */
public class MusicPlayer {
    private static MediaPlayer mMediaPlayer;
    private static boolean isLoop = false;

    public MusicPlayer(boolean isLoop) {
        MusicPlayer.isLoop = isLoop;
    }

    private static boolean getIsLoop(){
        return isLoop;
    }

    /**
     * 播放网络音乐
     *
     * @param context
     * @param path
     */
    public static void playOnlineSong(Context context, String path) throws IOException {
        if (mMediaPlayer == null) {
            mMediaPlayer = new MediaPlayer();
        }

        mMediaPlayer.reset();

        Uri uri = Uri.parse(path);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setDataSource(context, uri);
        mMediaPlayer.prepare();
        mMediaPlayer.start();
        mMediaPlayer.setLooping(getIsLoop());
    }

    /**
     * 播放本地音乐
     *
     * @param context
     * @param path
     */
    public static void playLocalSong(Context context, String path) throws IOException {
        if (mMediaPlayer == null) {
            mMediaPlayer = new MediaPlayer();
        }

        mMediaPlayer.reset();

        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setDataSource(path);
        mMediaPlayer.prepare();
        mMediaPlayer.start();
        mMediaPlayer.setLooping(getIsLoop());
    }

    /**
     * 通知播放并销毁
     */
    public static void stop(){
        if(mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
