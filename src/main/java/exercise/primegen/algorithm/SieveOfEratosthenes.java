package exercise.primegen.algorithm;

/**
 * 
 * http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 * 
 * Initiate an array of booleans indicating if the index is a prime number or
 * not:
 * 
 * Input: an integer n > 1
 * 
 * Let A be an array of Boolean values, indexed by integers 2 to n, initially
 * all set to true.
 * 
 * for i = 2, 3, 4, ..., not exceeding √n: if A[i] is true: for j = i2, i2+i,
 * i2+2i, i2+3i, ..., not exceeding n : A[j] := false
 * 
 * Output: all i such that A[i] is true.
 * 
 */
public class SieveOfEratosthenes {

	public boolean[] getSieve(int upperBound) {

		// Let A be an array of Boolean values, indexed by integers 2 to n,
		boolean[] A = new boolean[upperBound + 1];

		// initially all set to true.
		for (int i = 2; i <= upperBound; i++) {
			A[i] = true;
		}

		// for i = 2, 3, 4, ..., not exceeding √n:
		// It is probably faster to do i*i<N but for a large i that will create
		// problems, i.e. i*i > Integer.MAX_SIZE

		int sqrtValue = (int) Math.sqrt((double) upperBound);

		for (int i = 2; i <= sqrtValue; i++) {
			// if A[i] is true:
			if (A[i]) {
				// for j = i^2, i^2+i, i^2+2i, i^2+3i, ..., not exceeding n :
				for (int j = i * i; j <= upperBound; j += i) {
					// A[j] := false
					A[j] = false;
				}
			}

		}

		return A;
	}

}
