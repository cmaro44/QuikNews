package com.example.quiknews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        String search = getIntent().getStringExtra("search");

        // web request
        final TextView textView = (TextView) findViewById(R.id.text);
// ...

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://gnews.io/api/v3/search?q=" + search + "&max=5&token=8864c7a2c33d0d4f6224fdb35dd4d1f1";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray articles = response.getJSONArray("articles");
                            LinearLayout articleList = findViewById(R.id.articleList);
                            final String title = articles.getJSONObject(0).getString("title");
                            final String url = articles.getJSONObject(0).getString("url");
                            final String title2 = articles.getJSONObject(1).getString("title");
                            final String url2 = articles.getJSONObject(1).getString("url");
                            final String title3 = articles.getJSONObject(2).getString("title");
                            final String url3 = articles.getJSONObject(2).getString("url");
                            final String title4 = articles.getJSONObject(3).getString("title");
                            final String url4 = articles.getJSONObject(3).getString("url");
                            final String title5 = articles.getJSONObject(4).getString("title");
                            final String url5 = articles.getJSONObject(4).getString("url");
                            View articleChunk = getLayoutInflater().inflate(R.layout.chunk_article, articleList, false);
                            TextView articleTitle = articleChunk.findViewById(R.id.title);
                            articleTitle.setText(title);
                            TextView articleTitle2 = articleChunk.findViewById(R.id.title2);
                            articleTitle2.setText(title2);
                            TextView articleTitle3 = articleChunk.findViewById(R.id.title3);
                            articleTitle3.setText(title3);
                            TextView articleTitle4 = articleChunk.findViewById(R.id.title4);
                            articleTitle4.setText(title4);
                            TextView articleTitle5 = articleChunk.findViewById(R.id.title5);
                            articleTitle5.setText(title5);
                            Button visitButton = articleChunk.findViewById(R.id.visitButton);
                            visitButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent i = new Intent(Intent.ACTION_VIEW);
                                    i.setData(Uri.parse(url));
                                    startActivity(i);
                                }
                            });
                            Button visitButton2 = articleChunk.findViewById(R.id.visitButton2);
                            visitButton2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent i = new Intent(Intent.ACTION_VIEW);
                                    i.setData(Uri.parse(url2));
                                    startActivity(i);
                                }
                            });
                            Button visitButton3 = articleChunk.findViewById(R.id.visitButton3);
                            visitButton3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent i = new Intent(Intent.ACTION_VIEW);
                                    i.setData(Uri.parse(url3));
                                    startActivity(i);
                                }
                            });
                            Button visitButton4 = articleChunk.findViewById(R.id.visitButton4);
                            visitButton4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent i = new Intent(Intent.ACTION_VIEW);
                                    i.setData(Uri.parse(url4));
                                    startActivity(i);
                                }
                            });
                            Button visitButton5 = articleChunk.findViewById(R.id.visitButton5);
                            visitButton5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent i = new Intent(Intent.ACTION_VIEW);
                                    i.setData(Uri.parse(url5));
                                    startActivity(i);
                                }
                            });
                            articleList.addView(articleChunk);

                        } catch (JSONException e) {
                            Log.e("QuikNews", "JSON exception", e);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

// Access the RequestQueue through your singleton class.
        queue.add(jsonObjectRequest);


        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultsActivity.this, SearchActivity.class));
            }
        });

        //launching this activity sends a GET request with the search keyword from the intent and returns a response that contains the articles related to the keyword
        //then, the linear layout called article list is inflated with the articleChunk.
    }
}
