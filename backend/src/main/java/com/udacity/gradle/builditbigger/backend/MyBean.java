package com.udacity.gradle.builditbigger.backend;

import com.project.segunfrancis.jokeslibrary.JokesSource;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public void setData(String data) {
        myData = data;
    }

    public String getData() {
        myData = JokesSource.getJoke();
        return myData;
    }
}