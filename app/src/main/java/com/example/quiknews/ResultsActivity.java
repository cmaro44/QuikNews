package com.example.quiknews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        String search = getIntent().getStringExtra("search");
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("This button closes this activity and launches the SearchActivity.");
            }
        });

        //launching this activity sends a GET request with the search keyword from the intent and returns a response that contains the articles related to the keyword
        //then, the linear layout called article list is inflated with the articleChunk.
    }
}
