package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainBFS {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
			Integer nodes = scanner.nextInt();

			for (int i = 0; i < nodes; i++) {
				adj.put(i, new ArrayList<Integer>());
			}

			Integer edges = scanner.nextInt();
			Integer u, v;
			for (int i = 0; i < edges; i++) {
				u = scanner.nextInt();
				v = scanner.nextInt();

				adj.get(u).add(v);
				adj.get(v).add(u);
			}

			for (Integer value : BFS.bfs(0, adj)) {
				System.out.println(value);
			}

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

	}
}
