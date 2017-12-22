package org.abondar.experimental.prime;

import java.util.ServiceLoader;

public interface PrimeChecker {

    String getName();

    Boolean isPrime(Long n);

    static PrimeChecker newInstance() throws RuntimeException {
        return ServiceLoader.load(PrimeChecker.class)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No prime checker service found"));
    }

    static PrimeChecker newInstance(String providerName) {
        ServiceLoader<PrimeChecker> loader = ServiceLoader.load(PrimeChecker.class);

        for (PrimeChecker checker : loader) {
            if (checker.getName().equals(providerName)){
                return checker;
            }

        }

        throw new RuntimeException("A PrimeChecker service provider with name: "+providerName+" not found!");
    }


}
