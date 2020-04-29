package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sign_in extends AppCompatActivity {

    private Button create_account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        create_account= (Button) findViewById(R.id.sign_create);
        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhomescreen2();
            }
        });
    }
    public void openhomescreen2()
    {
        Intent intent4 = new Intent(this, MainActivity.class);
        startActivity(intent4);
    }

}
