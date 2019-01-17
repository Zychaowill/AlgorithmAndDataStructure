package com.buildupchao.algorithm.research;

import java.util.Stack;

public class DoubleStackQueue {
	private Stack<Integer> pushStack;
	private Stack<Integer> popStack;

	public DoubleStackQueue() {
		this.pushStack = new Stack<>();
		this.popStack = new Stack<>(); 
	}

	public void add(Integer newNumber) {
		pushStack.push(newNumber);
	}
	
	public Integer poll() {
		requiredNotEmpty();
		loadDataWhenEmtpy();
		return popStack.pop();
	}
	
	public Integer peek() {
		requiredNotEmpty();
		loadDataWhenEmtpy();
		return popStack.peek();
	}
	
	private void loadDataWhenEmtpy() {
		if (popStack.empty()) {
			while (!pushStack.isEmpty()) {
				popStack.push(pushStack.pop());
			}
		}
	}
	
	private void requiredNotEmpty() {
		if (pushStack.empty() && popStack.empty()) {
			throw new RuntimeException("Queue is empty.");
		}
	}
}
