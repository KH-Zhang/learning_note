package List.List_22;

import Utils.ListNode;

public class Solution {
    public ListNode FindKthToTail(ListNode head, int k){

        ListNode p1 = new ListNode();
        ListNode p2 = new ListNode();

        //考虑边界问题
        if(head == null || k == 0){
            return null;
        }

        p1 = head;
        p2 = p1;
        for (int i = 0; i < k -1; i++) {
            p2 = p2.Next;

            //考虑边界条件
            if(p2 == null){
                return null;
            }
        }
        while(p2.Next != null){
            p1 = p1.Next;
            p2 = p2.Next;
        }
        return p1;
    }
}
