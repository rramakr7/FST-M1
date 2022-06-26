package activities;

//HashSet activity

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args){
        HashSet<String> hs = new HashSet<String>();
        hs.add("Apple");
        hs.add("Orange");
        hs.add("Grapes");
        hs.add("Water Melon");
        hs.add("Mango");
        hs.add("Papaya");


        System.out.println("Original HashSet: " + hs);
        System.out.println("Size of the HashSet is " + hs.size());

        System.out.println("Removing Grapes from the set " + hs.remove("Grapes"));
        if(hs.remove("Grapes"))
            System.out.println("Grapes is removed from the set");
        else
            System.out.println("Grapes is not present in the set");

        System.out.println("Is Banana added in the hashset? " + hs.contains("Banana"));

        System.out.println("New HashSet: " + hs);
    }
}
