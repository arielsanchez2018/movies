package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button log_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        button= (Button) findViewById(R.id.sign_up);
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openactivity_sign_in();
        }
    });

        log_in= (Button) findViewById(R.id.log_in);
        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmain_menu();
            }
        });

}

    public void openactivity_sign_in()
    {
        Intent intent = new Intent(this, sign_in.class);
        startActivity(intent);
    }


    public void openmain_menu()
    {
        Intent intent2 = new Intent(this, main_menu.class);
        startActivity(intent2);
    }
}
