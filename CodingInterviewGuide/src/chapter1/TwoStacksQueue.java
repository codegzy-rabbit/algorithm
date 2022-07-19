package chapter1;

import java.util.Stack;

/**
 * 两个栈构成一个队列
 */

public class TwoStacksQueue {
    private Stack<Element> stackPush;
    private Stack<Element> stackPop;

    public TwoStacksQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void push(Element item) {
        stackPush.push(item);
    }

    public Element pop() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("某个栈为空");
        }
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public Element peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("某个栈为空");
        }
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }
}
