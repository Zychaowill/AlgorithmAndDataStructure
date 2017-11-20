package zychaowill.datastructure.graph.vo;

import java.util.ArrayList;
import java.util.List;

public class WeightedDirectGraph {

	private final int vertexsNum;
	private final int edgesNum;
	private List<Edge>[] adj;

	public WeightedDirectGraph(int[][] data, int vertexsNum) {
		this.vertexsNum = vertexsNum;
		this.edgesNum = data.length;
		adj = (List<Edge>[]) new ArrayList[vertexsNum];
		for (int i = 0; i < vertexsNum; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < data.length; i++) {
			Edge edge = new Edge(data[i][0], data[i][1], data[i][2]);
			int v = edge.getFrom();
			adj[v].add(edge);
		}
	}
	
	public Iterable<Edge> adj(int vertex) {
		return adj[vertex];
	}
	
	public int getVertexsNum() {
		return vertexsNum;
	}
	
	public int getEdgesNum() {
		return edgesNum;
	}
	
	public Iterable<Edge> getEdges() {
		List<Edge> edges = new ArrayList<>();
		for (List<Edge> list: adj) {
			for (Edge e : list) {
				edges.add(e);
			}
		}
		return edges;
	}
}
