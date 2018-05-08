package zychaowill.datastructure.research;

import java.util.Stack;
import java.util.stream.Collectors;

public class ReverseStackOnlyUsingRecursiveExample {
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		new ReverseStackOnlyUsingRecursive().reverse(stack);
		String result = stack.stream().map(String::valueOf).collect(Collectors.joining(","));
		System.out.println("result:" + result);
	}
}
