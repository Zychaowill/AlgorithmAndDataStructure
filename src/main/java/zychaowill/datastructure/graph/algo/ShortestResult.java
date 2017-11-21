package zychaowill.datastructure.graph.algo;

import java.util.Queue;

import zychaowill.datastructure.graph.vo.Vertex;

public class ShortestResult {

	Queue<Vertex> vertexs;
	int path;

	public ShortestResult(Queue<Vertex> vertexs, int path) {
		this.vertexs = vertexs;
		this.path = path;
	}

	public void printResult() {
		final String separator = " -> ";
		StringBuilder builder = new StringBuilder("");
		
		while (!vertexs.isEmpty()) {
			builder.append(vertexs.poll().getName() + separator);
		}
		
		String shortestPath = builder.substring(0, builder.lastIndexOf(separator));
		System.out.println(shortestPath + ", length: " + path);
	}
}
