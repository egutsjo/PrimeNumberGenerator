package exercise.primegen;

import java.util.ArrayList;
import java.util.List;

import exercise.primegen.algorithm.SieveOfEratosthenes;

public class PrimeGen implements PrimeNumberGenerator {

	@Override
	public List<Integer> generate(int startingValue, int endingValue) {

		// Allow this method to be called with only positive number ranging up
		// to the integer max value (exclusive)
		if (startingValue < 0 || endingValue < 0 || startingValue >= Integer.MAX_VALUE || endingValue >= Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Invalid range, a valid prime number range is between 0 and " + (Integer.MAX_VALUE - 1));
		}

		// Requirement: The code should handle inverse ranges such that 1-10 and
		// 10-1 are equivalent.
		if (startingValue > endingValue) {
			startingValue = startingValue + endingValue;
			endingValue = startingValue - endingValue;
			startingValue = startingValue - endingValue;
		}

		boolean[] isPrime = new SieveOfEratosthenes().getSieve(endingValue);

		List<Integer> result = new ArrayList<Integer>();

		for (int i = startingValue; i <= endingValue; i++) {
			if (isPrime[i]) {
				result.add(i);
			}
		}

		return result;

	}

	@Override
	public boolean isPrime(int value) {
		boolean[] isPrime = new SieveOfEratosthenes().getSieve(value);

		return isPrime[value];
	}

	/**
	 * Main method of PrimeGen, takes two arguments, startingValue and
	 * endingValue.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length != 2) {
			System.err.println("You must specify a <starting> and <ending> value!");
			System.exit(1);
		}

		PrimeGen pg = new PrimeGen();

		try {
			List<Integer> result = pg.generate(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

			System.out.println("Primes: " + result);
			System.out.println("Number of primes: " + result.size());

		} catch (NumberFormatException ex) {
			System.out.println("Numbers only please: " + ex.getMessage());
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
