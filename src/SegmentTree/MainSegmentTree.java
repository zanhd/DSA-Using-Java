package SegmentTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSegmentTree {

	public static final int QUERY_SUM = 0;
	public static final int QUERY_UPDATE = 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {

			System.out.print("Enter size of Array : ");
			Integer n = scanner.nextInt();

			System.out.print("Enter Array Elements : ");

			List<Integer> array = new ArrayList<Integer>();

			for (int i = 0; i < n; i++) {
				array.add(scanner.nextInt());
			}

			SegmentTree segmentTree = new SegmentTree(array);

			System.out.print("Enter number of Queries : ");
			Integer Q = scanner.nextInt();

			for (int q = 0; q < Q; q++) {
				Integer type = scanner.nextInt();
				if (type == QUERY_SUM) {
					Integer I = scanner.nextInt();
					Integer J = scanner.nextInt();

					System.out.println("Sum of sub-array[" + I + "..." + J + "] : " + segmentTree.sum(I, J));
				} else if (type == QUERY_UPDATE) {
					Integer position = scanner.nextInt();
					Integer value = scanner.nextInt();

					segmentTree.update(position, value);

				} else {
					System.out.println("Please select query 0 : sum, query 1 : update!!!");
				}
			}

		}
	}
}
