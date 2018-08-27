package com.suriya.song_classifier.entites;

import java.util.List;

public class Rating {
    public enum ExplicitContent {
        SEXUAL_CONTENT,
        VIOLENCE,
        BLOOD_AND_GORY,
        DRUG_AND_ALCOHOL,
    }
    // There need not be 1 to 1 mapping between Enum.ExplicitContent to Enum.Rate, but for now, for PoC
    // I am having it as 1-1.
    public enum Rate {
        X, // Sexual content
        V, // Violence
        D, // Drug Abuse
        C  // Clean
    }

    private final Song song;
    private final List<ExplicitContent> allExplicitContents;
    private final Rate rating;

    public Rating(final Song song, final List<ExplicitContent> allExplicitContents) {
        this.song = song;
        this.allExplicitContents = allExplicitContents;
        this.rating = this.computeFinalRating();
    }

    public final Song getSong() {
        return song;
    }

    public final Rate getRating() {
        return rating;
    }

    private final Rate computeFinalRating() {
        if(allExplicitContents.contains(ExplicitContent.SEXUAL_CONTENT)) {
            return Rate.X;
        }
        if(allExplicitContents.contains(ExplicitContent.BLOOD_AND_GORY)) {
            return Rate.V;
        }
        if(allExplicitContents.contains(ExplicitContent.VIOLENCE)) {
            return Rate.V;
        }
        if(allExplicitContents.contains(ExplicitContent.DRUG_AND_ALCOHOL)) {
            return Rate.D;
        }
        // No explicit content, its clean.
        return Rate.C;
    }
}
