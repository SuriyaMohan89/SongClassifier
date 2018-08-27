package com.suriya.song_classifier.entites;

public class SongNotFoundException extends Exception {
    private final long songId;

    public SongNotFoundException(Throwable cause, long songId) {
        super(cause);
        this.songId = songId;
    }

    public SongNotFoundException(long songId) {
        this.songId = songId;
    }

    public long getSongId() {
        return songId;
    }

    @Override
    public String toString() {
        return "SongNotFoundException{" +
                "songId=" + songId +
                "message=" + getMessage() +
                '}';
    }
}
