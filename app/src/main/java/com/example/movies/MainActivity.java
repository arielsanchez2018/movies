package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.movies.EXTRA_TEXT";
    private EditText username, password;

    private Button log;
    private Button sign_up;
    /*
        private RequestQueue requestQueue;
        private static final String URL = "http://localhost/project/user_control.php";   // where all the php files to try to connect to phpmyadmin database
        private StringRequest request;
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        username= (EditText) findViewById(R.id.User);

        sign_up = (Button) findViewById(R.id.sign_up);

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensignin();
            }
        });

        log = (Button) findViewById(R.id.log_in);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmain_menu();
            }
        });
    }
        public void openmain_menu()
        {
            String text = username.getText().toString();  //variable to pass variable to main_menu

            Intent intent2 = new Intent(this, main_menu.class);
            intent2.putExtra(EXTRA_TEXT,text);
            startActivity(intent2);
        }

            public void opensignin()
            {
            Intent intent5 = new Intent(this, sign_in.class);
            startActivity(intent5);
            }

}


