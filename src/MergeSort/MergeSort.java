package MergeSort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

	public static void sort(List<Integer> array) {
		mergeSort(array, 0, array.size() - 1);
	}

	private static void mergeSort(List<Integer> array, int beg, int end) {

		if (beg == end)
			return;

		int mid = (beg + end) / 2;

		mergeSort(array, beg, mid);
		mergeSort(array, mid + 1, end);

		merge(array, beg, mid, end); // [beg ... mid] [mid + 1 ... end]

	}

	private static void merge(List<Integer> array, int beg, int mid, int end) {

		List<Integer> ans = new ArrayList<Integer>();

		int i = beg;
		int j = mid + 1;

		while (i <= mid || j <= end) {

			if (i == mid + 1) {
				ans.add(array.get(j));
				j++;
			} else if (j == end + 1) {
				ans.add(array.get(i));
				i++;
			} else {
				if (array.get(i) < array.get(j)) {
					ans.add(array.get(i));
					i++;
				} else {
					ans.add(array.get(j));
					j++;
				}
			}
		}

		for (i = 0; i < ans.size(); i++) {
			array.set(beg + i, ans.get(i));
		}
	}

}
