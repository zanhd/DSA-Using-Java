package Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Utility.Pair;

public class MainDijkstra {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			Map<Integer, List<Pair>> adj = new HashMap<Integer, List<Pair>>();
			Integer nodes = scanner.nextInt();

			for (int i = 0; i < nodes; i++) {
				adj.put(i, new ArrayList<Pair>());
			}

			Integer edges = scanner.nextInt();
			Integer u, v, w;
			for (int i = 0; i < edges; i++) {
				u = scanner.nextInt();
				v = scanner.nextInt();
				w = scanner.nextInt();

				adj.get(u).add(new Pair(v, w));
				adj.get(v).add(new Pair(u, w));
			}

			Integer src = scanner.nextInt();

			System.out.print("Basic Dijkstra : ");

			Dijkstra algo = new BasicDijkstra();

			for (Integer value : algo.dijkstra(src, adj, nodes)) {
				System.out.print(value + " ");
			}

			System.out.println();

			System.out.print("Best  Dijkstra : ");

			algo = new BestDijkstra();

			for (Integer value : algo.dijkstra(src, adj, nodes)) {
				System.out.print(value + " ");
			}

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}
