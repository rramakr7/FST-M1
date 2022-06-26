package activities;

//ArrayList activity

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Activity9 {

    public static void main(String[] arg){
        List<String> myList = new ArrayList<>();
        myList.add("Ram");
        myList.add("Sita");
        myList.add("Lakshman");
        myList.add("Luv");
        myList.add("Kush");

        for(int i=0;i<myList.size();i++) {
            System.out.println(myList.get(i));
        }

        System.out.println("3rd element in the ArrayList is " + myList.get(2));

        System.out.println("Is Hanuman is in the list? " + myList.contains("Hanuman"));

        System.out.println("Size of ArrayList is " + myList.size());

        myList.remove("Lakshman");

        System.out.println("New size of ArrayList is " + myList.size());


    }
}
