package org.abondar.experimental.prime.client;

import org.abondar.experimental.prime.PrimeChecker;

public class Main {
    public static void main(String[] args) {
        long [] numbers = {3,4,121,777};

        try {

            PrimeChecker checker = PrimeChecker.newInstance("org.abondar.experimental.prime.generic");
            checkPrimes(checker,numbers);

            checker = PrimeChecker.newInstance("org.abondar.experimental.prime.fast");
            checkPrimes(checker,numbers);

            checker = PrimeChecker.newInstance("org.abondar.experimental.prime.probable");
            checkPrimes(checker,numbers);


        } catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }

    }


    private static void checkPrimes(PrimeChecker checker,long[] numbers){
        System.out.println("Using checker: "+checker.getName());

        for (long n: numbers){
            System.out.println("Number "+n+" is prime: "+checker.isPrime(n));
        }
    }
}
