package List.LIst_23;

import Utils.List;
import Utils.ListNode;

public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null){
            return null;
        }

        ListNode oneonde = oneonde(pHead);
        if(oneonde == null){
            return null;
        }

        int val = oneonde.Value;
        int count = 1;
        while(oneonde.Next.Value != val){
            oneonde = oneonde.Next;
            count++;
        }

        ListNode p1 = pHead;
        ListNode p2 = pHead;
        for (int i = 0; i < count -1; i++) {
            p2 = p2.Next;
        }
        while(p1.Value != p2.Next.Value){
            p1 = p1.Next;
            p2 = p2.Next;
        }

        return p1;
    }

    private ListNode oneonde(ListNode pHead){

        ListNode p1 = pHead;
        ListNode p2 = pHead.Next;

        while(p1 != null && p2 != null){
            if(p1.Value == p2.Value){
                return p1;
            }
            p1 = p1.Next;
            p2 = p2.Next;

            p2 = p2.Next;

            /*//重点
            if(p2 != null){
                p2 = p2.Next;
            }*/
        }
        return null;
    }
}
