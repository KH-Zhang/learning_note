package Stack.Stack_30;

import java.util.Stack;

public class Solution {

    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> minItem = new Stack<>();
    public void push(int node) {
        data.push(node);
        if(minItem.peek() > node || minItem.isEmpty()){//其中 || 运算符有先后顺序
            minItem.push(node);
        }else{
            minItem.push(minItem.peek());
        }
    }
    public void pop() {
        data.pop();
        minItem.pop();
    }

    public int top() {
        return minItem.peek();
    }

    public int min() {
        return minItem.peek();
    }
}
