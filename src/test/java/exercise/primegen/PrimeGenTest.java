package exercise.primegen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import exercise.primegen.algorithm.SieveOfEratosthenes;

public class PrimeGenTest {

	private int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };

	@Test
	public void testGenerateRange() {
		// Create a new Prime generator with some algorithm
		PrimeGen pg = new PrimeGen();

		// Generate a range inclusive endpoints, first 26 primes
		List<Integer> primeList = pg.generate(2, 101);

		assertEquals(primes.length, primeList.size());

		int i = 0;
		for (Integer prime : primeList) {
			assertEquals(primes[i++], prime.intValue());
		}
	}

	@Test
	public void testEnsuredRange() {
		PrimeGen pg = new PrimeGen();

		List<Integer> primesList = pg.generate(7900, 7920);

		assertEquals(7901, primesList.get(0).intValue());
		assertEquals(7907, primesList.get(1).intValue());
		assertEquals(7919, primesList.get(2).intValue());

	}

	@Test
	public void testBadInput() {
		PrimeGen pg = new PrimeGen();
		// Check inputs
		List<Integer> primesList = pg.generate(0, 1);

		assertTrue("List should be empty: " + primesList, primesList.isEmpty());

		primesList = pg.generate(1, 1);

		assertTrue("List should be empty: " + primesList, primesList.isEmpty());
	}

	@Test
	public void testCount() {
		PrimeGen pg = new PrimeGen();

		List<Integer> primesList = pg.generate(0, 1000000);

		assertEquals("Less than 1 million numbers should result in 78498 primes", 78498, primesList.size());
	}

	@Test
	public void testIsPrime() {
		PrimeGen pg = new PrimeGen();

		assertTrue(pg.isPrime(7901));
		assertTrue(pg.isPrime(7907));
		assertTrue(pg.isPrime(7919));

	}

}
