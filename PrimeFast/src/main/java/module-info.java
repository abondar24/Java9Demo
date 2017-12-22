import org.abondar.experimental.prime.fast.FastPrimeChecker;

module org.abondar.experimental.prime.fast {
    requires org.abondar.experimental.prime;

    provides org.abondar.experimental.prime.PrimeChecker
            with FastPrimeChecker;
}