package com.example.leidong.foundation.permission;

import java.util.ArrayList;

/**
 * Created by Lei Dong on 2018/6/21.
 */
public interface OnPermissionsCheckListener {
    void onResult(ArrayList<String> grantedPermissions, ArrayList<String> deniedCanAskPermissions, ArrayList<String> deniedNotAskPermissions);
}
