package com.example.mycalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.storage.Theme;

public class SelectedThemeActivity extends AppCompatActivity {

    public static final String SELECTED_THEME = "SELECTED_THEME";
    public static final String CHOSEN_THEME = "CHOSEN_THEME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_theme);


        LinearLayout root = findViewById(R.id.root);

        Theme selectTheme = (Theme) getIntent().getSerializableExtra(SELECTED_THEME);
        for (Theme theme : Theme.values()) {

            View viewItem = getLayoutInflater().inflate(R.layout.item, root, false);

            viewItem.setOnClickListener(view -> {

                Intent intent = new Intent();
                intent.putExtra(CHOSEN_THEME, theme);
                setResult(Activity.RESULT_OK, intent);
                finish();
            });

            TextView title = viewItem.findViewById(R.id.theme_title);
            ImageView check = viewItem.findViewById(R.id.theme_check);
            title.setText(theme.getTitle());

            if (theme.equals(selectTheme)) {
                check.setVisibility(View.VISIBLE);
            } else {
                check.setVisibility(View.GONE);
            }

            root.addView(viewItem);
        }

    }
}