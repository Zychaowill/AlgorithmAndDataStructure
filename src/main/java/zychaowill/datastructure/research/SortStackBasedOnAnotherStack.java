package zychaowill.datastructure.research;

import java.util.Stack;

public class SortStackBasedOnAnotherStack {

	public static void sort(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<>();
		while (!stack.isEmpty()) {
			int current = stack.pop();
			while (!help.isEmpty() && help.peek().intValue() > current) {
				stack.push(help.pop());
			}
			help.push(current);
		}
		while (!help.isEmpty()) {
			stack.push(help.pop());
		}
	}
}
