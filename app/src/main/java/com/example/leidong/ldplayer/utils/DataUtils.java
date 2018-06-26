package com.example.leidong.ldplayer.utils;

import com.example.leidong.ldplayer.beans.Artist;
import com.example.leidong.ldplayer.beans.Bann;
import com.example.leidong.ldplayer.beans.Music;
import com.example.leidong.ldplayer.beans.Theme;
import com.example.leidong.ldplayer.beans.Video;

import java.util.ArrayList;
/**
 * Created by Lei Dong on 2018/6/25.
 */
public class DataUtils {
    /**
     * 填充艺术家信息
     *
     * @param artistsList
     */
    public static void loadArtists(ArrayList<Artist> artistsList) {
        artistsList.add(new Artist(
                1,
                "陈奕迅",
                278,
                "陈奕迅简介",
                "https://y.gtimg.cn/music/photo_new/T001R300x300M000003Nz2So3XXYek.jpg?max_age=2592000"));
        artistsList.add(new Artist(
                2,
                "邓紫棋",
                421,
                "邓紫棋简介",
                "https://y.gtimg.cn/music/photo_new/T001R150x150M000001fNHEf1SFEFN.jpg?max_age=2592000"));
        artistsList.add(new Artist(
                3,
                "薛之谦",
                166,
                "薛之谦简介",
                "https://y.gtimg.cn/music/photo_new/T001R150x150M000002J4UUk29y8BY.jpg?max_age=2592000"));
        artistsList.add(new Artist(
                4,
                "林俊杰",
                207,
                "林俊杰简介",
                "https://y.gtimg.cn/music/photo_new/T001R150x150M000001BLpXF2DyJe2.jpg?max_age=2592000"));
        artistsList.add(new Artist(
                5,
                "孙燕姿",
                519,
                "孙燕姿简介",
                "https://y.gtimg.cn/music/photo_new/T001R150x150M000001pWERg3vFgg8.jpg?max_age=2592000"));
        artistsList.add(new Artist(
                6,
                "刘惜君",
                62,
                "刘惜君简介",
                "https://y.gtimg.cn/music/photo_new/T001R150x150M000003x77MM2iIg6c.jpg?max_age=2592000"));
        artistsList.add(new Artist(
                7,
                "李荣浩",
                173,
                "李荣浩简介",
                "https://y.gtimg.cn/music/photo_new/T001R150x150M000000aHmbL2aPXWH.jpg?max_age=2592000"));
        artistsList.add(new Artist(
                8,
                "刘瑞琦",
                48,
                "刘瑞琦简介",
                "https://y.gtimg.cn/music/photo_new/T001R150x150M000003bQEFA3KrvLI.jpg?max_age=2592000"));
        artistsList.add(new Artist(
                9,
                "林忆莲",
                140,
                "林忆莲简介",
                "https://y.gtimg.cn/music/photo_new/T001R150x150M000002u0TJy47WWOj.jpg?max_age=2592000"));
        artistsList.add(new Artist(
                10,
                "张靓颖",
                120,
                "张靓颖简介",
                "https://y.gtimg.cn/music/photo_new/T001R150x150M000000aw4WC2EQYTv.jpg?max_age=2592000"));
    }


    /**
     * 填充主题
     *
     * @param themesList
     */
    public static void loadThemes(ArrayList<Theme> themesList) {
        themesList.add(new Theme(
                1,
                "热门",
                "Hot",
                "https://images.pexels.com/photos/266642/pexels-photo-266642.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        themesList.add(new Theme(
                2,
                "RMHD",
                "RMHD",
                "https://images.pexels.com/photos/681335/pexels-photo-681335.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        themesList.add(new Theme(
                3,
                "创意",
                "Creativity",
                "https://images.pexels.com/photos/171198/pexels-photo-171198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        themesList.add(new Theme(
                4,
                "励志",
                "Encouragement",
                "https://images.pexels.com/photos/6469/red-hands-woman-creative.jpg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        themesList.add(new Theme(
                5,
                "搞笑",
                "Funny",
                "https://images.pexels.com/photos/160846/french-bulldog-summer-smile-joy-160846.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        themesList.add(new Theme(
                6,
                "广告",
                "Advertise",
                "https://images.pexels.com/photos/632470/pexels-photo-632470.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        themesList.add(new Theme(
                7,
                "旅行",
                "Travel",
                "https://images.pexels.com/photos/185933/pexels-photo-185933.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        themesList.add(new Theme(
                8,
                "剧情",
                "Story",
                "https://images.pexels.com/photos/20967/pexels-photo.jpg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        themesList.add(new Theme(
                9,
                "爱情",
                "Love",
                "https://images.pexels.com/photos/236275/pexels-photo-236275.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        themesList.add(new Theme(
                10,
                "运动",
                "Sport",
                "https://images.pexels.com/photos/1092883/pexels-photo-1092883.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        themesList.add(new Theme(
                11,
                "音乐",
                "Music",
                "https://images.pexels.com/photos/6966/abstract-music-rock-bw.jpg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        themesList.add(new Theme(
                12,
                "科幻",
                "Science Fiction",
                "https://images.pexels.com/photos/276452/pexels-photo-276452.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        themesList.add(new Theme(
                13,
                "预告",
                "Advance",
                "https://images.pexels.com/photos/20967/pexels-photo.jpg?auto=compress&cs=tinysrgb&dpr=2&h=350"));

    }

    /**
     * 加载网络音乐界面的Banner
     *
     * @param bannersList
     */
    public static void loadInternetMusicBanners(ArrayList<Bann> bannersList) {
        bannersList.add(new Bann(
                1,
                "音乐1",
                "https://images.pexels.com/photos/33597/guitar-classical-guitar-acoustic-guitar-electric-guitar.jpg?auto=compress&cs=tinysrgb&h=350"));
        bannersList.add(new Bann(
                2,
                "音乐2",
                "https://images.pexels.com/photos/111287/pexels-photo-111287.jpeg?auto=compress&cs=tinysrgb&h=350"));
        bannersList.add(new Bann(
                3,
                "音乐3",
                "https://images.pexels.com/photos/1047442/pexels-photo-1047442.jpeg?auto=compress&cs=tinysrgb&h=350"));
        bannersList.add(new Bann(
                4,
                "音乐4",
                "https://images.pexels.com/photos/625644/pexels-photo-625644.jpeg?auto=compress&cs=tinysrgb&h=350"));
    }

    /**
     * 加载网络视频界面的Banner
     *
     * @param bannersList
     */
    public static void loadInternetVideoBanners(ArrayList<Bann> bannersList) {
        bannersList.add(new Bann(
                1,
                "主题1",
                "https://images.pexels.com/photos/163077/mario-yoschi-figures-funny-163077.jpeg?auto=compress&cs=tinysrgb&h=350"));
        bannersList.add(new Bann(
                2,
                "主题2",
                "https://images.pexels.com/photos/42415/pexels-photo-42415.jpeg?auto=compress&cs=tinysrgb&h=350"));
        bannersList.add(new Bann(
                3,
                "主题3",
                "https://images.pexels.com/photos/187069/pexels-photo-187069.jpeg?auto=compress&cs=tinysrgb&h=350"));
        bannersList.add(new Bann(
                4,
                "主题4",
                "https://images.pexels.com/photos/289831/pexels-photo-289831.jpeg?auto=compress&cs=tinysrgb&h=350"));
    }

    /**
     * 加载网络音乐
     *
     * @param musicsList
     */
    public static void loadMusics(ArrayList<Music> musicsList) {
        musicsList.add(new Music(
                1,
                false,
                "十年",
                "陈奕迅",
                1,
                "十年",
                "www",
                0,
                0,
                "www"));
        musicsList.add(new Music(
                2,
                false,
                "好久不见",
                "陈奕迅",
                1,
                "豪杰不见",
                "www",
                0,
                0,
                "www"));
        musicsList.add(new Music(
                3,
                false,
                "红玫瑰",
                "陈奕迅",
                1,
                "红玫瑰",
                "www",
                0,
                0,
                "www"));
        musicsList.add(new Music(
                4,
                false,
                "K歌之王",
                "陈奕迅",
                1,
                "K歌之王",
                "www",
                0,
                0,
                "www"));
        musicsList.add(new Music(
                5,
                false,
                "在这个世界相遇",
                "陈奕迅",
                1,
                "在这个世界相遇",
                "www",
                0,
                0,
                "www"));
        musicsList.add(new Music(
                6,
                false,
                "因为爱情",
                "陈奕迅",
                1,
                "因为爱情",
                "www",
                0,
                0,
                "www"));
    }

    /**
     * 加载视频数据
     *
     * @param videosList
     */
    public static void loadVideos(ArrayList<Video> videosList) {
        videosList.add(new Video(
                1,
                false,
                1,
                "视频1",
                "",
                "",
                100,
                100,
                100,
                "https://images.pexels.com/photos/35799/summer-still-life-suitcase-in-field-grass-summer.jpg?auto=compress&cs=tinysrgb&dpr=2&h=350"
        ));
        videosList.add(new Video(
                2,
                false,
                1,
                "视频2",
                "",
                "",
                100,
                100,
                100,
                "https://images.pexels.com/photos/733883/pexels-photo-733883.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"
        ));
        videosList.add(new Video(
                3,
                false,
                1,
                "视频3",
                "",
                "",
                100,
                100,
                100,
                "https://images.pexels.com/photos/83932/pexels-photo-83932.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"
        ));
        videosList.add(new Video(
                4,
                false,
                1,
                "视频4",
                "",
                "",
                100,
                100,
                100,
                "https://images.pexels.com/photos/635284/pexels-photo-635284.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"
        ));
        videosList.add(new Video(
                5,
                false,
                1,
                "视频5",
                "",
                "",
                100,
                100,
                100,
                "https://images.pexels.com/photos/122734/pexels-photo-122734.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"
        ));
    }
}
