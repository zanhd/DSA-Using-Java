package BinarySearch;

public class BinarySearch {
	public static boolean search(int key, int[] array) {
		int beg = 0;
		int end = array.length - 1;

		while (beg <= end) {
			int mid = (beg + end) / 2;
			if (array[mid] == key)
				return true;
			else if (key < array[mid])
				end = mid - 1;
			else
				beg = mid + 1;
		}

		return false;
	}
}
