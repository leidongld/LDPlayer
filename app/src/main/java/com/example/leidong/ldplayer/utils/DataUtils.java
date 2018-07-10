package com.example.leidong.ldplayer.utils;

import com.example.leidong.webhero.WebConstants;
import com.example.leidong.webhero.WebHeroClient;
import com.example.leidong.webhero.callback.ISuccess;
import com.example.leidong.webhero.callback.WebHeroCallback;

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
     * @param callback
     */
    public static void loadMusics(final WebHeroCallback callback) {
        WebHeroClient.builder()
                .url(WebConstants.BASE_URL + WebConstants.MUSICS_SUB_URL)
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
     * 加载视频数据
     *
     * @param callback
     */
    public static void loadVideos(final WebHeroCallback callback) {
        WebHeroClient.builder()
                .url(WebConstants.BASE_URL + WebConstants.VIDEOS_SUB_URL)
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
     * 配置CCTV节目信息
     *
     * @param callback
     */
    public static void loadCCTVChannels(final WebHeroCallback callback) {
        WebHeroClient.builder()
                .url(WebConstants.BASE_URL + WebConstants.CHANNELS_SUB_URL + "/1")
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
     * 配置美食节目信息
     *
     * @param callback
     */
    public static void loadFoodChanels(final WebHeroCallback callback) {
        WebHeroClient.builder()
                .url(WebConstants.BASE_URL + WebConstants.CHANNELS_SUB_URL + "/4")
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
     * 配置电影节目信息
     *
     * @param callback
     */
    public static void loadMovieChannels(final WebHeroCallback callback) {
        WebHeroClient.builder()
                .url(WebConstants.BASE_URL + WebConstants.CHANNELS_SUB_URL + "/3")
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
     * 加载卫视节目数据
     *
     * @param callback
     */
    public static void loadSatelliteChannels(final WebHeroCallback callback) {
        WebHeroClient.builder()
                .url(WebConstants.BASE_URL + WebConstants.CHANNELS_SUB_URL + "/2")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String body) {
                        callback.onSuccess(body);
                    }
                })
                .build()
                .get();
    }
}
