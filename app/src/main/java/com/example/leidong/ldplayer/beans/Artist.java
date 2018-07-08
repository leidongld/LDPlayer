package com.example.leidong.ldplayer.beans;

import java.io.Serializable;

/**
 * Created by Lei Dong on 2018/6/24.
 */
public class Artist implements Serializable{
    private int id;
    private String name;
    private int songNumber;
    private String detail;
    private String imagePath;

    public Artist() {
    }

    public Artist(int id, String name, int songNumber, String detail, String imagePath) {
        this.id = id;
        this.name = name;
        this.songNumber = songNumber;
        this.detail = detail;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSongNumber() {
        return songNumber;
    }

    public void setSonfNumber(int songNumber) {
        this.songNumber = songNumber;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String desc) {
        this.detail = detail;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", albumId=" + songNumber +
                ", desc='" + detail + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
