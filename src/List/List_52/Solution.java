package List.List_52;

import Utils.ListNode;
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2){
        if(pHead1 == null || pHead2 == null){
            return null;
        }

        ListNode result = null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        //获取两个链表的长度
        int length1 = 0;
        int length2 = 0;
        while(p1 != null){
            p1 = p1.Next;
            length1++;
        }
        while(p2 != null){
            p2 = p2.Next;
            length2++;
        }
        p1 = pHead1;
        p2 = pHead2;

        if(length1 >= length2){
            int diff = length1 - length2;
            for (int i = 0; i < diff; i++) {
                p1 = p1.Next;
            }

            while (p1 != null){
                if(p1.Value == p2.Value){
                    result = p1;
                    break;
                }
                p1 = p1.Next;
                p2 = p2.Next;
            }
        }

        if(length1 < length2){
            int diff = length2 - length1;
            for (int i = 0; i < diff; i++) {
                p2 = p2.Next;
            }

            while (p2 != null){
                if(p1.Value == p2.Value){
                    result = p2;
                    break;
                }
                p1 = p1.Next;
                p2 = p2.Next;
            }
        }
        return result;
    }
}
