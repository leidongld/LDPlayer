package com.example.leidong.ldplayer.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Lei Dong on 2018/6/21.
 */
public class NetUtils {
    /**
     * 网络断开
     */
    private static final int NETWORK_OFF = 0;
    /**
     * WiFi打开
     */
    private static final int WIFI_ON = 1;
    /**
     * 移动网络打开
     */
    private static final int MOBILE_ON = 2;

    /**
     * 判断网络状态
     *
     * @param context
     * @return
     */
    public static int checkNetworkState(Context context){
        if(isWifiOn(context)){
            return WIFI_ON;
        } else if(isMobileOn(context)){
            return MOBILE_ON;
        } else{
            return NETWORK_OFF;
        }
    }

    /**
     * 判断移动网络是否打开
     *
     * @param context
     * @return
     */
    private static boolean isMobileOn(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        return networkInfo.isConnected();
    }

    /**
     * 判断WiFi是否打开
     *
     * @param context
     * @return
     */
    private static boolean isWifiOn(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return networkInfo.isConnected();
    }
}
