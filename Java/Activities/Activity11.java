package activities;


import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args){
        HashMap<Integer,String> colours = new HashMap<>();
        colours.put(0,"White");
        colours.put(1,"Black");
        colours.put(2,"Green");
        colours.put(3,"Red");
        colours.put(4,"Blue");

        System.out.println("Original HashMap: " + colours);
        System.out.println("Number of pairs in the map is " + colours.size());

        colours.remove(3);
        System.out.println("After removing the value with key 3 " + colours);

        System.out.println("Does Green exists in the map? " + colours.containsValue("Green"));

        System.out.println("Number of pairs in the map is: " + colours.size());
    }
}
