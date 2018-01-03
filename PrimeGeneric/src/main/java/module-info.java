module org.abondar.experimental.prime.generic {

    requires org.abondar.experimental.prime;

    provides org.abondar.experimental.prime.PrimeChecker
            with org.abondar.experimental.prime.generic.GenericPrimeChecker;

    exports org.abondar.experimental.prime.generic;
}