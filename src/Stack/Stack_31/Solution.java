package Stack.Stack_31;

import java.util.Stack;

/*
    入栈1,2,3,4,5
    出栈4,5,3,2,1
    首先1入辅助栈，此时栈顶1≠4，继续入栈2
    此时栈顶2≠4，继续入栈3
    此时栈顶3≠4，继续入栈4
    此时栈顶4＝4，出栈4，弹出序列向后一位，此时为5，,辅助栈里面是1,2,3
    此时栈顶3≠5，继续入栈5
    此时栈顶5=5，出栈5,弹出序列向后一位，此时为3，,辅助栈里面是1,2,3
    ...
    依次执行，最后辅助栈为空。如果不为空说明弹出序列不是该栈的弹出顺序。
 */
public class Solution {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> s = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            s.push(pushA[i]);
            while(!s.isEmpty() && s.peek() == popA[j]){
                s.pop();
                j++;
            }
        }
        return s.isEmpty();
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] arr2 = {4,5,3,2,1};
        IsPopOrder(arr,arr2);
    }
}
