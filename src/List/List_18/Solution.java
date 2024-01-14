package List.List_18;

import Utils.ListNode;



//需要对比考虑边界问题


public class Solution {
    public ListNode deleteDuplication(ListNode pHead){
        ListNode p =pHead;
        ListNode first = new ListNode();
        ListNode last = new ListNode();
        first.Next = pHead;
        last = first;
        while (p.Next != null){   // p != null
            if(p.Value == p.Next.Value){
                int val = p.Value;
                while(p!= null && p.Value == val){ // p != null
                    p = p.Next;
                }
                last.Next = p;
            }else{
                last = p;
                p = p.Next;
            }
        }
        return first.Next;
    }


}
