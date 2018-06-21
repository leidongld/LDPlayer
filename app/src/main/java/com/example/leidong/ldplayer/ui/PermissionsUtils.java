package com.example.leidong.ldplayer.ui;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import com.example.leidong.ldplayer.beans.PermissionsBean;
import com.example.leidong.ldplayer.interfaces.OnPermissionsCheckListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Lei Dong on 2018/6/21.
 */

/**
 * Created by Lei Dong on 2018/5/28.
 */
public class PermissionsUtils {
    private static volatile int mRequestCode = 0;

    private static final int MAX_REQUEST_CODE = Short.MAX_VALUE;

    private static final int PERMISSION_GRANTED_STATE = PackageManager.PERMISSION_GRANTED;

    private static final int PERMISSION_DENIED_NOT_ASK_STATE = PackageManager.PERMISSION_DENIED;

    private static final int PERMISSION_DENIED_CAN_ASK_STATE = -2;

    /**
     * Key：requestCode
     * Value：PermisisonBean对象，装载了全部的权限信息和回调接口
     */
    private static HashMap<Integer, PermissionsBean> mPermissionsBeanMap = new HashMap<>();

    /**
     * 装载全部权限信息的Map
     */
    private static HashMap<String, Integer> permissionsMap = new HashMap<>();

    /**
     * 申请多条权限
     *
     * @param context
     * @param permissionsMap
     * @param onPermissionsCheckListener
     */
    private static void requestMultiPermissions(Context context, HashMap<String, Integer> permissionsMap, OnPermissionsCheckListener onPermissionsCheckListener) {
        assert permissionsMap != null;
        ArrayList<String> grantedPermissionsList = new ArrayList<>();
        ArrayList<String> deniedPermissionsCanAskList = new ArrayList<>();
        ArrayList<String> deniedPermissionsNotAskList = new ArrayList<>();

        grantedPermissionsList = obtainPermissionsByState(permissionsMap, PERMISSION_GRANTED_STATE);
        deniedPermissionsCanAskList = obtainPermissionsByState(permissionsMap, PERMISSION_DENIED_CAN_ASK_STATE);
        deniedPermissionsNotAskList = obtainPermissionsByState(permissionsMap, PERMISSION_DENIED_NOT_ASK_STATE);

        // 如果存在拒绝但是可再次询问的权限
        if(deniedPermissionsCanAskList.size() > 0){
            mRequestCode = generateRequestCode();

            PermissionsBean permissionsBean = new PermissionsBean();
            permissionsBean.setPermissionsMap(permissionsMap);
            permissionsBean.setOnPermissionsCheckListener(onPermissionsCheckListener);
            mPermissionsBeanMap.put(mRequestCode, permissionsBean);

            ActivityCompat.requestPermissions((Activity) context, deniedPermissionsCanAskList.toArray(new String[deniedPermissionsCanAskList.size()]), mRequestCode);
        }
        // 如果不存在拒绝但是可再次询问的权限
        else{
            onPermissionsCheckListener.onResult(grantedPermissionsList, deniedPermissionsCanAskList, deniedPermissionsNotAskList);
        }
    }

    /**
     * 某权限是否可以再次请求
     *
     * @param mContext
     * @param permission
     * @return
     */
    private static boolean shouldShowRequestPermissionRationale(Activity mContext, String permission) {
        return ActivityCompat.shouldShowRequestPermissionRationale(mContext, permission);
    }

    /**
     * 产生权限请求码
     *
     * @return
     */
    private static int generateRequestCode() {
        Random random = new Random();
        return random.nextInt(MAX_REQUEST_CODE);
    }

    /**
     * 检查多条权限，如果不具备就请求
     *
     * @param context
     * @param permissions
     * @param onPermissionsCheckListener
     */
    public static void checkPermissions(Activity context, String[] permissions, OnPermissionsCheckListener onPermissionsCheckListener) {
        for (String permission : permissions) {
            permissionsMap.put(permission, PERMISSION_GRANTED_STATE);
        }

        ArrayList<String> grantedPermissionsList = new ArrayList<>();
        ArrayList<String> deniedPermissionsCanAskList = new ArrayList<>();
        ArrayList<String> deniedPermissionsNotAskList = new ArrayList<>();

        if(permissions.length == 0){
            onPermissionsCheckListener.onResult(grantedPermissionsList, deniedPermissionsCanAskList, deniedPermissionsNotAskList);
        }
        else if(Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
            // API > 19 时，默认权限都已经获得
            grantedPermissionsList = obtainPermissionsByState(permissionsMap, PERMISSION_GRANTED_STATE);
            deniedPermissionsCanAskList = obtainPermissionsByState(permissionsMap, PERMISSION_DENIED_CAN_ASK_STATE);
            deniedPermissionsNotAskList = obtainPermissionsByState(permissionsMap, PERMISSION_DENIED_NOT_ASK_STATE);
            onPermissionsCheckListener.onResult(grantedPermissionsList, deniedPermissionsCanAskList, deniedPermissionsNotAskList);
        }
        else if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            // API >= 19 且 API< 23 时，权限只有允许与拒绝不再询问两种
            for(String permission : permissions){
                if(permissionsMap.get(permission) != PERMISSION_GRANTED_STATE){
                    permissionsMap.put(permission, PERMISSION_DENIED_NOT_ASK_STATE);
                }
            }
            grantedPermissionsList = obtainPermissionsByState(permissionsMap, PERMISSION_GRANTED_STATE);
            deniedPermissionsCanAskList = obtainPermissionsByState(permissionsMap, PERMISSION_DENIED_CAN_ASK_STATE);
            deniedPermissionsNotAskList = obtainPermissionsByState(permissionsMap, PERMISSION_DENIED_NOT_ASK_STATE);
            onPermissionsCheckListener.onResult(grantedPermissionsList, deniedPermissionsCanAskList, deniedPermissionsNotAskList);
        }
        else {
            // API >= 23 的情况 使用系统API进行权限判断
            for (String permission : permissions) {
                int permissionState = ActivityCompat.checkSelfPermission(context, permission);
                if (permissionState != PERMISSION_GRANTED_STATE
                        && shouldShowRequestPermissionRationale(context, permission)) {
                    permissionsMap.put(permission, PERMISSION_DENIED_CAN_ASK_STATE);
                }
                else if(permissionState != PERMISSION_GRANTED_STATE
                        && !shouldShowRequestPermissionRationale(context, permission)){
                    permissionsMap.put(permission, PERMISSION_DENIED_NOT_ASK_STATE);
                }
            }
        }
        requestMultiPermissions(context, permissionsMap, onPermissionsCheckListener);
    }

    /**
     * 根据权限状态码填充对应权限到List中
     *
     * @param permissionsMap
     * @param permissionState
     * @return
     */
    private static ArrayList<String> obtainPermissionsByState(HashMap<String, Integer> permissionsMap, int permissionState) {
        ArrayList<String> permissionsList = new ArrayList<>();
        for (String permission : permissionsMap.keySet()) {
            if(permissionsMap.get(permission) == permissionState){
                permissionsList.add(permission);
            }
        }
        return permissionsList;
    }


    public static void onRequestPermissionsResult(Activity context, int requestCode, String[] permissions, int[] grantedResult) {
        PermissionsBean permissionsBean = mPermissionsBeanMap.get(requestCode);
        OnPermissionsCheckListener onPermissionsCheckListener = permissionsBean.getOnPermissionsCheckListener();
        HashMap<String, Integer> permissionsMap = permissionsBean.getPermissionsMap();

        ArrayList<String> grantedPermissionsList;
        ArrayList<String> deniedPermissionsCanAskList;
        ArrayList<String> deniedPermissionsNotAskList;

        if(onPermissionsCheckListener != null){
            int i = 0;
            for(String permission : permissionsMap.keySet()){
                int permissionState = grantedResult[i++];
                if(permissionState == PERMISSION_GRANTED_STATE){
                    permissionsMap.put(permission, PERMISSION_GRANTED_STATE);
                }
                else if(shouldShowRequestPermissionRationale(context, permission)){
                    permissionsMap.put(permission, PERMISSION_DENIED_CAN_ASK_STATE);
                }
                else{
                    permissionsMap.put(permission, PERMISSION_DENIED_NOT_ASK_STATE);
                }
            }
        }
        grantedPermissionsList = obtainPermissionsByState(permissionsMap, PERMISSION_GRANTED_STATE);
        deniedPermissionsCanAskList = obtainPermissionsByState(permissionsMap, PERMISSION_DENIED_CAN_ASK_STATE);
        deniedPermissionsNotAskList = obtainPermissionsByState(permissionsMap, PERMISSION_DENIED_NOT_ASK_STATE);
        permissionsMap.remove(requestCode);

        assert onPermissionsCheckListener != null;
        onPermissionsCheckListener.onResult(grantedPermissionsList, deniedPermissionsCanAskList, deniedPermissionsNotAskList);
    }
}