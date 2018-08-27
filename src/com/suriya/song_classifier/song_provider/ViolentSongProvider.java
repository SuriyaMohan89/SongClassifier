package com.suriya.song_classifier.song_provider;

import java.util.HashMap;
import java.util.Map;

public class ViolentSongProvider extends MockProvider {
    private static Map<Long, String> violentSongIdToLyrics = new HashMap<Long, String>();
    static  {
        violentSongIdToLyrics.put((long) 3, "okay let's start Hit it, Kill it, fight fight fight yeah");
        violentSongIdToLyrics.put((long) 4, "Flesh and blood, I'm a rag 'n' bone Bad luck message on the telephone");
    }

    @Override
    protected final String getLyricsForId(long id) {
        return ViolentSongProvider.violentSongIdToLyrics.get(id);
    }
}
