package DataStructuresCollectionFramework;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import Utility.Pair;

public class UsingCollectionsSet {

	static Comparator<Pair> cmp = new Comparator<Pair>() {

		@Override
		public int compare(Pair a, Pair b) {
			if (a.getFirst() > b.getFirst()) {
				return 1; // Swap while sorting
			} else if (a.getFirst() == b.getFirst()) {
				if (a.getFirst() > b.getFirst()) {
					return 1; // swap
				} else {
					return -1; // dont swap
				}
			} else {
				return -1;
			}
		}

	};

	public static void main(String[] args) {
		Set<Pair> set = new TreeSet<Pair>(cmp);

		set.add(new Pair(2, 2));
		set.add(new Pair(1, 3));
		set.add(new Pair(1, 2));
		set.add(new Pair(2, 1));

		for (Pair x : set) {
			System.out.println(x.getFirst() + ", " + x.getSecond());
		}
	}
}
