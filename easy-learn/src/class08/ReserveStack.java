package class08;

import java.util.Stack;

/**
 * 不利用数据结构逆序一个栈
 */

public class ReserveStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.forEach(System.out::println);
        resverse(stack);
        System.out.println("逆序后");
        stack.forEach(System.out::println);
    }

    public static int StackBottom(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int number = StackBottom(stack);
            stack.push(result);
            return number;
        }
    }

    public static void resverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = StackBottom(stack);
        resverse(stack);
        stack.push(i);
    }
}
