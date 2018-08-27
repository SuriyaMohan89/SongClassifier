package com.suriya.song_classifier.entites;

import com.suriya.song_classifier.entites.Rating;

public class UnableToSerializeException extends Exception {
    private final Rating songRating;

    public UnableToSerializeException(Throwable cause, Rating songRating) {
        super(cause);
        this.songRating = songRating;
    }

    public final Song getSong() {
        return songRating.getSong();
    }

    public final Rating.Rate getRating() {
        return songRating.getRating();
    }

    @Override
    public String toString() {
        return "UnableToSerializeException{" +
                "songRating=" + songRating +
                "message= "+ getMessage()+
                '}';
    }
}
