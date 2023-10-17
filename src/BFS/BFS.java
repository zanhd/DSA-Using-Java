package BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BFS {

	public static List<Integer> bfs(Integer src, Map<Integer, List<Integer>> adj) {

		List<Integer> bfs = new ArrayList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();

		Queue<Integer> Q = new LinkedList<Integer>();

		Q.add(src);
		visited.add(src);

		while (!Q.isEmpty()) {
			Integer u = Q.poll();
			bfs.add(u);

			for (Integer v : adj.get(u)) {
				if (visited.contains(v))
					continue;
				Q.add(v);
				visited.add(v);
			}

		}

		return bfs;
	}
}
