package List.LIst_25;

import Utils.ListNode;

public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2){
        ListNode result = null;
        if(list1 == null && list2 == null){
            return result;
        }
        if(list1 == null && list2 != null){
            return list2;
        }
        if(list1 != null && list2 == null){
            return list1;
        }

        if(list1.Value <= list2.Value){
            result = list1;
            result.Next = Merge(list1.Next,list2);
        }else{
            result = list2;
            result.Next = Merge(list1,list2.Next);
        }

        return result;

    }
}
