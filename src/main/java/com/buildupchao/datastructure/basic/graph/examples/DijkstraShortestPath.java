package com.buildupchao.datastructure.basic.graph.examples;

import java.util.ArrayList;
import java.util.List;

import com.buildupchao.datastructure.basic.graph.algo.impl.Dijkstra;
import com.buildupchao.datastructure.basic.graph.vo.Graph;
import com.buildupchao.datastructure.basic.graph.vo.Vertex;

public class DijkstraShortestPath {

	public static void main(String[] args) {
		List<Vertex> vertexs = new ArrayList<Vertex>();
		Vertex a = new Vertex("0", 0);
		Vertex b = new Vertex("1");
		Vertex c = new Vertex("2");
		Vertex d = new Vertex("3");
		Vertex e = new Vertex("4");
		Vertex f = new Vertex("5");
		Vertex g = new Vertex("6");
		vertexs.add(a);
		vertexs.add(b);
		vertexs.add(c);
		vertexs.add(d);
		vertexs.add(e);
		vertexs.add(f);
		vertexs.add(g);
		int[][] edges = { { 0, 4, 6, 6, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, 0, 1, Integer.MAX_VALUE, 7, Integer.MAX_VALUE, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 2, 6, 4, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 5, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 6 },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 0, 8 },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE }
		};

		Graph graph = new Graph(vertexs, edges);
		graph.setShortestPathStrategy(new Dijkstra());
		graph.getShortestPath(a);
	}
}
