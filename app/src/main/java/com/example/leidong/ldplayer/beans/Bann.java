package com.example.leidong.ldplayer.beans;

import java.io.Serializable;

/**
 * Created by Lei Dong on 2018/6/24.
 */
public class Bann implements Serializable {
    private int id;

    private int categoryId;

    private String bannerName;

    private String bannerImagePath;

    public Bann() {
    }

    public Bann(int id, int categoryId, String bannerName, String bannerImagePath) {
        this.id = id;
        this.categoryId = categoryId;
        this.bannerName = bannerName;
        this.bannerImagePath = bannerImagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public String getBannerImagePath() {
        return bannerImagePath;
    }

    public void setBannerImagePath(String bannerImagePath) {
        this.bannerImagePath = bannerImagePath;
    }

    @Override
    public String toString() {
        return "Bann{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", bannerName='" + bannerName + '\'' +
                ", bannerImagePath='" + bannerImagePath + '\'' +
                '}';
    }
}
