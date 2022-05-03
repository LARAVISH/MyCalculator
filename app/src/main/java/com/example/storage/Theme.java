package com.example.storage;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

import com.example.mycalculator.R;

public enum Theme {


    ONE(R.style.Theme_MyCalculator, R.string.theme_one, "THEME_ONE"),
    TWO(R.style.Theme_MyCalculator_V2, R.string.theme_two, "THEME_TWO");

    private @StyleRes
    final
    int style;
    private @StringRes
    final
    int title;
    private final String key;

    Theme(int style, int title, String key) {
        this.style = style;
        this.title = title;
        this.key = key;
    }

    public int getStyle() {
        return style;
    }

    public int getTitle() {
        return title;
    }

    public String getKey() {
        return key;
    }
}
