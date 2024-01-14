package Stack.Stack_09;

import java.util.Stack;

/*
    此题有误解
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.peek());
            stack1.pop();
        }
        return stack2.peek();
    }
}
