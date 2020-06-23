package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.project.segunfrancis.displayjokes.JokesActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        EndPointsAsync endPointsAsyncTask = new EndPointsAsync(new OnEventListener<String>() {
            @Override
            public void onSuccess(String object) {
                final Intent intent = new Intent(MainActivity.this, JokesActivity.class);
                intent.putExtra("main_joke_intent", object);
                startActivity(intent);
            }

            @Override
            public void onFailure(Exception e) {
                Log.e("MainActivity", e.getLocalizedMessage(), e);
            }
        });
        endPointsAsyncTask.execute();
    }
}
