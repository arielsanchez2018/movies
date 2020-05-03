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
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class main_menu extends AppCompatActivity {
    public static final String IMDB = "com.example.movies.IMDB";
    private Button sign_out2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);

        TextView user = (TextView) findViewById(R.id.textView7);

        user.setText("Hi " + text);

        sign_out2= (Button) findViewById(R.id.menu_signout);

        sign_out2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhomescreen3();
            }
        });
    }



    public void button(View v){

        //set up listview

        final Intent intent = new Intent(this, details.class);

        final ListView menu_list = (ListView) findViewById(R.id.menu_list);
        final ArrayList<String> arrayList = new ArrayList<>();


        RequestQueue queue = Volley.newRequestQueue(this);

        EditText ed1 = (EditText) findViewById(R.id.text_search);
        String searchSt = ed1.getText().toString();

        String url = "http://www.omdbapi.com/?s=" + searchSt + "&apikey=b347b14b";


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
                                    //Toast.makeText(main_menu.this, "clicked item " + position + " with imdb " + imdblist.get(position) + " " + titles.get(position), Toast.LENGTH_LONG).show();
                                    //go to movie details (details.java) and send the imdb code to make a 2nd API CALL from there
                                    //intent.putExtra(USER, userJSON); //also send USER
                                    intent.putExtra(IMDB, imdblist.get(position));
                                    startActivity(intent);
                                }
                            });


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        JsonObjectRequest r = jsonObjReq;
        queue.add(jsonObjReq);
    }

    public void openhomescreen3()
    {
        Intent intent5 = new Intent(this, MainActivity.class);
        startActivity(intent5);
    }


}

