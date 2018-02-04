package zychaowill.datastructure.basic.heap;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.stream.Collectors;

public class SmallHeadHeap<E> implements Serializable {

	private static final long serialVersionUID = 2841956348111902147L;

	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	
	transient Object[] elements;
	/**
	 * The number of elements in the small head heap.
	 */
	private int size = 0;

	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	
	/**
	 * The comparator, or null if small head heap uses elements'
	 * natural ordering.
	 */
	private final Comparator<? super E> comparator;

	public SmallHeadHeap() {
		this(DEFAULT_INITIAL_CAPACITY, null);
	}

	public SmallHeadHeap(int minCapacity, Comparator<? super E> comparator) {
		if (minCapacity < 1)
			throw new IllegalArgumentException();
		this.elements = new Object[minCapacity];
		this.comparator = comparator;
	}
	
	@SuppressWarnings("unchecked")
	public SmallHeadHeap(Collection<? extends E> c) {
		if (c instanceof SortedSet<?>) {
			SortedSet<? extends E> ss = (SortedSet<? extends E>) c;
			this.comparator = (Comparator<? super E>) ss.comparator();
			initElementsFromCollection(ss);
		} else {
			this.comparator = null;
			initFromCollection(c);
		}
	}

	@SuppressWarnings("unchecked")
	public SmallHeadHeap(SortedSet<? extends E> c) {
		this.comparator = (Comparator<? super E>) c.comparator();
		initElementsFromCollection(c);
	}
	
	private void initElementsFromCollection(Collection<? extends E> c) {
		Object[] a = c.toArray();
		if (a.getClass() != Object[].class)
			a = Arrays.copyOf(a, a.length, Object[].class);
		int len = a.length;
		if (len == 1 || this.comparator != null) {
			for (int i = 0; i < len; i++) {
				if (a[i] == null) {
					throw new NullPointerException();
				}
			}   
		}
		this.elements = a;
		this.size = a.length;
	}
	
	private void initFromCollection(Collection<? extends E> c) {
		initElementsFromCollection(c);
		heapify();
	}
	
	@SuppressWarnings("unchecked")
	private void heapify() {
		for (int i = (size >>> 1) - 1; i >= 0; i--)
			siftDown(i, (E) elements[i]);
	}

	public boolean add(E e) {
		return offer(e);
	}
	
	public boolean offer(E e) {
		Objects.requireNonNull(e, "Could not accept a null element to execute offer operation.");

		int i = size;
		if (i >= elements.length)
			growing(i + 1);
		size = i + 1;
		if (i == 0)
			elements[0] = e;
		else
			siftUp(i, e);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public E poll() {
		if (size == 0)
			return null;
		int s = --size;
		E result = (E) elements[0];
		
		E e = (E) elements[s];
		elements[s] = null;
		
		if (s != 0)
			siftDown(0, e);
		return result;
	}

	@SuppressWarnings("unchecked")
	public E peek() {
		return (size == 0) ? null : (E) elements[size];
	}
	
	private int indexOf(Object o) {
		if (o != null) {
			for (int i = 0; i < size; i++) {
				if (o.equals(elements[i])) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public boolean remove(Object o) {
		int i = indexOf(o);
		if (i == -1) {
			return false;
		} else {
			removeAt(i);
			return true;
		}
	}

	boolean removeEq(Object o) {
		for (int i = 0; i < size; i++) {
			if (o == elements[i]) {
				removeAt(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(Object o) {
		return indexOf(o) != -1;
	}
	
	@SuppressWarnings("unchecked")
	private E removeAt(int i) {
		int s = --size;
		if (s == i) {
			elements[i] = null;
		} else {
			E moved = (E) elements[s];
			elements[s] = null;
			siftDown(i, moved);
			if (elements[i] == moved) {
				siftUp(i, moved);
				if (elements[i] != moved) {
					return moved;
				}
			}
		}
		return null;
	}
	
	/**
	 * Increase the capacity of the array.
	 * 
	 * @param minCapacity the desired minimum capacity
	 */
	private void growing(int minCapacity) {
		int oldCapacity = elements.length;
		int newCapacity = oldCapacity + ((oldCapacity > 64) ? (oldCapacity + 2) : (oldCapacity >> 1));
		
		if (newCapacity - MAX_ARRAY_SIZE > 0)
			newCapacity = hugeCapacity(minCapacity);
		elements = Arrays.copyOf(elements, newCapacity);
	}

	private int hugeCapacity(int minCapacity) {
		if (minCapacity < 0)
			throw new OutOfMemoryError();
		return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
	}

	private void siftUp(int k, E e) {
		if (Objects.nonNull(comparator))
			siftUpUsingComparator(k, e);
		else
			siftUpComparable(k, e);
	}

	@SuppressWarnings("unchecked")
	private void siftUpComparable(int k, E e) {
		Comparable<? super E> key = (Comparable<? super E>) e;
		while (k > 0) {
			int parentIndex = (k - 1) >>> 1;
			Object parentNode = elements[parentIndex];
			if (key.compareTo((E) parentNode) >= 0)
				break;
			elements[k] = parentNode;
			k = parentIndex;
		}
		elements[k] = key;
	}

	@SuppressWarnings("unchecked")
	private void siftUpUsingComparator(int k, E e) {
		while (k > 0) {
			int parentIndex = (k - 1) >>> 1;
			Object parentNode = elements[parentIndex];
			if (comparator.compare(e, (E) parentNode) >= 0)
				break;
			elements[k] = e;
			k = parentIndex;
		}
		elements[k] = e;
	}
	
	private void siftDown(int k, E e) {
		if (Objects.nonNull(comparator))
			siftDownUsingComparator(k, e);
		else
			siftDownComparable(k, e);
	}
	
	@SuppressWarnings("unchecked")
	private void siftDownComparable(int k, E e) {
		Comparable<? super E> key = (Comparable<? super E>) e;
		int half = size >>> 1; // loop while a non-leaf
		while (k < half) {
			int leftIndex = (k << 1) + 1; // assume left child is least
			Object leftNode = elements[leftIndex];
			int rightIndex = leftIndex + 1;
			if (rightIndex < size && ((Comparable<? super E>) leftNode).compareTo((E) elements[rightIndex]) > 0)
				leftNode = elements[leftIndex = rightIndex];
			if (key.compareTo((E) leftNode) <= 0)
				break;
			elements[k] = leftNode;
			k = leftIndex;
		}
		elements[k] = key;
	}

	@SuppressWarnings("unchecked")
	private void siftDownUsingComparator(int k, E e) {
		int half = size >>> 1;
		while (k < half) {
			int leftIndex = (k << 1) + 1;
			Object leftNode = elements[leftIndex];
			int rightIndex = leftIndex + 1;
			if (comparator.compare((E) leftNode, (E) elements[rightIndex]) > 0)
				leftNode = elements[leftIndex = rightIndex];
			if (comparator.compare(e, (E) leftNode) <= 0)
				break;
			elements[k] = leftNode;
			k = leftIndex;
		}
		elements[k] = e;
	}

	public int size() {
		return size;
	}
	
	public Comparator<? super E> comparator() {
		return comparator;
	}
	
	public void clear() {
		for (int i = 0; i < size; i++)
			elements[i] = null;
		size = 0;
	}
	
	public Object[] toArray() {
		return Arrays.copyOf(elements, size);
	}
	
	public String inOrder() {
		String dataWithSplitor = Arrays.stream(elements).map(String::valueOf).collect(Collectors.joining(","));
		return dataWithSplitor;
	}
}
