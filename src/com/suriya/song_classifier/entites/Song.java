package com.suriya.song_classifier.entites;

import java.util.Objects;

public class Song {
    private final long id;
    private final String rawLyrics;

    public Song(long id, String rawLyrics) {
        this.id = id;
        this.rawLyrics = rawLyrics;
    }

    public final long getId() {
        return id;
    }

    public final String getRawLyrics() {
        return rawLyrics;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Song thatSong = (Song) that;
        return this.getRawLyrics().equalsIgnoreCase(thatSong.getRawLyrics());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRawLyrics().toLowerCase());
    }
}
