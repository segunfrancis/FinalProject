package com.project.segunfrancis.displayjokes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);

        TextView jokeText = findViewById(R.id.joke_textView);
        Intent intent = getIntent();
        jokeText.setText(intent.getStringExtra("main_joke_intent"));
    }
}
