package List.List_24;

import Utils.ListNode;

public class Solution {
    public ListNode ReverseList(ListNode head){
        ListNode pre = null;
        ListNode node = head;
        ListNode result = null;
        if(head == null){
            return result;
        }


        while (node != null){
            ListNode next = node.Next;

            if(next == null){
                result = node;
            }

            //注意反转链表的步骤顺序
            node.Next = pre;
            pre = node;
            node = next;
        }
        return result;



    }
}
