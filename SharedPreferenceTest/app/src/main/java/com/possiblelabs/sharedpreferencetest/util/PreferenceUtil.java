package com.possiblelabs.sharedpreferencetest.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by tivesoft on 6/23/15.
 */
public class PreferenceUtil {

    public static final String TAG = "SHARED_PREFERENCE_APP";
    public static final String IS_LOGGED_IN = "IS_LOGGED_IN";

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
    }

    public static void setLoggedIn(Context context, boolean res) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putBoolean(IS_LOGGED_IN, res);
        editor.commit();
    }

    public static boolean isLoggedIn(Context context) {
        return getSharedPreferences(context).getBoolean(IS_LOGGED_IN, false);
    }
}
