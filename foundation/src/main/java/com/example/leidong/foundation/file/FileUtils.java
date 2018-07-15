package com.example.leidong.foundation.file;

import java.io.File;

/**
 * Created by Lei Dong on 2018/6/18.
 */
public class FileUtils {
    public static boolean isExist(String path) {
        File file = new File(path);
        return file.exists();
    }

}
