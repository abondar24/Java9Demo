package org.abondar.experimental.prime.fast;

import org.abondar.experimental.prime.PrimeChecker;

public class FastPrimeChecker implements PrimeChecker {


    private static final String PROVIDER_NAME = "org.abondar.experimental.prime.fast";

    private FastPrimeChecker() {
    }

    public static PrimeChecker provider() {
        return new FastPrimeChecker();
    }

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

        long limit = (long) Math.sqrt(n);
        for (long i = 3; i < limit; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
