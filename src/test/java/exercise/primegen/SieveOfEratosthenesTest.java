package exercise.primegen;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exercise.primegen.algorithm.SieveOfEratosthenes;

public class SieveOfEratosthenesTest {

	private int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };

	@Test
	public void test() {

		boolean[] primeSieve = new SieveOfEratosthenes().getSieve(101);

		for (int p : primes) {
			assertTrue(primeSieve[p]);
		}

		assertFalse(primeSieve[0]);
		assertFalse(primeSieve[1]);
		assertFalse(primeSieve[4]);
		assertFalse(primeSieve[6]);
		assertFalse(primeSieve[8]);
		assertFalse(primeSieve[10]);
	}
}
