package List.List_06;

import Utils.ListNode;
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> sc = new Stack<>();
        if(listNode == null){
            return result;
        }

        while(listNode !=null){
            sc.push(listNode.Value);
            listNode = listNode.Next;
        }

        while (!sc.isEmpty()){
            result.add(sc.pop());
        }

        return result;
    }
}
