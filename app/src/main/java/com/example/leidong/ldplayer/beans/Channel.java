package com.example.leidong.ldplayer.beans;

import java.io.Serializable;

/**
 * Created by Lei Dong on 2018/6/27.
 */
public class Channel  implements Serializable {
    private int id;

    private int categoryId;

    private String name;

    private String sourcePath;

    private String imagePath;

    private String desc;

    public Channel() {
    }

    public Channel(int id, int categoryId, String name, String sourcePath, String imagePath, String desc) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.sourcePath = sourcePath;
        this.imagePath = imagePath;
        this.desc = desc;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
