# SongClassifier
Extendible Skeleton to classify a song (the same way we classify movies).

## OVERVIEW

This program helps classify a song based on the content of the song whether it has Explicit content (labels given based on Sexual,
Violence, Drug and Alcohol Abusive or other kind of content) or labelling it as a Clean song.

## CONTROL FLOW 
Instead of a linear assembly chain process, I implemented a flexible demand-supply chain design process. This design pattern offers
flexibility by provisioning to extend features in large scale. I have built this project keeping in mind
to use all object oriented principles I have learnt so far in Java. 

Let me explain components and entities I have used to implement my design.

## SONG PROVIDER [Entity: Song]

This component takes in a song Id as a input returns song lyrics. There are many ways like URL provider, Binary In memory 
provider to facilitate but for demo purpose am using a mock provider. My interface Song Provider suffices the method to get 
the lyrics irrespective of the provider am using. I have created classes like Clean Song Provider, Violent song provider for examples.
Song class is encapsulated into song provider and helps create song object.

## SONG CLASSIFIER [Entity : Rating]

when a song object is passed on a Rating class, rate as a string is returned. This class is encapsulated within classifier class. 
Now in a classifier component, there are many ways to classify a song like using algorithms like Markov chain or a sentiment analysis algorithm
but for demo purpose I have used simple word classifier which returns rate X, V, D or Clean based on the content in song lyrics.

SONG SERIALIZER 

This component helps the song object with the rating to store in a file system or a database or a Hadoop FDS. For POC, I have implemented 
store method to store in file system with prefix hadoop_<songid>. 

TO-DO
Writing tests is on progress.




