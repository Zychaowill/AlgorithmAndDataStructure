package com.buildupchao.datastructure.basic.graph.algo;

import com.buildupchao.datastructure.basic.graph.vo.Graph;
import com.buildupchao.datastructure.basic.graph.vo.Vertex;

public interface ShortestPathStrategy {
	
	ShortestResult shortestPath(Graph graph, Vertex v);
}
