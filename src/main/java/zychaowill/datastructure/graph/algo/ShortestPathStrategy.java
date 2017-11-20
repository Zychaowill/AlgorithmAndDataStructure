package zychaowill.datastructure.graph.algo;

import zychaowill.datastructure.graph.vo.Graph;
import zychaowill.datastructure.graph.vo.Vertex;

public interface ShortestPathStrategy {
	
	ShortestResult shortestPath(Graph graph, Vertex v);
}
