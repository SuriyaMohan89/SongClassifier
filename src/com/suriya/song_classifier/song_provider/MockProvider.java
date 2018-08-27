package com.suriya.song_classifier.song_provider;

import com.suriya.song_classifier.entites.SongNotFoundException;

public abstract class MockProvider implements SongProvider {

    @Override
    public final String getLyrics(final long id) throws SongNotFoundException {
        final String lyrics = this.getLyricsForId(id);
        if (lyrics == null || lyrics.isEmpty()) {
            throw new SongNotFoundException(id);
        }
        return lyrics;
    }

    protected abstract String getLyricsForId(final long id);
}
