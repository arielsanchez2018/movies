package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Favorites extends AppCompatActivity {

    private Button fav_signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        fav_signout= (Button) findViewById(R.id.menu_signout3);
        fav_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhomescreen4();
            }
        });
    }
    public void openhomescreen4()
    {
        Intent intent7 = new Intent(this, MainActivity.class);
        startActivity(intent7);
    }


}
