package org.abondar.experimental.collectionsdemo;

import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
        List<Integer> empty = List.of();
        List<Integer> myNumber = List.of(24);
        List<String> vowels = List.of("S","A","L","O");

        System.out.println("Empty list: "+empty);
        System.out.println("Singleton list: "+myNumber);
        System.out.println("Vowels: "+vowels);

        try {
            List<Integer> nullList = List.of(1,null);
        } catch (NullPointerException ex){
            System.out.println("Null value not allowed");
        }

        try {
            myNumber.add(7);
        } catch (UnsupportedOperationException ex){
            System.out.println("Can't add an element");
        }

        try {
            myNumber.remove(0);
        } catch (UnsupportedOperationException ex){
            System.out.println("Can't remove an element");
        }
    }
}
