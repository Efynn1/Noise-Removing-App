/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DSA_Assignment2_Q2;

/**
 *1.Is quick sort the best way of finding median? Why? (3%)
 * Yes, because it splits the array down the middle, giving the median in the form of the pivot index
 * 
 2. What is another good way of finding median? Please provide your explanation. (3%)
 * Binary sort would also be good at finding the median due to its splitting the data in half at
 * every step finding the median of the data would be similar to quick sort.
 * 
 * @author flynn
 * @param <E>
 */
public class SortableArray<E extends Comparable> {


    /**
     * @param array the array to set
     */
    public void setArray(E[] array) {
        this.array = array;
        this.start = 0;
        this.end = array.length-1;
    }
    
    private E[] array;
    private int start;
    private int end;
    
    //pick pivot then sort left and right recursively until array is sorted
    public void quickSort(E[] array, int start, int end){
        if (start<end) { //more than one element to sort
            int pivotIndex = partition(array, start, end);
            // sort the segment to the left
            quickSort(array, start, pivotIndex);
            // sort the segment to the right
            quickSort(array, pivotIndex + 1, end);
        }
    }
    
    public int partition(E[] array, int start, int end){
        int pivotIndex = (start + end)/2;
        E pivotValue = array[pivotIndex];
        start--;
        end++;
        
        while (true) {
            // start at the FIRST index of the sub-array and increment
            // FORWARD until a value is > pivotValue
            do start++; while(array[start].compareTo(pivotValue) < 0);
            // start at the LAST index of the sub-array and increment
            // BACKWARD until a value is < pivotValue
            do end--; while(array[end].compareTo(pivotValue) > 0);
            
            //return pivot index for use in quickSort()
            if (start >= end){
                return end;
            }
            
            //switch end and start values
            E temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
    }
}
