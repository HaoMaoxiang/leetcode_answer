package No204_Count_Primes;

import java.util.Arrays;

public class Solution {
    public int countPrimes(int n) {
        if (n == 0 || n == 1) return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i; i * j < n; j++) {
                isPrime[i * j] = false;
            }
        }
        int res = 0;
        for (boolean is : isPrime) {
            if (is) res += 1;
        }
        return res;
    }
}
