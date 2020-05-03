package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class main_menu extends AppCompatActivity {
    public static final String IMDB = "com.example.movies.IMDB";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

    }



    public void button(View v){
       // view = v;
        //String cname = input.getText().toString();

        //set up listview

        final Intent intent = new Intent(this, details.class);

        final ListView menu_list = (ListView) findViewById(R.id.menu_list);
        final ArrayList<String> arrayList = new ArrayList<>();


        RequestQueue queue = Volley.newRequestQueue(this);
        /*String cname = "miami";
        String prefix = "https://api.openweathermap.org/data/2.5/weather?q=";
        String postfix = "&appid=64a794205221a09cec0b19f3b6743077&units=metric"; */

        EditText ed1 = (EditText) findViewById(R.id.text_search);
        String searchSt = ed1.getText().toString();

        //String url = prefix + cname + postfix;
        String url = "http://www.omdbapi.com/?s=" + searchSt + "&apikey=b347b14b";

        final TextView t = (TextView) findViewById(R.id.textView8);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        final ArrayList <String> titles = new ArrayList<>();
                        final ArrayList<String> imdblist = new ArrayList<String>(); // new array list for imdb
                        String title = null;
                        String imdb = null;

                        try {
                            JSONArray Jlist = response.getJSONArray("Search");

                            for (int i = 0; i < Jlist.length(); i++) { //traverses each result from search
                                title = Jlist.getJSONObject(i).getString("Title");
                                imdb = Jlist.getJSONObject(i).getString("imdbID");
                                imdblist.add(imdb);
                                titles.add(title); //add to list that will be displayed in ListView
                            }
                            // Add list to view
                            ArrayAdapter arrayAdapter = new ArrayAdapter(main_menu.this,android.R.layout.simple_list_item_1, titles);
                            menu_list.setAdapter(arrayAdapter);

                            //add event listener to each item in list
                            menu_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Toast.makeText(main_menu.this, "clicked item " + position + " with imdb " + imdblist.get(position) + " " + titles.get(position), Toast.LENGTH_LONG).show();
                                    //go to movie details (details.java) and send the imdb code to make a 2nd API CALL from there
                                    //intent.putExtra(USER, userJSON); //also send USER
                                    intent.putExtra(IMDB, imdblist.get(position));
                                    startActivity(intent);
                                }
                            });



                            /*JSONObject c = response.getJSONObject("coord");

                            //JSONObject main = response.getJSONObject("main");
                            String cn = response.getString("name");
                            String temp = main.getString("temp");
                            t.setText("The weather in " + cn + " is " + temp + "°C");
                            //String toSpeak = "The weather in " + cn + " is " + temp + " degrees celsius";
                            double lat = c.getDouble("lat");
                            double lon = c.getDouble("lon");
                            */

                            //Toast.makeText(main_menu.this, main.toString(), Toast.LENGTH_SHORT).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                t.setText("Error Obtaining Movies ");
            }
        });
        JsonObjectRequest r = jsonObjReq;
        queue.add(jsonObjReq);
    }

}

