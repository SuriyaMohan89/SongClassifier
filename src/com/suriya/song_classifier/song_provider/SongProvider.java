package com.suriya.song_classifier.song_provider;

import com.suriya.song_classifier.entites.Song;
import com.suriya.song_classifier.entites.SongNotFoundException;

public interface SongProvider {
    public String getLyrics(final long id) throws SongNotFoundException;
}
