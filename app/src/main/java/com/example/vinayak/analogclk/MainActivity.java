package com.example.vinayak.analogclk;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBar;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SurfaceView surfaceView;
    MySurfaceView mySurfaceView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.clok);


        mySurfaceView = new MySurfaceView(this, 450f);
        setContentView(mySurfaceView);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {

            case R.id.copy_item:
                Intent intent = new Intent(getApplicationContext(), Alarm.class);
                startActivity(intent);
                return true;

            case R.id.preference:
                Intent intent1 = new Intent(getApplicationContext(), SharedColorPreference.class);
                startActivity(intent1);
                return true;

            case R.id.preference1:
                Intent intent2 = new Intent(getApplicationContext(), SharedColorPreferenceHands.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {

        super.onResume();
        mySurfaceView.onResumeMySurfaceView();
    }

    @Override
    protected void onPause() {

        super.onPause();
        mySurfaceView.onPauseMySurfaceView();
    }

}
