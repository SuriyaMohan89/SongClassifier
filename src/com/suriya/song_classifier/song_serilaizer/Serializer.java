package com.suriya.song_classifier.song_serilaizer;

import com.suriya.song_classifier.entites.Rating;
import com.suriya.song_classifier.entites.UnableToSerializeException;

public interface Serializer {
    public void store(final Rating rating) throws UnableToSerializeException;
}
