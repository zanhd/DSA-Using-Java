package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class MainBinarySearch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter size of Array : ");
		int n = scanner.nextInt();

		System.out.print("Enter " + n + " Intergers : ");
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}

		Arrays.sort(array);

		boolean wannaContinue = true;

		while (wannaContinue) {
			System.out.print("Enter Number to Search : ");
			int key = scanner.nextInt();

			System.out.println((BinarySearch.search(key, array)) ? "FOUND" : "NOT-FOUND");

			System.out.print("Do you wann continue (true or false): ");
			wannaContinue = scanner.nextBoolean();
		}

	}
}
