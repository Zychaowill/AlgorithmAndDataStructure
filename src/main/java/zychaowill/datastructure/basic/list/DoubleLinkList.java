package zychaowill.datastructure.basic.list;

public class DoubleLinkList<T> implements LinearTable<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;

	public DoubleLinkList() {
		this.head = new Node<T>();
		this.tail = null;
	}

	public DoubleLinkList(T data) {
		this.head = new Node<>(null, data, null);
		this.tail = this.head;
		this.size++;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int getLength() {
		return this.size;
	}

	@Override
	public T get(int index) {
		return getNode(index).data;
	}
	
	private Node<T> getNode(int index) {
		if (index < 0 || index > this.size - 1) {
			throw new IndexOutOfBoundsException("访问位置非法越界!");
		}
		
		if (index <= this.size / 2) {
			
			Node<T> current = this.head;
			for (int i = 0; i <= this.size / 2 && current != null; i++, current = current.next) {
				if (i == index) {
					return current;
				}
			}
		} else {
			Node<T> current = this.tail;
			for (int i = this.size - 1; i > this.size / 2 && current != null; i--, current = current.pre) {
				if (i == index) {
					return current;
				}
			}
		}
		
		return null;
	}

	@Override
	public T set(int index, T element) {
		Node<T> node = getNode(index);
		T t = null;
		
		if (node != null) {
			t = node.data;
			node.data = element;
		}
		
		return t;
	}

	@Override
	public boolean addToHead(T element) {
		Node<T> node = new Node<T>(null, element, null);
		head.pre = node;
		head = node;
		
		if (tail == null) {
			tail = head;
		}
		this.size++;
		return true;
	}
	
	@Override
	public boolean addToTail(T element) {
		if (head == null) {
			head = new Node<T>(null, element, null);
			tail = head;
		} else {
			Node<T> node = new Node<T>(tail, element, null);
		}
		return false;
	}

	@Override
	public boolean add(int index, T element) {
		return false;
	}

	@Override
	public T remove(int index) {
		return null;
	}

	@Override
	public boolean clear() {
		return false;
	}

	@Override
	public boolean removeTail() {
		return false;
	}

	class Node<T> {
		private T data;
		private Node<T> pre;
		private Node<T> next;

		public Node() {
		}

		public Node(Node<T> pre, T data, Node<T> next) {
			this.data = data;
			this.pre = pre;
			this.next = next;
		}

	}
}
