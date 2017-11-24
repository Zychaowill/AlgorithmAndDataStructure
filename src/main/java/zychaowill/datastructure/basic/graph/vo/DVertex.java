package zychaowill.datastructure.basic.graph.vo;

public class DVertex implements Comparable<DVertex> {
	/**
	 * 节点名称(A,B,C,D)
	 */
	private String name;

	/**
	 * 最短路径长度
	 */
	private int path;

	public DVertex(String name) {
		this.name = name;
		this.path = Integer.MAX_VALUE; // 初始设置为无穷大
	}

	public DVertex(String name, int path) {
		this.name = name;
		this.path = path;
	}

	@Override
	public int compareTo(DVertex o) {
		return path < o.path ? 1 : -1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPath() {
		return path;
	}

	public void setPath(int path) {
		this.path = path;
	}
}
