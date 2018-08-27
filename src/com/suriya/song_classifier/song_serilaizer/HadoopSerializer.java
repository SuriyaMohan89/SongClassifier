package com.suriya.song_classifier.song_serilaizer;

import com.suriya.song_classifier.entites.Rating;
import com.suriya.song_classifier.entites.UnableToSerializeException;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * For the PoC, this class will just store in the normal file system with prefix hadoop_<song_id>
 * In the future, this will actually store into HDFS.
 */
public class HadoopSerializer implements Serializer {

    private static String FILE_PREFIX = "hadoop_";

    @Override
    public void store(final Rating rating) throws UnableToSerializeException {
        long songId = rating.getSong().getId();
        String ratingAsString = rating.getRating().name();
        try(PrintWriter out = new PrintWriter(HadoopSerializer.FILE_PREFIX + Long.toString(songId))) {
            out.write(ratingAsString);
        }
        catch (IOException ioe) {
            throw new UnableToSerializeException(ioe, rating);
        }
    }
}
