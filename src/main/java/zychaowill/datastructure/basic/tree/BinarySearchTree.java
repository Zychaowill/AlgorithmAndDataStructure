package zychaowill.datastructure.basic.tree;

public class BinarySearchTree<T extends Comparable<? super T>> {

	private Node<T> root;

	public BinarySearchTree() {
		root = null;
	}

	/**
	 * 查找指定的元素，默认从根节点开始查找
	 * 
	 * @param key
	 * @return
	 */
	public boolean contains(T key) {
		return contains(key, root);
	}

	/**
	 * 查找出最小元素
	 * 
	 * @return
	 */
	public T finaMin() {
		if (isEmpty()) {
			System.out.println("Binary Search Tree is null.");
			return null;
		} else {
			return findMin(root).data;
		}
	}

	/**
	 * 查找最大元素
	 * 
	 * @return
	 */
	public T findMax() {
		if (isEmpty()) {
			System.out.println("Binary Search Tree is null.");
			return null;
		} else {
			return findMax(root).data;
		}
	}

	/**
	 * 插入元素
	 * 
	 * @param key
	 */
	public void insert(T key) {
		root = insert(key, root);
	}

	/**
	 * 先序遍历
	 * @param node
	 */
	public void preOrder(Node<T> node) {
		if (node != null) {
			System.out.print(node.data + "\t");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	/**
	 * 中序遍历
	 * @param node
	 */
	public void suffixOrder(Node<T> node) {
		if (node != null) {
			suffixOrder(node.left);
			System.out.print(node.data + "\t");
			suffixOrder(node.right);
		}
	}
	
	/**
	 * 后序遍历
	 * @param node
	 */
	public void postOrder(Node<T> node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data + "\t");
		}
	}

	/**
	 * 删除指定元素
	 * 
	 * @param key
	 */
	public void remove(T key) {
		root = remove(key, root);
	}

	/**
	 * 判断是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return root == null;
	}

	public void clear() {
		root = null;
	}

	/**
	 * 从指定结点开始查找指定的元素
	 * 
	 * @param key
	 * @param node
	 * @return
	 */
	public boolean contains(T key, Node<T> node) {

		if (node == null) {
			return false;
		}

		int result = key.compareTo(node.data);

		if (result > 0) {
			return contains(key, node.right);
		} else if (result < 0) {
			return contains(key, node.left);
		} else {
			return true;
		}
	}

	/**
	 * 查询出最小元素所在结点
	 * 
	 * @param node
	 * @return
	 */
	public Node<T> findMin(Node<T> node) {
		if (node == null) {
			return null;
		} else if (node.left == null) {
			return node;
		} else {
			return findMin(node.left);
		}
	}

	/**
	 * 查找最大元素所在节点
	 * 
	 * @param node
	 * @return
	 */
	public Node<T> findMax(Node<T> node) {
		Node<T> iterNode = node;
		
		if (iterNode != null) {
			while (iterNode.right != null) {
				iterNode = iterNode.right;
			}
		}
		return iterNode;
	}

	/**
	 * 从指定结点开始判断插入元素
	 * 
	 * @param key
	 * @param node
	 * @return
	 */
	public Node<T> insert(T key, Node<T> node) {
		if (root == null) {
			return new Node<T>(key, null, null);
		}

		int result = key.compareTo(root.data);

		if (result < 0) {
			node.left = insert(key, node.left);
		} else if (result > 0) {
			node.right = insert(key, node.right);
		}

		return node;
	}

	/**
	 * 在指定位置开始判断删除指定元素
	 * 
	 * @param key
	 * @param node
	 * @return
	 */
	public Node<T> remove(T key, Node<T> node) {
		if (node == null) {
			return node;
		}

		int result = key.compareTo(node.data);
		if (result > 0) {
			node.right = remove(key, node.right);
		} else if (result < 0) {
			node.left = remove(key, node.left);
		} else if (node.left != null && node.right != null) {
			node.data = findMin(node.right).data;
			node.right = remove(node.data, node.right);
		} else {
			node = (node.left != null) ? node.left : node.right;
		}

		return node;
	}

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	static class Node<T> {
		T data;
		Node<T> left;
		Node<T> right;

		public Node(T data, Node<T> left, Node<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public Node() {
			this.data = null;
		}

		public Node(T data) {
			this(data, null, null);
		}

	}
}
