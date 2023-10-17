package MergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMergeSort {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Integer n = scanner.nextInt();

			List<Integer> array = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				array.add(scanner.nextInt());
			}

			MergeSort.sort(array);

			for (int i = 0; i < n; i++) {
				System.out.print(array.get(i) + " ");
			}

			scanner.close();
		}
	}
}
