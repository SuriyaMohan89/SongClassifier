package com.suriya.song_classifier.controller;

import com.suriya.song_classifier.classifier.Classifier;
import com.suriya.song_classifier.entites.Rating;
import com.suriya.song_classifier.entites.Song;
import com.suriya.song_classifier.entites.SongNotFoundException;
import com.suriya.song_classifier.entites.UnableToSerializeException;
import com.suriya.song_classifier.song_provider.SongProvider;
import com.suriya.song_classifier.song_serilaizer.Serializer;

public class SongClassifierSupervisor {
    private final SongProvider provider;
    private final Serializer serializer;
    private final Classifier classifier;

    public SongClassifierSupervisor(final SongProvider provider, final Serializer serializer, final Classifier classifier) {
        this.provider = provider;
        this.serializer = serializer;
        this.classifier = classifier;
    }

    public void classifyAndStoreRating(long songId) throws SongNotFoundException, UnableToSerializeException {
        Song song = new Song(id, provider.getLyrics(id));
        Rating rating = new Rating(song, classifier.classifyAndRate(song));
        serializer.store(rating);
    }
}
