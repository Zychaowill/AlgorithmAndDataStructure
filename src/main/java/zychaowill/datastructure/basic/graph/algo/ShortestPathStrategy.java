package zychaowill.datastructure.basic.graph.algo;

import zychaowill.datastructure.basic.graph.vo.Graph;
import zychaowill.datastructure.basic.graph.vo.Vertex;

public interface ShortestPathStrategy {
	
	ShortestResult shortestPath(Graph graph, Vertex v);
}
