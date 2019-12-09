package com.example.quiknews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Button searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, ResultsActivity.class);
                EditText searchBar = (EditText) findViewById(R.id.searchBar);
                String search = searchBar.getText().toString();
                intent.putExtra("search", search);
                startActivity(intent);
            }
        });

        // when launching the results activity, create an intent that lets the user access the
    }
}
