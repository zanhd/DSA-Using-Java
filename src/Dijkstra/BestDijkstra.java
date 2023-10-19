package Dijkstra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import Utility.Constants;
import Utility.Pair;

public class BestDijkstra implements Dijkstra {

	Comparator<Pair> cmp = new Comparator<Pair>() {

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

	@Override
	public List<Integer> dijkstra(Integer src, Map<Integer, List<Pair>> adj, int MAX_NODES) {
		List<Integer> distance = new ArrayList<Integer>();
		List<Boolean> isUsed = new ArrayList<Boolean>();

		for (int i = 0; i < MAX_NODES; i++) {
			distance.add(Constants.INF);
			isUsed.add(false);
		}

		distance.set(src, 0);

		// Using Set as a MinHeap (intead of PriorityQueue)
		TreeSet<Pair> pq = new TreeSet<Pair>(cmp);

		pq.add(new Pair(distance.get(src), src));

		while (!pq.isEmpty()) {

			Integer u = pq.first().getSecond();
			Integer d = pq.first().getFirst(); // This will be the minimum distance [minDistanceNode] :) Pick It
			pq.pollFirst();

			distance.set(u, d);

			if (isUsed.get(u))
				continue;

			isUsed.set(u, true);

			for (Pair x : adj.get(u)) {

				Integer v = x.getFirst();
				Integer w = x.getSecond();

				if (isUsed.get(v))
					continue;

				// Relax
				Integer minDistance = Math.min(distance.get(v), distance.get(u) + w);
				pq.add(new Pair(minDistance, v));

			}

		}

		return distance;
	}

}
