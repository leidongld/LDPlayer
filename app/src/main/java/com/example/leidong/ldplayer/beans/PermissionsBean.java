package com.example.leidong.ldplayer.beans;

import com.example.leidong.ldplayer.interfaces.OnPermissionsCheckListener;

import java.util.HashMap;

/**
 * Created by Lei Dong on 2018/6/21.
 */
public class PermissionsBean {
    private OnPermissionsCheckListener onPermissionsCheckListener;
    private HashMap<String, Integer> permissionsMap;

    public PermissionsBean() {
    }

    public PermissionsBean(OnPermissionsCheckListener onPermissionsCheckListener, HashMap<String, Integer> permissionsMap) {
        this.onPermissionsCheckListener = onPermissionsCheckListener;
        this.permissionsMap = permissionsMap;
    }

    public OnPermissionsCheckListener getOnPermissionsCheckListener() {
        return onPermissionsCheckListener;
    }

    public void setOnPermissionsCheckListener(OnPermissionsCheckListener onPermissionsCheckListener) {
        this.onPermissionsCheckListener = onPermissionsCheckListener;
    }

    public HashMap<String, Integer> getPermissionsMap() {
        return permissionsMap;
    }

    public void setPermissionsMap(HashMap<String, Integer> permissionsMap) {
        this.permissionsMap = permissionsMap;
    }
}
