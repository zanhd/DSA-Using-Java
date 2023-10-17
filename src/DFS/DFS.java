package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DFS {
	public static List<Integer> dfs(Integer src, Map<Integer, List<Integer>> adj) {

		List<Integer> dfs = new ArrayList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();

		dfsHelper(src, adj, visited, dfs);

		return dfs;
	}

	private static void dfsHelper(Integer u, Map<Integer, List<Integer>> adj, Set<Integer> visited, List<Integer> dfs) {

		dfs.add(u);
		visited.add(u);

		for (Integer v : adj.get(u)) {
			if (visited.contains(v))
				continue;
			dfsHelper(v, adj, visited, dfs);
		}

	}
}
