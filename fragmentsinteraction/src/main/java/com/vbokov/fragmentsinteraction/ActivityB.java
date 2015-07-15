package com.vbokov.fragmentsinteraction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Bundle extras = getIntent().getExtras();
        String url;

        if (extras != null) {
            url = extras.getString("url");
            FragmentD fragmentD =
                    (FragmentD) getSupportFragmentManager().findFragmentById(R.id.fragment_d);
            fragmentD.showWebPage(url);
        }
    }
}
