package zychaowill.datastructure.graph.algo.impl;

import java.util.List;

import zychaowill.datastructure.graph.algo.AbstractShortestPathStrategy;
import zychaowill.datastructure.graph.algo.ShortestResult;
import zychaowill.datastructure.graph.vo.Graph;
import zychaowill.datastructure.graph.vo.Vertex;

public class Dijkstra extends AbstractShortestPathStrategy {

	@Override
	public ShortestResult shortestPath(Graph graph, Vertex v) {
		init(graph, v);
		
		Vertex w;
		while (!U.isEmpty()) {
			w = U.element();
			List<Vertex> neighbors = getNeighbors(w);
			updateDistance(w, neighbors);
			S.add(U.poll());
		}
		
		return new ShortestResult(S, getShortestPathLength());
	}
}
