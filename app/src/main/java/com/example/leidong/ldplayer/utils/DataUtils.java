package com.example.leidong.ldplayer.utils;

import com.example.leidong.ldplayer.beans.Channel;
import com.example.leidong.ldplayer.beans.Music;
import com.example.leidong.ldplayer.beans.Video;
import com.example.leidong.webhero.WebConstants;
import com.example.leidong.webhero.WebHeroClient;
import com.example.leidong.webhero.callback.ISuccess;
import com.example.leidong.webhero.callback.WebHeroCallback;

import java.util.ArrayList;

/**
 * Created by Lei Dong on 2018/6/25.
 */
public class DataUtils {
    /**
     * 填充艺术家信息
     *
     * @param callback
     */
    public static void loadArtists(final WebHeroCallback callback) {
        WebHeroClient.builder()
                .url(WebConstants.BASE_URL + WebConstants.ARTISTS_SUB_URL)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String body) {
                        callback.onSuccess(body);
                    }
                })
                .build()
                .get();
    }


    /**
     * 填充主题
     *
     * @param callback
     */
    public static void loadThemes(final WebHeroCallback callback) {
        WebHeroClient.builder()
                .url(WebConstants.BASE_URL + WebConstants.THEMES_SUB_URL)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String body) {
                        callback.onSuccess(body);
                    }
                })
                .build()
                .get();
    }

    /**
     * 加载网络音乐界面的Banner
     *
     * @param callback
     */
    public static void loadInternetMusicBanners(final WebHeroCallback callback) {
        WebHeroClient.builder()
                .url(WebConstants.BASE_URL + WebConstants.BANNERS_SUB_URL + "/2")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String body) {
                        callback.onSuccess(body);
                    }
                })
                .build()
                .get();
    }

    /**
     * 加载网络视频界面的Banner
     *
     * @param webHeroCallback
     */
    public static void loadInternetVideoBanners(final WebHeroCallback webHeroCallback) {
        WebHeroClient.builder()
                .url(WebConstants.BASE_URL + WebConstants.BANNERS_SUB_URL + "/1")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String body) {
                        webHeroCallback.onSuccess(body);
                    }
                })
                .build()
                .get();

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
                "http://www.ytmp3.cn/?down/44686.mp3",
                0,
                0,
                ""));
        musicsList.add(new Music(
                2,
                false,
                "好久不见",
                "陈奕迅",
                1,
                "好久不见",
                "http://www.ytmp3.cn/?down/45024.mp3",
                0,
                0,
                ""));
        musicsList.add(new Music(
                3,
                false,
                "红玫瑰",
                "陈奕迅",
                1,
                "红玫瑰",
                "http://www.ytmp3.cn/?down/39616.mp3",
                0,
                0,
                ""));
        musicsList.add(new Music(
                4,
                false,
                "K歌之王",
                "陈奕迅",
                1,
                "K歌之王",
                "http://www.ytmp3.cn/?down/40686.mp3",
                0,
                0,
                "www"));
        musicsList.add(new Music(
                5,
                false,
                "苦瓜",
                "陈奕迅",
                1,
                "苦瓜",
                "http://www.ytmp3.cn/?down/45069.mp3",
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
                "http://www.ytmp3.cn/?down/39618.mp3",
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


    /**
     * 配置CCTV节目信息
     *
     * @param channelsList
     */
    public static void loadCCTVChannels(ArrayList<Channel> channelsList) {
        channelsList.add(new Channel(
                1,
                1,
                "CCTV1",
                "http://223.110.243.136/PLTV/3/224/3221227206/index.m3u8",
                "https://images.pexels.com/photos/442576/pexels-photo-442576.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                ""
        ));
        channelsList.add(new Channel(
                2,
                1,
                "CCTV2",
                "http://audio.live.cntv.dnion.com/cache/204_/seg0/index.m3u8",
                "https://images.pexels.com/photos/194511/pexels-photo-194511.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                ""
        ));
        channelsList.add(new Channel(
                3,
                1,
                "CCTV4",
                "http://audio.live.cntv.dnion.com/cache/19_/seg0/index.m3u8",
                "https://images.pexels.com/photos/163064/play-stone-network-networked-interactive-163064.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                ""
        ));
        channelsList.add(new Channel(
                4,
                1,
                "CCTV6",
                "http://audio.live.cntv.dnion.com/cache/219_/seg0/index.m3u8",
                "https://images.pexels.com/photos/591652/play-fun-blocks-block-591652.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                ""
        ));
        channelsList.add(new Channel(
                5,
                1,
                "CCTV7",
                "http://audio.live.cntv.dnion.com/cache/224_/seg0/index.m3u8",
                "https://images.pexels.com/photos/756439/pexels-photo-756439.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                ""
        ));
        channelsList.add(new Channel(
                6,
                1,
                "CCTV9",
                "http://audio.live.cntv.dnion.com/cache/294_/seg0/index.m3u8",
                "https://images.pexels.com/photos/776092/pexels-photo-776092.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                ""
        ));
        channelsList.add(new Channel(
                7,
                1,
                "CCTV10",
                "http://audio.live.cntv.dnion.com/cache/234_/seg0/index.m3u8",
                "https://images.pexels.com/photos/209600/pexels-photo-209600.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                ""
        ));
        channelsList.add(new Channel(
                8,
                1,
                "CCTV11",
                "http://audio.live.cntv.dnion.com/cache/239_/seg0/index.m3u8",
                "https://images.pexels.com/photos/256417/pexels-photo-256417.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                ""
        ));
        channelsList.add(new Channel(
                9,
                1,
                "CCTV12",
                "http://audio.live.cntv.dnion.com/cache/244_/seg0/index.m3u8",
                "https://images.pexels.com/photos/168866/pexels-photo-168866.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                ""
        ));
        channelsList.add(new Channel(
                10,
                1,
                "CCTV13",
                "http://116.66.222.46:8082/TV4020.m3u8",
                "https://images.pexels.com/photos/163828/poker-game-play-gambling-163828.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                ""
        ));
        channelsList.add(new Channel(
                1,
                1,
                "CCTV14",
                "http://audio.live.cntv.dnion.com/cache/249_/seg0/index.m3u8",
                "",
                ""
        ));
        channelsList.add(new Channel(
                11,
                1,
                "CCTV15",
                "http://audio.live.cntv.dnion.com/cache/254_/seg0/index.m3u8",
                "https://images.pexels.com/photos/1011334/pexels-photo-1011334.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                ""
        ));
        channelsList.add(new Channel(
                12,
                1,
                "CCTV12",
                "sourcePath",
                "https://images.pexels.com/photos/70459/darts-dart-board-bull-s-eye-game-70459.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                ""
        ));
        channelsList.add(new Channel(
                13,
                1,
                "CCTV13",
                "sourcePath",
                "https://images.pexels.com/photos/39562/the-ball-stadion-football-the-pitch-39562.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                ""
        ));
    }

    /**
     * 配置美食节目信息
     *
     * @param channelsList
     */
    public static void loadFoodChanels(ArrayList<Channel> channelsList) {
        channelsList.add(new Channel(
                1,
                1,
                "美食1",
                "sourcePath",
                "https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                ""
        ));
        channelsList.add(new Channel(
                2,
                1,
                "美食2",
                "sourcePath",
                "https://images.pexels.com/photos/5938/food-salad-healthy-lunch.jpg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                ""
        ));
        channelsList.add(new Channel(
                3,
                1,
                "美食3",
                "sourcePath",
                "https://images.pexels.com/photos/769289/pexels-photo-769289.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                ""
        ));
        channelsList.add(new Channel(
                4,
                1,
                "美食4",
                "sourcePath",
                "https://images.pexels.com/photos/566566/pexels-photo-566566.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                ""
        ));
        channelsList.add(new Channel(
                5,
                1,
                "美食5",
                "sourcePath",
                "https://images.pexels.com/photos/675951/pexels-photo-675951.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                ""
        ));
        channelsList.add(new Channel(
                6,
                1,
                "美食6",
                "sourcePath",
                "https://images.pexels.com/photos/958545/pexels-photo-958545.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                ""
        ));
        channelsList.add(new Channel(
                7,
                1,
                "美食7",
                "sourcePath",
                "https://images.pexels.com/photos/262959/pexels-photo-262959.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                ""
        ));
    }

    /**
     * 配置电影节目信息
     *
     * @param channelsList
     */
    public static void loadMovieChannels(ArrayList<Channel> channelsList) {
        channelsList.add(new Channel(
                1,
                1,
                "电影1",
                "http://183.207.249.15/PLTV/3/224/3221225529/index.m3u8",
                "http://img.ivsky.com/img/bizhi/pre/201804/18/ready_player_one.jpg",
                ""
        ));
        channelsList.add(new Channel(
                2,
                1,
                "电影2",
                "http://183.207.249.15/PLTV/3/224/3221225547/index.m3u8",
                "http://img.ivsky.com/img/bizhi/pre/201804/18/ready_player_one-001.jpg",
                ""
        ));
        channelsList.add(new Channel(
                3,
                1,
                "电影3",
                "http://dlhls.cdn.zhanqi.tv/zqlive/7032_0s2qn.m3u8",
                "http://img.ivsky.com/img/bizhi/pre/201804/18/ready_player_one-002.jpg",
                ""
        ));
        channelsList.add(new Channel(
                4,
                1,
                "电影4",
                "http://183.207.249.15/PLTV/3/224/3221225531/index.m3u8",
                "http://img.ivsky.com/img/bizhi/pre/201804/18/ready_player_one-003.jpg",
                ""
        ));
        channelsList.add(new Channel(
                5,
                1,
                "电影5",
                "http://dlhls.cdn.zhanqi.tv/zqlive/35180_KUDhx.m3u8",
                "http://img.ivsky.com/img/bizhi/pre/201804/18/ready_player_one-004.jpg",
                ""
        ));
        channelsList.add(new Channel(
                6,
                1,
                "电影6",
                "http://dlhls.cdn.zhanqi.tv/zqlive/35349_iXsXw.m3u8",
                "http://img.ivsky.com/img/bizhi/pre/201804/18/ready_player_one-005.jpg",
                ""
        ));
        channelsList.add(new Channel(
                7,
                1,
                "电影7",
                "http://dlhls.cdn.zhanqi.tv/zqlive/53346_ESoth.m3u8",
                "http://img.ivsky.com/img/bizhi/pre/201804/18/ready_player_one-006.jpg",
                ""
        ));
    }

    /**
     * 加载卫视节目数据
     *
     * @param channelsList
     */
    public static void loadSatelliteChannels(ArrayList<Channel> channelsList) {
        channelsList.add(new Channel(
                1,
                1,
                "卫视1",
                "sourcePath",
                "http://img.ivsky.com/img/bizhi/pre/201507/19/game_of_thrones-011.jpg",
                ""
        ));
        channelsList.add(new Channel(
                2,
                1,
                "卫视2",
                "sourcePath",
                "http://img.ivsky.com/img/bizhi/pre/201507/19/game_of_thrones-010.jpg",
                ""
        ));
        channelsList.add(new Channel(
                3,
                1,
                "卫视3",
                "sourcePath",
                "http://img.ivsky.com/img/bizhi/pre/201406/07/game_of_thrones_season-038.jpg",
                ""
        ));
        channelsList.add(new Channel(
                4,
                1,
                "卫视4",
                "sourcePath",
                "http://img.ivsky.com/img/bizhi/t/201406/07/game_of_thrones_season-022.jpg",
                ""
        ));
        channelsList.add(new Channel(
                5,
                1,
                "卫视5",
                "sourcePath",
                "http://img.ivsky.com/img/bizhi/pre/201406/03/game_of_thrones-014.jpg",
                ""
        ));
        channelsList.add(new Channel(
                6,
                1,
                "卫视6",
                "sourcePath",
                "http://img.ivsky.com/img/bizhi/pre/201406/03/game_of_thrones-019.jpg",
                ""
        ));
        channelsList.add(new Channel(
                7,
                1,
                "卫视7",
                "sourcePath",
                "http://d.5857.com/qldyx_160705/005.jpg",
                ""
        ));
    }
}
