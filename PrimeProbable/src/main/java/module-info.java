module org.abondar.experimental.prime.propbable {

    requires org.abondar.experimental.prime;

    provides org.abondar.experimental.prime.PrimeChecker
            with org.abondar.experimental.prime.probable.PrimeProbable;
}