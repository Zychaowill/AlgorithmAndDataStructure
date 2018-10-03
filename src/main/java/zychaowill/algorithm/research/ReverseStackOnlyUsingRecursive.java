package zychaowill.algorithm.research;

import java.util.Stack;

public class ReverseStackOnlyUsingRecursive {

	public ReverseStackOnlyUsingRecursive() {
	}

	private Integer lastElement(Stack<Integer> stack) {
		Integer result = stack.pop();
		if (stack.empty()) {
			stack.push(result);
			return result;
		}
		Integer last = lastElement(stack);
		stack.push(result);
		return last;
	}

	public void reverse(Stack<Integer> stack) {
		if (stack.empty()) {
			return;
		}
		lastElement(stack);
	}
}
