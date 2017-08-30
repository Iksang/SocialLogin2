package kr.co.tjeit.sociallogin2.util;

import android.content.Context;
import android.content.SharedPreferences;

import kr.co.tjeit.sociallogin2.data.User;

/**
 * Created by tjoeun on 2017-08-30.
 */

public class ContextUtil {
    private  static User loginUser = null;

    private static final String prefName = "SocialLogin2";
    private static final String USER_ID = "USER_ID";
    private static final String USER_NAME = "USER_NAME";
    private static final String USER_PROFILE_URL = "USER_PROFILE_URL";

    public static void login(Context context, String userId, String userName, String userProfileUrl) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        pref.edit().putString(USER_ID, userId).apply();
        pref.edit().putString(USER_NAME, userName).apply();
        pref.edit().putString(USER_PROFILE_URL, userProfileUrl).apply();
    }

    public static void logout(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        pref.edit().putString(USER_ID, "").commit();
        pref.edit().putString(USER_NAME, "").commit();
        pref.edit().putString(USER_PROFILE_URL, "").commit();
    }


    public static User getLoginUser(Context context){
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        if(pref.getString(USER_ID,"").equals("")){
            loginUser = null;
        }
        else{
            loginUser = new User();
            loginUser.setUserId(pref.getString(USER_ID,""));
            loginUser.setName(pref.getString(USER_NAME,""));
            loginUser.setProfileURL(pref.getString(USER_PROFILE_URL,""));

        }
        return loginUser;

    }



}
