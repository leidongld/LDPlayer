package com.example.leidong.ldplayer.beans;

import java.io.Serializable;

/**
 * Created by Lei Dong on 2018/6/18.
 */
public class Music implements Serializable {
    private int id;

    private boolean isLocal;

    private String name;

    private String artist;

    private int artistId;

    private String album;

    private String path;

    private float duration;

    private long size;

    private String imagePath;

    public Music() {
    }

    public Music(int id, boolean isLocal, String name, String artist,int artistId, String album, String path, float duration, long size, String imagePath) {
        this.id = id;
        this.isLocal = isLocal;
        this.name = name;
        this.artist = artist;
        this.artistId = artistId;
        this.album = album;
        this.path = path;
        this.duration = duration;
        this.size = size;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", isLocal=" + isLocal +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", artistId=" + artistId +
                ", album='" + album + '\'' +
                ", path='" + path + '\'' +
                ", duration=" + duration +
                ", size=" + size +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
