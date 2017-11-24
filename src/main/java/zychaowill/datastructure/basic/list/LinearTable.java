package zychaowill.datastructure.basic.list;

public interface LinearTable<T> {

	// 判空
	public boolean isEmpty();
	
	// 获取长度
	public int getLength();
	
	// 返回指定位置的元素
	public T get(int index);
	
	// 设置指定位置新的元素值，并返回旧的元素值
	public T set(int index, T element);
	
	// 添加一个元素
	public boolean addToHead(T element);
	
	public boolean addToTail(T element);
	
	// 在指定位置添加一个元素
	public boolean add(int index, T element);
	
	// 删除指定位置的元素，并返回该位置元素的值
	public T remove(int index);
	
	// 清空线性表
	public boolean clear();
	
	// 删除尾部
	public boolean removeTail();
}
