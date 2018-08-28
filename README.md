# SongClassifier
Content rate the song(only lyrics for now) the same way we content rate Movies.

## OVERVIEW

This program helps content rate a song(lyrics) based on the content of the song whether it has Explicit content (labels given based on Sexual, Violence, Drug and Alcohol Abusive or other kind of content). This is a backend only repo and aimed at extensibility rather than actual implementation. 

Will touchbase on different components within the system.

#### CONTROL FLOW / Controller
A centralized controller will take care of integrating different components with each other. This was chosen instead of a decentralized architecture, with the extensibility usecase into consideration. You can plug in different kind of song providers (url/database) and different classifiers and different storage into this centralized brian without affecting the flow of data and control within the application itself.

#### SONG PROVIDER [EncapsulatedObject it uses: Song]

This component takes in a song Id as a input returns song lyrics. There are many implementations possible like URL provider, database provider but for the PoC/prototyping, I've used a mock provider. Clean Song Provider, Violent song provider extends MockSongProvider and will act as test ground.

#### SONG CLASSIFIER [EncapsulatedObject it uses : Rating]

The song classifier will accept Song object as input and will return all the explicit contents it finds in the decreasing rank order. The Rate class is constructed out of it, and the rate class is responsible for inspecting all the explicit contents and give the actual rating (it acts as some sort of MotionPicture Censor authority). 
Again, the song classifier can be extended, but I've implemented a simple song classifier with a direct mapping between words to explicit content. 

TODO: Planning on doing a little more sophisticated Markhov-Chain classifier.

#### SONG SERIALIZER 

This component helps the song object with the rating to store in a file system or a database or a Hadoop HFDS. For POC, I have implemented store method to store in file system

## Entity relationship diagram
https://github.com/SuriyaMohan89/SongClassifier/blob/master/SongClassifier.jpeg

![erd](https://user-images.githubusercontent.com/36581704/44742381-92e33880-aab4-11e8-955d-bdbffc84f195.jpeg)


##### TO-DO
Unit tests in progress.




