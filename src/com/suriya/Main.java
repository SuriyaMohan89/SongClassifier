package com.suriya;

import com.suriya.song_classifier.classifier.Classifier;
import com.suriya.song_classifier.classifier.SimpleWordClassifier;
import com.suriya.song_classifier.controller.SongClassifierSupervisor;
import com.suriya.song_classifier.entites.Rating;
import com.suriya.song_classifier.entites.Song;
import com.suriya.song_classifier.entites.SongNotFoundException;
import com.suriya.song_classifier.entites.UnableToSerializeException;
import com.suriya.song_classifier.song_provider.CleanSongProvider;
import com.suriya.song_classifier.song_provider.SongProvider;
import com.suriya.song_classifier.song_provider.ViolentSongProvider;
import com.suriya.song_classifier.song_serilaizer.FileSerializer;
import com.suriya.song_classifier.song_serilaizer.Serializer;

public class Main {

    public static void main(String[] args) {
        Classifier classifier = new SimpleWordClassifier();
        SongProvider cleanSong = new CleanSongProvider();
        SongProvider violentSong = new ViolentSongProvider();
        Serializer store = new FileSerializer();

        SongClassifierSupervisor expectedToBeGoodSongs = new SongClassifierSupervisor(cleanSong, store, classifier);
        SongClassifierSupervisor expectedToBeViolentSongs = new SongClassifierSupervisor(violentSong, store, classifier);

        try {
            for (int i = 0; i < 3; i++) {
                expectedToBeGoodSongs.classifyAndStoreRating(i);
            }
            for (int i = 3; i < 5; i++) {
                expectedToBeViolentSongs.classifyAndStoreRating(i);
            }
        }
        catch (SongNotFoundException songNotFound) {
            System.out.println("The song with ID " + songNotFound.getSongId() + "doesn't exist. The below is stack trace" );
            songNotFound.printStackTrace();
        }
        catch (UnableToSerializeException cantSerialize) {
            final Song song = cantSerialize.getSong();
            final Rating.Rate rating = cantSerialize.getRating();
            System.out.println("Unable to serialize the song with id " + song.getId() + "And Lyrics is " + song.getRawLyrics() + "The rating given was " + rating.name() + "And the stack trace is ");
            cantSerialize.printStackTrace();
        }
    }
}
