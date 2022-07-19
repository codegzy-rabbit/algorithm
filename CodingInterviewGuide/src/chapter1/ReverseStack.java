package chapter1;

import java.util.Stack;

/**
 * 不使用其他数据结构逆序一个栈
 */

public class ReverseStack {


    public int getBottomItem(Stack<Integer> stack) {
        int res = stack.pop();
        if (stack.isEmpty()) {
            return res;
        } else {
            int i = getBottomItem(stack);
            stack.push(res);
            return i;
        }
    }

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getBottomItem(stack);
        reverse(stack);
        stack.push(i);
    }

}
