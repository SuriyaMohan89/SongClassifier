package com.suriya.song_classifier.song_serilaizer;

import com.suriya.song_classifier.entites.Rating;
import com.suriya.song_classifier.entites.UnableToSerializeException;

import java.io.IOException;
import java.io.PrintWriter;

public class FileSerializer implements Serializer {

    @Override
    public void store(final Rating rating) throws UnableToSerializeException {
        long songId = rating.getSong().getId();
        String ratingAsString = rating.getRating().name();
        try(PrintWriter out = new PrintWriter(Long.toString(songId))) {
            out.write(ratingAsString);
        }
        catch (IOException ioe) {
            throw new UnableToSerializeException(ioe, rating);
        }
    }
}
