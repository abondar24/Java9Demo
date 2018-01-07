package org.abondar.experimental.collectionsdemo;

import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {
        Set<Integer> empty = Set.of();
        Set<Integer> myNumber = Set.of(24);
        Set<String> vowels = Set.of("S","A","L","O");

        System.out.println("Empty set: "+empty);
        System.out.println("Singleton set: "+myNumber);
        System.out.println("Vowels: "+vowels);

        try {
            Set<Integer> nullSet = Set.of(1,null);
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
