package com.suriya.song_classifier.classifier;

import com.suriya.song_classifier.entites.Rating;
import com.suriya.song_classifier.entites.Song;

import java.util.List;

public interface Classifier {
    public List<Rating.ExplicitContent> classifyAndRate(Song songToRate);
}
