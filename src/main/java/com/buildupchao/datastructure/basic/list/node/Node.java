package com.buildupchao.datastructure.basic.list.node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node<T> {
	public T data;
	public Node<T> next;

	public Node(T data) {
		this.data = data;
	}

}
