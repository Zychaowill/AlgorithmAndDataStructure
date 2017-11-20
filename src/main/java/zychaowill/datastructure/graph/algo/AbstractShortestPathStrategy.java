package zychaowill.datastructure.graph.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import zychaowill.datastructure.graph.vo.Graph;
import zychaowill.datastructure.graph.vo.Vertex;

public abstract class AbstractShortestPathStrategy implements ShortestPathStrategy {

	protected final int MAX_VALUE = Integer.MAX_VALUE;
	protected List<Vertex> vertexs;
	protected int[][] edges;
	protected Queue<Vertex> S;
	protected Queue<Vertex> U;

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
				neighbors.add(neighbor);
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
	protected void init(Graph graph, Vertex v) {
		this.vertexs = graph.getVertexs();
		this.edges = graph.getEdges();
		S = new LinkedList<>();
		S.add(v);
		U = new LinkedList<>(graph.getVertexs());
		U.remove(v);
	}
}
