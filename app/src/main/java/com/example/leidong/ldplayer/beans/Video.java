package com.example.leidong.ldplayer.beans;

/**
 * Created by Lei Dong on 2018/6/21.
 */
public class Video {
    private int id;

    private boolean isLocal;

    private String name;

    private String path;

    private String resolution;

    private long size;

    private long duration;

    private long date;

    private String imagePath;

    public Video() {
        id = 0;
    }

    public Video(int id, boolean isLocal, String name,String path, String resolution, long size, long duration, long date, String imagePath) {
        this.id = id;
        this.isLocal = isLocal;
        this.name = name;
        this.path = path;
        this.resolution = resolution;
        this.size = size;
        this.duration = duration;
        this.date = date;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
