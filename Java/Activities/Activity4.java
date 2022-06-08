package activities;

import java.util.Arrays;

public class Activity4 {

    static void ascendingSort(int[] numArray)
    {
        int length_numArray = numArray.length;

        for(int i=1;i<length_numArray;i++)
        {
            int key = numArray[i];
            int j = i-1;
            while(j>=0 && key < numArray[j])
            {
                numArray[j+1] = numArray[j];
                --j;
            }
            numArray[j+1] = key;
        }
    }
    static void descendingSort(int[] numArray)
    {
        int length_numArray = numArray.length;

        for(int i=1;i<length_numArray;i++)
        {
            int key = numArray[i];
            int j = i-1;
            while(j>=0 && key > numArray[j])
            {
                numArray[j+1] = numArray[j];
                --j;
            }
            numArray[j+1] = key;
        }
    }
    public static void main(String[] args){
        int[] numArray = {10,11,2,4,20,14,7,30,50,41};
        System.out.println("Unsorted Array: " + Arrays.toString(numArray));
        ascendingSort(numArray);
        System.out.println("Sorted Array in Ascending order: " + Arrays.toString(numArray));
        descendingSort(numArray);
        System.out.println("Sorted Array in Descending order: " + Arrays.toString(numArray));
    }
}
