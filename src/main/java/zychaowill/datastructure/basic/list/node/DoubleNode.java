package zychaowill.datastructure.basic.list.node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoubleNode<T> {

	public DoubleNode<T> pre;
	public T data;
	public DoubleNode<T> next;

	public DoubleNode(T data) {
		super();
		this.data = data;
	}

}
