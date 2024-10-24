package demo.streamsbasics.problems.utils;

public class PrimeUtils {

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static int nextPrime(int currentPrime) {
        int next = currentPrime + 1;
        while (!isPrime(next)) {
            next++;
        }
        return next;
    }
}

