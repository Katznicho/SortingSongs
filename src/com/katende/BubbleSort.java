package com.katende;

public class BubbleSort {

    public void Sort(Song[] array){
        for(var i=0 ;i<=array.length;i++ ){//looping through the song array
            for(var j=1;j<array.length-i; j++){// check each song at  certain position
                if(array[j] .getViews()< array[j-1].getViews()){//check songs using there views
                    swap(array ,j , j-1);//swap songs if the views are in certain position are less the views in some other position
                }
            }
        }
    }
    private  void  swap(Song[] array , int indexOne , int indexTwo ){
        var temp = array[indexOne];
        array[indexOne] =  array[indexTwo];
        array[indexTwo] = temp;

    }
}
