/*
How the merge sort works
-------------------------------------------------
1. given an array that is to be sorted, copy eveything into an auxillary array
2. divide the auxillary array into two subarrays
3.The precodition is that these two sub arrays, each has been sorted
4.Compare the minimun in each subarray and the minimum element that exists is taken back to its original array.
5. Increment the subarray where the element has been taken from and as well increment j the original array.
6. If one subarray is exhausted, take from other.
6. this procedure is repeated until all the elements are taken back to the original array in sorted order.

 */

package com.katende;

public class MergeSort {
    private static Song [] aux;

    public static  void SortSongs(Song[] songsArray) {
        aux = new Song[songsArray.length];
        sort (songsArray,aux,0,songsArray.length-1);

    }

    private static void merge (Song[] array, Song[] aux, int lo , int mid, int hi){
        // k is our current entry on the sorted array
        for (int k=lo; k<=hi; k++)
            aux [k] = array[k] ; //copy everything from the original array into an auxillary array

        int i =lo , j= mid + 1; //i am the first part of our array and j is the second part of our array

        for (int k =lo ; k<=hi; k++){
            if (i>mid)                  aux[k] = array[j++]; //if i is exhausted, move over to the j element

            else if (j>hi)              aux[k] = array[i++]; // if j is exhausted, move over to the i element

            else if(aux[j].getViews() < aux[i].getViews())
                array[k] = aux[j++];     // compare the minimum in each sub array and if an element from j is less than
                // an element from i the element is taken back to its original array and sub array j with original array k are
                // both incremented.
            else
                array[k] = array[i++];// else an element from i will be less than an element from j hence element i taken back to its original array and sub array i with original array k are incremented.
        }

    }

    private static void sort (Song[]a, Song[]aux, int lo, int hi){
        //if the last element is equal to first element , then the array only has one element hence sorted.
        if (hi == lo )  return;

        //Calculating the middle element i.e the las element of the first half
        int mid = lo + (hi-lo)/2;

        sort(a, aux, lo, mid ); // Sort the first half
        sort(a, aux, mid+1, hi); // Sort the second half
        merge (a, aux, lo, mid, hi); //merge the halves together
    }





}

