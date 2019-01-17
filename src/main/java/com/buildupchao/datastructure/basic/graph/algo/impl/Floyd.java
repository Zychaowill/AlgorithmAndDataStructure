package com.buildupchao.datastructure.basic.graph.algo.impl;

import java.util.Arrays;
import java.util.List;

import com.buildupchao.datastructure.basic.graph.algo.ShortestPathStrategy;
import com.buildupchao.datastructure.basic.graph.algo.ShortestResult;
import com.buildupchao.datastructure.basic.graph.vo.Graph;
import com.buildupchao.datastructure.basic.graph.vo.Vertex;

public class Floyd implements ShortestPathStrategy {

	private final int MAX_VALUE = 99999999;
	private int[][] A;
	private int[][] path;
	private int MAXV;
	
	@Override
	public ShortestResult shortestPath(Graph graph, Vertex v) {
		init(graph);

		for (int k = 0; k < MAXV; k++) {
			for (int i = 0; i < MAXV; i++) {
				for (int j = 0; j < MAXV; j++) {
					if (A[i][k] + A[k][j] < A[i][j]) {
						A[i][j] = A[i][k] + A[k][j];
						path[i][j] = k;
					}
				}
			}
		}

		return new ShortestResult(A);
	}

	private void init(Graph graph) {
		this.A = graph.getEdges();
		this.MAXV = A.length;
		this.path = new int[MAXV][MAXV];

		for (int i = 0; i < MAXV; i++) {
			Arrays.fill(path[i], -1);
		}
	}

	
}
