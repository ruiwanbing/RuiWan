 // find prime pair: https://www.geeksforgeeks.org/find-two-prime-numbers-with-given-sum/
 public void findAllPrimes(int n, boolean[] isPrime) {
 	isPrime[0] = isPrime[1] = false;
 	for (int i = 2; i < isPrime.length; i++) {
        isPrime[i] = true;
 	}
 	for (int p = 2; p * p <= n; p++) {
 		if (isPrime[p] == true) {
 			// multiple 2, multiple 3, multiple 4...
	 		for (int i = p * 2; i <= n; i = i + p) {
	 			isPrime[i] = false;
	 		}
 		}
 	}
 }
 public void findPrimePair(int n) {
 	// mark n in [0, n] as prime or not 
     boolean[] isPrime = new boolean[n + 1];
     findAllPrimes(n, isPrime);
     for (int i = 0; i < n; i++) {
     	if (isPrime[i] && isPrime[n - i]) {
     		System.out.println(i + " " + (n - i));
     		return; 
     	}
     }
 }

   public static void main (String[] args)
    {
        int n = 74;
        findPrimePair(n);
    }
