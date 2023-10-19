package Dijkstra;

import java.util.List;
import java.util.Map;

import Utility.Pair;

public interface Dijkstra {
	public List<Integer> dijkstra(Integer src, Map<Integer, List<Pair>> adj, int MAX_NODES);
}
