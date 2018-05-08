package zychaowill.datastructure.research;

import java.util.Stack;

public class SpecialStack {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;

	public SpecialStack() {
		this.stackData = new Stack<>();
		this.stackMin = new Stack<>();
	}

	public void push(Integer newNumber) {
		if (this.stackMin.empty() || newNumber <= this.getMin()) {
			this.stackMin.push(newNumber);
		}
		this.stackData.push(newNumber);
	}
	
	public Integer pop() {
		if (this.stackData.empty()) {
			throw new RuntimeException("Stack is empty.");
		}
		Integer value = this.stackData.pop();
		if (value == getMin()) {
			this.stackMin.pop();
		}
		return value;
	}
	
	public Integer getMin() {
		if (this.stackMin.empty()) {
			throw new RuntimeException("Stack is empty.");
		}
		return this.stackMin.peek();
	}
}
