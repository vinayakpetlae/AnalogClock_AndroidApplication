package com.example.vinayak.analogclk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class SharedColorPreference extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_color_preference);


    }

    public void viewclk(View view) {

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }

    public void red(View view) {
        Toast.makeText(getApplicationContext(), "RED COLOR", Toast.LENGTH_LONG).show();

        Button button = (Button) findViewById(R.id.button);
        ColorDrawable buttonColor = (ColorDrawable) button.getBackground();

        int colorId = buttonColor.getColor();

        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        preferences.edit().putInt("color", colorId).apply();

    }

    public void blue(View view) {
        Toast.makeText(getApplicationContext(), "BLUE COLOR", Toast.LENGTH_LONG).show();

        Button button1 = (Button) findViewById(R.id.button2);
        ColorDrawable buttonColor1 = (ColorDrawable) button1.getBackground();

        int colorId1 = buttonColor1.getColor();
        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        preferences.edit().putInt("color", colorId1).apply();

    }

    public void lightgreen(View view) {
        Toast.makeText(getApplicationContext(), "LIGHT GREEN COLOR", Toast.LENGTH_LONG).show();


        Button button = (Button) findViewById(R.id.button4);
        ColorDrawable buttonColor = (ColorDrawable) button.getBackground();

        int colorId = buttonColor.getColor();

        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        preferences.edit().putInt("color", colorId).apply();

    }

    public void orange(View view) {
        Toast.makeText(getApplicationContext(), "LIGHT GREEN COLOR", Toast.LENGTH_LONG).show();


        Button button = (Button) findViewById(R.id.button11);
        ColorDrawable buttonColor = (ColorDrawable) button.getBackground();

        int colorId = buttonColor.getColor();

        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        preferences.edit().putInt("color", colorId).apply();

    }

    public void black(View view) {
        Toast.makeText(getApplicationContext(), "WHITE COLOR", Toast.LENGTH_LONG).show();


        Button button = (Button) findViewById(R.id.button6);
        ColorDrawable buttonColor = (ColorDrawable) button.getBackground();

        int colorId = buttonColor.getColor();

        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        preferences.edit().putInt("color", colorId).apply();

    }

    public void purple(View view) {
        Toast.makeText(getApplicationContext(), "PURPLE COLOR", Toast.LENGTH_LONG).show();

        Button button = (Button) findViewById(R.id.button7);
        ColorDrawable buttonColor = (ColorDrawable) button.getBackground();

        int colorId = buttonColor.getColor();

        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        preferences.edit().putInt("color", colorId).apply();

    }

    public void grey(View view) {
        Toast.makeText(getApplicationContext(), "GREY COLOR", Toast.LENGTH_LONG).show();

        Button button = (Button) findViewById(R.id.button8);
        ColorDrawable buttonColor = (ColorDrawable) button.getBackground();

        int colorId = buttonColor.getColor();

        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        preferences.edit().putInt("color", colorId).apply();

    }

    public void darkgreen(View view) {
        Toast.makeText(getApplicationContext(), "BROWN COLOR", Toast.LENGTH_LONG).show();

        Button button = (Button) findViewById(R.id.button9);
        ColorDrawable buttonColor = (ColorDrawable) button.getBackground();

        int colorId = buttonColor.getColor();

        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        preferences.edit().putInt("color", colorId).apply();

    }

    public void yellow(View view) {
        Toast.makeText(getApplicationContext(), "YELLOW COLOR", Toast.LENGTH_LONG).show();

        Button button = (Button) findViewById(R.id.button10);
        ColorDrawable buttonColor = (ColorDrawable) button.getBackground();

        int colorId = buttonColor.getColor();

        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        preferences.edit().putInt("color", colorId).apply();

    }

    public void pink(View view) {
        Toast.makeText(getApplicationContext(), "LIGHT BROWN COLOR", Toast.LENGTH_LONG).show();

        Button button = (Button) findViewById(R.id.button11);
        ColorDrawable buttonColor = (ColorDrawable) button.getBackground();

        int colorId = buttonColor.getColor();

        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        preferences.edit().putInt("color", colorId).apply();

    }

}
