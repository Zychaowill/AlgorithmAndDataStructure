package zychaowill.datastructure.basic.list;

import zychaowill.datastructure.basic.list.node.DoubleNode;

public class DoubleLinkList<T> implements LinearTable<T> {

	private DoubleNode<T> head;
	private DoubleNode<T> tail;
	private int size;

	public DoubleLinkList() {
		this.head = new DoubleNode<>();
		this.tail = null;
	}

	public DoubleLinkList(T data) {
		this.head = new DoubleNode<>(null, data, null);
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
		return getDoubleNode(index).data;
	}
	
	private DoubleNode<T> getDoubleNode(int index) {
		if (index < 0 || index > this.size - 1) {
			throw new IndexOutOfBoundsException("访问位置非法越界!");
		}
		
		if (index <= this.size / 2) {
			
			DoubleNode<T> current = this.head;
			for (int i = 0; i <= this.size / 2 && current != null; i++, current = current.next) {
				if (i == index) {
					return current;
				}
			}
		} else {
			DoubleNode<T> current = this.tail;
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
		DoubleNode<T> DoubleNode = getDoubleNode(index);
		T t = null;
		
		if (DoubleNode != null) {
			t = DoubleNode.data;
			DoubleNode.data = element;
		}
		
		return t;
	}

	@Override
	public boolean addToHead(T element) {
		DoubleNode<T> DoubleNode = new DoubleNode<T>(null, element, null);
		head.pre = DoubleNode;
		head = DoubleNode;
		
		if (tail == null) {
			tail = head;
		}
		this.size++;
		return true;
	}
	
	@Override
	public boolean addToTail(T element) {
		if (head == null) {
			head = new DoubleNode<T>(null, element, null);
			tail = head;
		} else {
			DoubleNode<T> DoubleNode = new DoubleNode<T>(tail, element, null);
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
}
