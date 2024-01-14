package List.LIst_23;

import Utils.List;
import Utils.ListNode;

public class test {
    public static void main(String[] args) {
        List list = new List();
        ListNode node1 = list.createListNode(1);
        ListNode node2 = list.createListNode(2);
        ListNode node3 = list.createListNode(3);
        ListNode node4 = list.createListNode(4);
        ListNode node5 = list.createListNode(5);
        ListNode node6 = list.createListNode(6);

        list.connectListNode(node1,node2);
        list.connectListNode(node2,node3);
        list.connectListNode(node3,node4);
        list.connectListNode(node4,node5);
        list.connectListNode(node5,node6);
        list.connectListNode(node6,node3);

        Solution su = new Solution();
        ListNode listNode = su.EntryNodeOfLoop(node1);
        System.out.println(listNode.Value);


    }
}
