package org.abondar.experimental.person;

public class Main {
    public static void main(String[] args) {

        Person person = new Person(1112L,"Vasya","Pupkin");

        System.out.println(person.getFirstName());
        System.out.println(person.getLastName());
        System.out.println(person.getAddress().toString());
    }
}
