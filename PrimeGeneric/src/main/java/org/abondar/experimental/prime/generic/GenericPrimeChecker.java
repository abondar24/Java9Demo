package org.abondar.experimental.prime.generic;

import org.abondar.experimental.prime.PrimeChecker;

public class GenericPrimeChecker implements PrimeChecker {

    private static final String PROVIDER_NAME = "org.abondar.experimental.prime.generic";

    @Override
    public String getName() {

        return PROVIDER_NAME;
    }

    @Override
    public Boolean isPrime(Long n) {

        if (n <= 1) {
            return false;
        }


        if (n == 2) {
            return true;
        }

        if (n % 2 == 0) {
            return false;
        }

        for (long i = 3; i < n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
