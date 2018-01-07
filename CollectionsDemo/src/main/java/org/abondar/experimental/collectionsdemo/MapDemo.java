package org.abondar.experimental.collectionsdemo;

import java.util.Map;
import static java.util.Map.entry;

public class MapDemo {

    public static void main(String[] args) {
        Map<Integer, String> empty = Map.of();
        Map<Integer, String> myNumber = Map.of(24, "Horovats");
        Map<Integer, String> vowels = Map.of(4, "S", 2, "A", 11, "L", 34, "O");
        Map<String, String> days = Map.ofEntries(entry("Mon", "Monday"),
                entry("Tue", "Tuesday"));

        System.out.println("Empty map: " + empty);
        System.out.println("Singleton map: " + myNumber);
        System.out.println("Vowels: " + vowels);
        System.out.println("Days: " + days);

        try {
            Map<Integer,String> nullMap = Map.of(1, null);
        } catch (NullPointerException ex) {
            System.out.println("Null value not allowed");
        }

        try {
            Map<Integer,String> dupMap = Map.of(1,"S",1,"F");
        } catch (IllegalArgumentException ex){
            System.out.println("Duplicate keys not allowed");
        }

        try {
            myNumber.put(7,"Salo");
        } catch (UnsupportedOperationException ex) {
            System.out.println("Can't add an element");
        }

        try {
            myNumber.remove(0);
        } catch (UnsupportedOperationException ex) {
            System.out.println("Can't remove an element");
        }
    }
}
