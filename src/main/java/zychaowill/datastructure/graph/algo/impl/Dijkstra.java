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
		
		while (!U.isEmpty()) {
			List<Vertex> neighbors = getNeighbors(v);
			updateDistance(v, neighbors);
			S.add(U.poll());
		}
		
		return new ShortestResult(S);
	}
}
