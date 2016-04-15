package com.fred.zeus.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version v1.0.0
 * @since 2016/04/15 14:27s
 */
public class AppUtil {

    private AppUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static String getAppName(Context context) {

        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;

            return context.getResources().getString(labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            LogUtil.i(e.getMessage());
        }
        return null;
    }

    public static String getVersionName(Context context) {

        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            LogUtil.i(e.getMessage());
        }
        return null;
    }

    public static String getClientId(Context context) {

        return Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }
}
