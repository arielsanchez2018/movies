package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import android.widget.ImageView;

//import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class details extends AppCompatActivity {
    public static final String IMDB = "com.example.movies.IMDB";
    private String poster = null;
    public static final String POSTER = "com.example.movies.POSTER";
    public static final String MOVIE = "com.example.movies.MOVIE";

    private Button sign_out3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        final String imdb = intent.getStringExtra(main_menu.IMDB); //get imdb from selected movie
        //set up variables for textviews
        final TextView Movie_content = (TextView) findViewById(R.id.movie_content);
        final TextView Title_content = (TextView) findViewById(R.id.Title_content);

        final ImageView  movie_poster = findViewById(R.id.movie_poster);

        sign_out3= (Button) findViewById(R.id.menu_signout2);

        sign_out3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openhomescreen3();
        }
    });

        //make the 2nd API CALL based on imdb code
        // Get a RequestQueue
        RequestQueue queue = MySingleton.getInstance(details.this.getApplicationContext()).
                getRequestQueue();
        String url = "http://www.omdbapi.com/?i=" + imdb + "&apikey=b347b14b";

        //Toast.makeText(details.this, "  imdb " + imdb + " ", Toast.LENGTH_LONG).show();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        String title = null;
                        // String imdb = null;
                        String year = null;
                        String genre = null;
                        String plot = null;


                        try {
                            title = response.getString("Title");
                            year = response.getString("Year");
                            genre = response.getString("Genre");
                            plot = response.getString("Plot");
                            poster = response.getString("Poster");

                            Title_content.setText(title);

                            String detailsString = "Year: " + year + "\n" +
                                    "Genre: " + genre + "\n" +
                                    "Plot: " + plot;
                            Movie_content.setText(detailsString);

                            Picasso.get().load(poster).into(movie_poster);

                            //Toast.makeText(details.this,detailsString, Toast.LENGTH_LONG).show();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //TODO: Handle error
                        //Toast.makeText(details.this, "Search Failed!", Toast.LENGTH_LONG).show();

                    }
                });

                 JsonObjectRequest r = jsonObjectRequest;
                queue.add(jsonObjectRequest);
}



    public void openhomescreen3()
    {
        Intent intent5 = new Intent(this, MainActivity.class);
        startActivity(intent5);
    }

}
