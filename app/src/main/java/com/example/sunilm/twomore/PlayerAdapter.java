package com.example.sunilm.twomore;

/**
 * Created by sunilm on 5/18/2019.
 */

public interface PlayerAdapter {

    void loadMedia(int resourceId);

    void release();

    boolean isPlaying();

    void play();

    void reset();

    void pause();

    void initializeProgressCallback();

    void seekTo(int position);
}