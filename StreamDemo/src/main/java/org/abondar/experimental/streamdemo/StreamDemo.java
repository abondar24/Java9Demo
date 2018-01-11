package org.abondar.experimental.streamdemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        System.out.println("Using dropWhile() and takeWhile():");
        dropWhileAndtakeWhileDemo();

        System.out.println("Using ofNullable():");
        ofNullableDemo();

        System.out.println("Using iterator()");
        iteratorDemo();
    }

    private static void dropWhileAndtakeWhileDemo() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("Original List: " + list);

        List<Integer> list1 = list.stream()
                .dropWhile(n -> n % 2 == 1)
                .collect(Collectors.toList());
        System.out.println("After dropWhile(): " + list1);

        List<Integer> list2 = list.stream()
                .takeWhile(n -> n % 2 == 1)
                .collect(Collectors.toList());
        System.out.println("After takeWhile(): " + list2);

    }

    private static void ofNullableDemo() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, null);
        map.put(4, "Four");

        Set<String> nonNullVals = map.entrySet()
                .stream()
                .flatMap(e -> Stream.ofNullable(e.getValue()))
                .collect(Collectors.toSet());

        System.out.println("Map: " + map);
        System.out.println("Non-Null Values: " + nonNullVals);
    }

    private static void iteratorDemo() {
        List<Integer> list = Stream.iterate(1,n->n<=10,n->n+1)
                .collect(Collectors.toList());

        System.out.println("Integers from 1 to 10: "+list);
    }


}
