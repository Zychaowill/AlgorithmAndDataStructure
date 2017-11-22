package zychaowill.datastructure.graph.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import zychaowill.datastructure.graph.vo.Graph;
import zychaowill.datastructure.graph.vo.Vertex;

public abstract class AbstractShortestPathStrategy implements ShortestPathStrategy {

	protected final int MAX_VALUE = Integer.MAX_VALUE;
	protected List<Vertex> vertexs; // all vertexs of graph
	protected int[][] edges; // weight between two vertexs
	protected Queue<Vertex> S;
	protected Queue<Vertex> U;

	/**
	 * get shortest path length
	 * @see
	 * @return
	 */
	protected int getShortestPathLength() {
		int path = 0;
		List<Vertex> list = new ArrayList<>(S);
		for (int i = 1; i < list.size(); i++) {
			path += getDistance(list.get(i - 1), list.get(i));
		}
		
		return path;
	}
	
	/*
	 * 获取顶点所有(未访问的)邻居
	 */
	protected List<Vertex> getNeighbors(Vertex v) {
		List<Vertex> neighbors = new ArrayList<>();
		int position = vertexs.indexOf(v);

		Vertex neighbor = null;
		int distance;
		for (int i = 0; i < vertexs.size(); i++) {
			if (i == position) {
				continue;
			}

			distance = edges[position][i];
			if (distance < MAX_VALUE) {
				neighbor = vertexs.get(i);
				if (U.contains(neighbor)) {
					neighbors.add(neighbor);
				}
			}
		}
		
		return neighbors;
	}

	/*
	 * 获取顶点到目标顶点的距离
	 */
	protected int getDistance(Vertex source, Vertex destination) {
		int sourceIndex = vertexs.indexOf(source);
		int destinationIndex = vertexs.indexOf(destination);
		return edges[sourceIndex][destinationIndex];
	}

	/*
	 * 更新所有邻居的最短路径
	 */
	protected void updateDistance(Vertex vertex, List<Vertex> neighbors) {
		for (Vertex neighbor : neighbors) {
			updateDistance(vertex, neighbor);
		}
	}

	/*
	 * 更新邻居的最短路径
	 */
	protected void updateDistance(Vertex vertex, Vertex neighbor) {
		int distance = getDistance(vertex, neighbor) + vertex.getPath();
		if (distance < neighbor.getPath()) {
			neighbor.setPath(distance);
		}
	}

	/*
	 * 根据顶点位置获取顶点
	 */
	protected Vertex getVertex(int index) {
		return vertexs.get(index);
	}

	/**
	 * 初始化
	 */
	protected void init(Graph graph) {
		this.vertexs = graph.getVertexs();
		this.edges = graph.getEdges();
		
		initUnVisited();
		
		S = new LinkedList<>();
	}
	
	/**
	 * 初始化未访问顶点集合
	 * @see
	 */
	private void initUnVisited() {
		U = new PriorityQueue<>();
		for (Vertex v : vertexs) {
			U.add(v);
		}
	}
}
