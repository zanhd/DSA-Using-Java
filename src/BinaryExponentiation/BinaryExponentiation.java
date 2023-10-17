package BinaryExponentiation;

public class BinaryExponentiation {

	public static boolean isEven(int n) {
		return n % 2 == 0;
	}

	public static int MOD_MULTI(final int a, final int b, final int M) {
		return ((a % M) * (b % M)) % M;
	}

	public static int pow(int a, int n, int M) {
		if (n == 0)
			return 1;

		if (isEven(n)) {
			int p = pow(a, n / 2, M);
			return MOD_MULTI(p, p, M);
		} else {
			int p = pow(a, (n - 1) / 2, M) % M;
			return MOD_MULTI(MOD_MULTI(p, p, M), a, M);
		}
	}
}
