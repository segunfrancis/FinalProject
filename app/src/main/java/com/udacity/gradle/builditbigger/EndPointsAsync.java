package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.project.segunfrancis.displayjokes.JokesActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by SegunFrancis
 */
public class EndPointsAsync extends AsyncTask<Context, Void, String> {
    private static MyApi myApi = null;
    private Context context;

    @Override
    protected String doInBackground(Context... contexts) {
        if (myApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApi = builder.build();
        }
        context = contexts[0];
        try {
            return myApi.getJokeService().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        final Intent intent = new Intent(context, JokesActivity.class);
        intent.putExtra("main_joke_intent", result);
        context.startActivity(intent);
    }
}
