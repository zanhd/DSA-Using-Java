package Dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dijkstra {
	private static final Integer INF = Integer.MAX_VALUE;

	public static List<Integer> dijkstra(Integer src, Map<Integer, List<Pair>> adj, int MAX_NODES) {
		List<Integer> distance = new ArrayList<Integer>();
		List<Boolean> isUsed = new ArrayList<Boolean>();

		for (int i = 0; i < MAX_NODES; i++) {
			distance.add(INF);
			isUsed.add(false);
		}

		distance.set(src, 0);

		for (int i = 0; i < MAX_NODES; i++) {

			Integer u = getMinDistanceNode(distance, isUsed, MAX_NODES);

			if (u == -1) {
				break;
			}

			isUsed.set(u, true);

			for (Pair x : adj.get(u)) {
				Integer v = x.getFirst();
				Integer w = x.getSecond();

				if (isUsed.get(v))
					continue;

				Integer minDistance = Math.min(distance.get(v), distance.get(u) + w);
				distance.set(v, minDistance);
			}

		}

		return distance;
	}

	private static Integer getMinDistanceNode(List<Integer> distance, List<Boolean> isUsed, int MAX_NODES) {

		Integer minNode = -1;

		for (int i = 0; i < MAX_NODES; i++) {
			if (isUsed.get(i))
				continue;
			if (minNode == -1) {
				minNode = i;
			} else {
				if (distance.get(i) < distance.get(minNode)) {
					minNode = i;
				}
			}
		}

		return minNode;
	}
}
