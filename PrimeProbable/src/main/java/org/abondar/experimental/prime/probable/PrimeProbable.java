package org.abondar.experimental.prime.probable;

import org.abondar.experimental.prime.PrimeChecker;

import java.math.BigInteger;

public interface PrimeProbable {

    static PrimeChecker provider(){
        final String  PROVIDER_NAME = "org.abondar.experimental.prime.probable";

        return new PrimeChecker() {
            @Override
            public String getName() {
                return PROVIDER_NAME;
            }

            @Override
            public Boolean isPrime(Long n) {
                return BigInteger.valueOf(n).isProbablePrime(1000);
            }
        };
    }
}
