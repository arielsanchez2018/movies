package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class details extends AppCompatActivity {

    private Button sign_out3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

    sign_out3= (Button) findViewById(R.id.menu_signout2);
        sign_out3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openhomescreen3();
        }
    });
}
    public void openhomescreen3()
    {
        Intent intent5 = new Intent(this, MainActivity.class);
        startActivity(intent5);
    }

}
