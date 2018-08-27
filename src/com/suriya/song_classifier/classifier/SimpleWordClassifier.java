package com.suriya.song_classifier.classifier;

import com.suriya.song_classifier.classifier.Classifier;
import com.suriya.song_classifier.entites.Rating;
import com.suriya.song_classifier.entites.Song;

import java.util.*;
import java.util.List;

public  class SimpleWordClassifier implements Classifier {
    private final static List<String>  violenceWordList = new ArrayList<>();
    private final static List<String> sexualContentWordList = new ArrayList<>();
    private final static List<String> drugAlcoholWordList = new ArrayList<>();
    static {
        violenceWordList.addAll(Arrays.asList("flesh","blood","kill","fight"));
        sexualContentWordList.addAll(Arrays.asList("ass","fuck","bitch","asshole","shit","dick","shitass"));
        drugAlcoholWordList.addAll(Arrays.asList("illicit", "illegal", "abuse", "misuse", "addiction", "addict"));
    }



    @Override
    public final List<Rating.ExplicitContent> classifyAndRate(Song songToRate) {
        String [] lyricsAsWord = songToRate.getRawLyrics().split("\\s+");
        List<Rating.ExplicitContent> allExplicitContentList = new LinkedList<>();
        for (String word: lyricsAsWord) {
            if (violenceWordList.contains(word)){
                allExplicitContentList.add(Rating.ExplicitContent.VIOLENCE);
            }
            else if (sexualContentWordList.contains(word)){
                allExplicitContentList.add(Rating.ExplicitContent.SEXUAL_CONTENT);
            }
            else if (drugAlcoholWordList.contains(word)){
                allExplicitContentList.add(Rating.ExplicitContent.DRUG_AND_ALCOHOL);
            }
        }
        return allExplicitContentList;
    }
}
