package zychaowill.datastructure.graph.algo;

import java.util.Queue;

import zychaowill.datastructure.graph.vo.Vertex;

public class ShortestResult {

	Queue<Vertex> vertexs;

	public ShortestResult(Queue<Vertex> vertexs) {
		this.vertexs = vertexs;
	}

	public void printResult() {
		int path = 0;
		for (Vertex vertex : vertexs) {
			path += vertex.getPath();
		}
		System.out.println("\n shortest path length: " + path);
		vertexs.stream().forEach(x -> System.out.print(x.getName() + "\t"));
	}
}
