package com.vbokov.fragmentsinteraction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ActivityA extends AppCompatActivity
        implements FragmentL.UrlListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
    }

    @Override
    public void onButtonClick(String url) {
        Intent intent = new Intent(this, ActivityB.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }
}
