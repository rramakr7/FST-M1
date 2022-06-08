package activities;

//Activity 2
//In this activity, we are writing a program to check if the sum of all the 10's in the array is exactly 30

import java.util.Arrays;

public class Activity2 {
    public static void main(String[] args){
        int[] numArray = {10,77,10,54,-11,10};
        System.out.println("Original Array: " + Arrays.toString(numArray));

        int searchNum = 10;
        int fixedSum = 30;

        System.out.println("Result: " + result(numArray,searchNum,fixedSum));

    }
    public static boolean result(int[] numbers,int searchNum, int fixedSum){
        int tempSum = 0;
        for(int num:numbers){
            if(num==searchNum)
                tempSum += searchNum;
            if(tempSum>fixedSum)
                break;
        }
        return tempSum==fixedSum;
    }
}
