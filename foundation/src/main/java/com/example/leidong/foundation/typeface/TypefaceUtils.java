package com.example.leidong.foundation.typeface;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Lei Dong on 2018/7/15.
 */
public class TypefaceUtils {
    /**
     * 获取字体
     *
     * @param context
     * @param name
     * @return
     */
    public static Typeface obtainTypeface(Context context, String name) {
        String path = "fonts/" + name + ".ttf";
        return Typeface.createFromAsset(context.getAssets(),  path);
    }
}
