package com.buildupchao.datastructure.basic.graph.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.buildupchao.datastructure.basic.graph.algo.ShortestPathStrategy;

public class DGraph {
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

	/*
	 * 没有访问的顶点
	 */
	private Queue<Vertex> unVisited;

	public DGraph(List<Vertex> vertexs, int[][] edges) {
		this.vertexs = vertexs;
		this.edges = edges;
		initUnVisited();
	}

	/*
	 * 初始化未访问顶点集合
	 */
	private void initUnVisited() {
		unVisited = new PriorityQueue<Vertex>();
		for (Vertex v : vertexs) {
			unVisited.add(v);
		}
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
	 * 
	 * @see
	 * @param v
	 */
	public void getShortestPath(Vertex v) {
//		shortestPathStrategy.shortestPath(this, v).printResult();
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
