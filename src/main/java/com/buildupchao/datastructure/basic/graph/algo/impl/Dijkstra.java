package com.buildupchao.datastructure.basic.graph.algo.impl;

import java.util.List;

import com.buildupchao.datastructure.basic.graph.algo.AbstractShortestPathStrategy;
import com.buildupchao.datastructure.basic.graph.algo.ShortestResult;
import com.buildupchao.datastructure.basic.graph.vo.Graph;
import com.buildupchao.datastructure.basic.graph.vo.Vertex;

public class Dijkstra extends AbstractShortestPathStrategy {

	@Override
	public ShortestResult shortestPath(Graph graph, Vertex v) {
		init(graph);
		
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
