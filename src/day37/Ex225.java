package day37;

/*请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
        实现 MyStack 类：
        void push(int x) 将元素 x 压入栈顶。
        int pop() 移除并返回栈顶元素。
        int top() 返回栈顶元素。
        boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。*/

import java.util.LinkedList;
import java.util.Queue;

public class Ex225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}

class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    //    入栈时，先将元素入队，然后将队头元素出队并入队，直到队头元素为入队元素。
    public void push(int x) {
        queue.offer(x);
        int size = queue.size();
        while (size-- > 1)
            queue.offer(queue.poll());

    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}