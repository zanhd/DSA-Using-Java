package BinaryExponentiation;

import java.util.Scanner;

public class MainBinaryExponentiation {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int n = scanner.nextInt();
			int M = scanner.nextInt();

			System.out.println("pow(" + a + ", " + n + ") % " + M + " : " + BinaryExponentiation.pow(a, n, M));

			scanner.close();
		}
	}
}
