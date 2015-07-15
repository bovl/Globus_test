package com.vbokov.themeschanging;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by vladimirbokov on 15/07/15.
 */
public class Utils {
    private static int sTheme;
    public final static int THEME_1 = 1;
    public final static int THEME_2 = 2;

    public static void changeToTheme(Activity activity, int toTheme) {
        sTheme = toTheme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onCreateSetTheme(Activity activity) {
        switch (sTheme) {
            case THEME_1:
                activity.setTheme(R.style.FirstTheme);
                break;
            case THEME_2:
                activity.setTheme(R.style.SecondTheme);
                break;
            default:
                activity.setTheme(R.style.FirstTheme);
                break;
        }
    }
}