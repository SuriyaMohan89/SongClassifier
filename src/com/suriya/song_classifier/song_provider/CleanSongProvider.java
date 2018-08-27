package com.suriya.song_classifier.song_provider;

import com.suriya.song_classifier.entites.Song;

import java.util.HashMap;
import java.util.Map;

public class CleanSongProvider extends MockProvider {
    private static Map<Long, String> cleanSongIdToLyrics = new HashMap<Long, String>();
    static  {
        cleanSongIdToLyrics.put((long) 1, "O say can you see! By the dawn's early light. ");
        cleanSongIdToLyrics.put((long) 2, "Wakka Wakka hey hey, This time for Africa.");
        cleanSongIdToLyrics.put((long) 3, "This isn't over. Tonight is the night. Bring your hands up, like the ceiling can't hold us");
    }

    @Override
    protected final String getLyricsForId(long id) {
        return CleanSongProvider.cleanSongIdToLyrics.get(id);
    }
}
