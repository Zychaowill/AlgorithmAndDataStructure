package zychaowill.datastructure.basic.queue;

import zychaowill.datastructure.basic.exception.QueueException;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

	private E[] elements;
	private int size = 0;

	@SuppressWarnings("unchecked")
	public PriorityQueue() {
		elements = (E[]) new Comparable[1];
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void enQueue(E element) {
		if (size == elements.length) {
			resizingArray(2 * size);
		}
		elements[size++] = element;
		insertSort(elements);
	}

	@Override
	public E deQueue() {
		E element = elements[--size];
		elements[size] = null; // 避免对象游离

		if (size > 0 && size == elements.length / 4) {
			resizingArray(elements.length / 2);
		}
		return element;
	}

	public void insertSort(E[] a) {
		int N = size - 1;
		if (N == 0) {
			return;
		}

		int num = binaryFind(a, a[N], 0, N - 1);
		E temp = a[N];
		
		for (int j = N; j > num; j--) {
			a[j] = a[j - 1];
		}
		a[num] = temp;
	}

	public int binaryFind(E[] a, E temp, int down, int up) {
		if (up < down || up > a.length || down < 0) {
			throw new QueueException("Index out of bound exception.");
		}
		if (temp.compareTo(a[down]) < 0) {
			return down;
		}
		if (temp.compareTo(a[up]) > 0) {
			return up + 1;
		}

		int middle = (up - down) / 2 + down;
		if (temp.compareTo(a[middle]) == 0) {
			return middle + 1;
		} else if (temp.compareTo(a[middle]) < 0) {
			up = middle - 1;
		} else {
			down = middle + 1;
		}
		return binaryFind(a, temp, down, up);
	}

	public void swap(E[] a, int i, int j) {
		E temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public void resizingArray(int num) {
		E[] temp = (E[]) new Comparable[num];
		for (int i = 0; i < size; i++) {
			temp[i] = elements[i];
		}
		elements = temp;
	}
}
