package com.example.leidong.ldplayer.beans;

import java.io.Serializable;

/**
 * Created by Lei Dong on 2018/6/21.
 */
public class Video  implements Serializable {
    private int id;

    private int isLocal;

    private int themeId;

    private String name;

    private String path;

    private String resolution;

    private long size;

    private long duration;

    private long date;

    private String imagePath;

    public Video() {
    }

    public Video(int id, int isLocal,int themeId, String name,String path, String resolution, long size, long duration, long date, String imagePath) {
        this.id = id;
        this.isLocal = isLocal;
        this.themeId = themeId;
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

    public int isLocal() {
        return isLocal;
    }

    public void setLocal(int local) {
        isLocal = local;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
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

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", isLocal=" + isLocal +
                ", themeId=" + themeId +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", resolution='" + resolution + '\'' +
                ", size=" + size +
                ", duration=" + duration +
                ", date=" + date +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
