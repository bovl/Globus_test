package com.vbokov.themeschanging;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private TextView mTextView;
    private static boolean sFirstTimeLaunch = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Utils.onCreateSetTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.description);

        if (sFirstTimeLaunch) {
            mTextView.setText("android:Theme.light");
            sFirstTimeLaunch = false;
        } else {
            mTextView.setText(getDataFromPreferences(this, "textKey"));
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        saveDataToPreferences(this, "textKey", mTextView.getText().toString());
    }

    public void saveDataToPreferences(Context context, String key, String value) {
        SharedPreferences prefs = context.getSharedPreferences("com.vbokov.themeschanging",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getDataFromPreferences(Context context, String key) {
        SharedPreferences prefs = context.getSharedPreferences("com.vbokov.themeschanging",
                Context.MODE_PRIVATE);
        return prefs.getString(key, null);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                saveDataToPreferences(this, "textKey", "android:Theme.light");
                Utils.changeToTheme(this, Utils.THEME_1);
                break;
            case R.id.button2:
                saveDataToPreferences(this, "textKey", "android:Theme.NoTitleBar.Fullscreen");
                Utils.changeToTheme(this, Utils.THEME_2);
                break;
        }
    }
}

