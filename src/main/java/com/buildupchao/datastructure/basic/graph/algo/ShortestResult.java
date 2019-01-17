package com.buildupchao.datastructure.basic.graph.algo;

import java.util.Queue;

import com.buildupchao.datastructure.basic.graph.vo.Vertex;

public class ShortestResult {

	int[][] A;
	Queue<Vertex> vertexs;
	int path;

	public ShortestResult(int[][] a) {
		A = a;
	}

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

	public void printAllResult() {
		final String separator = " -> ";
		StringBuilder builder;

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if (i == j) {
					continue;
				}
				builder = new StringBuilder("");
				builder.append(i).append(separator).append(j).append(", length: ").append(A[i][j]);
				System.out.println(builder.toString());
			}
		}
	}
}
