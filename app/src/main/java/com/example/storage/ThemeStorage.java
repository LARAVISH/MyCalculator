package com.example.storage;

import android.content.Context;
import android.content.SharedPreferences;


public class ThemeStorage {

    private static ThemeStorage INSTANCE;
    private final SharedPreferences sharedPreferences;
    private final Context context;
    private final String THEME_KEY = "THEME_KEY";

    private ThemeStorage(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("preferences", Context.MODE_PRIVATE);
    }

    public static ThemeStorage getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new ThemeStorage(context);
        }
        return INSTANCE;
    }

    public void saveTheme(Theme theme) {
        sharedPreferences.edit()
                .putString(THEME_KEY, theme.getKey())
                .apply();
    }

    public Theme getTheme() {
        String saveTheme = sharedPreferences.getString(THEME_KEY, Theme.ONE.getKey());
        for (Theme theme : Theme.values()) {
            if (theme.getKey().equals(saveTheme)) {
                return theme;
            }
        }
        return Theme.TWO;
    }

}
