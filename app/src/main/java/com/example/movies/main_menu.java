package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class main_menu extends AppCompatActivity {

    private Button sign_out;
    private Button fav_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        sign_out= (Button) findViewById(R.id.menu_signout);
        sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhomescreen();
            }
        });


        fav_page= (Button) findViewById(R.id.button_fav);
        fav_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfavorites();
            }
        });

    }
    public void openhomescreen()
    {
        Intent intent3 = new Intent(this, MainActivity.class);
        startActivity(intent3);
    }
    public void openfavorites()
    {
        Intent intent6 = new Intent(this, Favorites.class);
        startActivity(intent6);
    }
}

