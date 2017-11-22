package zychaowill.datastructure.graph.vo;

import java.util.List;

import zychaowill.datastructure.graph.algo.ShortestPathStrategy;

public class Graph {
	/*
	 * 顶点
	 */
	private final List<Vertex> vertexs;

	/*
	 * 边
	 */
	private final int[][] edges;

	/**
	 * 求最短路径的策略
	 */
	private ShortestPathStrategy shortestPathStrategy;
	
	public Graph(List<Vertex> vertexs, int[][] edges) {
		this.vertexs = vertexs;
		this.edges = edges;
	}

	/*
	 * 打印图
	 */
	public void printGraph() {
		int verNums = vertexs.size();
		for (int row = 0; row < verNums; row++) {
			for (int col = 0; col < verNums; col++) {
				if (Integer.MAX_VALUE == edges[row][col]) {
					System.out.print("X");
					System.out.print(" ");
					continue;
				}
				System.out.print(edges[row][col]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	/**
	 * Get shortest path from v
	 * @see
	 * @param v
	 */
	public void getShortestPath(Vertex v) {
		shortestPathStrategy.shortestPath(this, v).printResult();
	}
	
	public void getShortestPath() {
		shortestPathStrategy.shortestPath(this, null).printAllResult();
	}

	/**
	 * Export access method 
	 */
	public void setShortestPathStrategy(ShortestPathStrategy shortestPathStrategy) {
		this.shortestPathStrategy = shortestPathStrategy;
	}

	public List<Vertex> getVertexs() {
		return vertexs;
	}

	public int[][] getEdges() {
		return edges;
	}
}
