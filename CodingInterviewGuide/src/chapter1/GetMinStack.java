package chapter1;

import java.util.Stack;

/**
 * 自定义stack，有一个返回最小值的方法
 */

public class GetMinStack {
    public static void main(String[] args) {
        MyStack2 stack = new MyStack2();
        stack.push(3);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.getMin());
    }

    //method 1
    public static class MyStack1 {
        Stack<Integer> stackData;
        Stack<Integer> stackMin;

        public MyStack1() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(Integer number) {
            if (stackMin.isEmpty()) {
                stackMin.push(number);
            } else if (number <= getMin()) {
                stackMin.push(number);
            }
            stackData.push(number);
        }


        public Integer pop() {
            Integer value = stackData.pop();
            if (value == getMin()) {
                stackMin.pop();
            }
            return value;
        }


        public Integer getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("栈为空");
            }
            return stackMin.peek();
        }
    }

    //method 2
    public static class MyStack2 {
        Stack<Integer> stackData;
        Stack<Integer> stackMin;

        public MyStack2() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(Integer number) {
            if (stackMin.isEmpty()) {
                stackMin.push(number);
            } else if (number <= getMin()) {
                stackMin.push(number);
            } else if (number > getMin()) {
                stackMin.push(getMin());
            }
            stackData.push(number);
        }


        public Integer pop() {
            stackMin.pop();
            return stackData.pop();
        }


        public Integer getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("栈为空");
            }
            return stackMin.peek();
        }
    }
}
