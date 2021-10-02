package com.katende; /** This template was Developed by Benjamin Daaki (richarddaaki4@gmail.com) and Modified by Robert Kasumba (rkasumba@wustl.edu) */
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Load the song plays csv file into an array of songs
        Song[] songsArray = getAllSongs("C:/Users/hp/IdeaProjects/JAVA/src/com/katende/song_plays.csv");
        //ensure the song_plays.csv is in the same folder as this java file

        /** PUT THE CALL to sort or search here */
        /** The task is to sort or search through the array*/
        //System.out.println(Arrays.toString(songsArray));


        //Bubble sort
        var bubbleSort = new BubbleSort();
        bubbleSort.Sort(songsArray);
        System.out.println(songsArray);

        //merge sort
        var mergeSort = new MergeSort();
        mergeSort.SortSongs(songsArray);
        System.out.println(songsArray);


        //return songsArray;
    }


    private static Song[] getAllSongs(String fileName) {
        // An arraylist to conatain all the songs as instaces of the song object
        ArrayList<Song> allSongs = new ArrayList<Song>();
        // This will enable us skip the heading in the csv file.
        int skipHeading = 0;
        // File name make sure you use the right path.

        try (Scanner scanner = new Scanner(new File(fileName));) {
            while (scanner.hasNextLine()) {

                // Skip heading that's when the skipHeading variable is zero
                if (skipHeading == 0) {
                    scanner.nextLine();
                    skipHeading = 1;
                    continue;
                }

                // Temporary array to hold each song's data
                // song id will be index 0 and views index 1
                ArrayList<Integer> songDetails = getRecordFromLine(scanner.nextLine());

                // Create a song object using the song details
                Song song = new Song(songDetails.get(0), songDetails.get(1));

                // Push the song to the all songs arraylist
                // Then you are good to go!!!!!
                allSongs.add(song);
            }

        } catch (Exception e) {
            // Exception handling perhaps wrong file name
            System.out.println(e);
        }
        // Final songs array with size as all songs array list
        Song[] finalSongsArray = new Song[allSongs.size()];

        // Populate the final songs array and return it
        finalSongsArray = allSongs.toArray(finalSongsArray);
        return finalSongsArray;

    }

    // This function gets the song record
    private static ArrayList<Integer> getRecordFromLine(String line) {

        ArrayList<Integer> values = new ArrayList<Integer>();
        try (Scanner rowScanner = new Scanner(line)) {
            // Ofcourse these values are separated by commas
            rowScanner.useDelimiter(",");
            // Then get all the values
            while (rowScanner.hasNext()) {
                values.add(Integer.parseInt(rowScanner.next()));
            }
        }
        // return the values in an array.
        return values;
    }

}

class Song {
    private int id; // unique identifier of the song on mubali.net
    private int views; // number of times it has been played or viewed

    public Song(int songId, int numViews) {
        this.id = songId; // id must be non-negative but this requirement has not been enforced
        this.views = numViews; // views must be non-negative but this requirement has not been enforced
    }

    public int getId() {
        return this.id;
    }

    public int getViews() {
        return this.views;
    }
}
