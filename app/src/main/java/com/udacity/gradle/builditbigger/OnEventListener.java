package com.udacity.gradle.builditbigger;

/**
 * Created by SegunFrancis
 */

public interface OnEventListener<T> {
    void onSuccess(T object);
    void onFailure(Exception e);
}
