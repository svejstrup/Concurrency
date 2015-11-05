public class CountPrimes {

    private static boolean isPrime(int n){
	int k = 2;
	while (k*k <= n && n % k != 0)
	    k ++;
	return n >=2 && k*k > n;
    }

    public static void main(String[] args){
	long count = 0;
	for(int i = 1; i<10000000; i++)
	    if(isPrime(i)) count++;
	System.out.println("Number of primes is 2: " + count);
    }
}
