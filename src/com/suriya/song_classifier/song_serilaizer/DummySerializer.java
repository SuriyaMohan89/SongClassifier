package com.suriya.song_classifier.song_serilaizer;

import com.suriya.song_classifier.entites.Rating;

public class DummySerializer implements Serializer {
    @Override
    public void store(final Rating rating) {
        // Dummy impl, may be stdout/log ?
    }
}
