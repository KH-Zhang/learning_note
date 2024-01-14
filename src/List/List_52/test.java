package List.List_52;

import Utils.List;
import Utils.ListNode;

public class test {
    public static void main(String[] args) {

        List list = new List();
        ListNode node1 = list.createListNode(1);
        ListNode node2 = list.createListNode(2);
        ListNode node3 = list.createListNode(3);
        ListNode node4 = list.createListNode(6);
        ListNode node5 = list.createListNode(7);
        list.connectListNode(node1,node2);
        list.connectListNode(node2,node3);
        list.connectListNode(node3,node4);
        list.connectListNode(node4,node5);


        List list1 = new List();
        ListNode node11 = list.createListNode(4);
        ListNode node22 = list.createListNode(5);
        ListNode node33 = list.createListNode(6);
        ListNode node44 = list.createListNode(7);

        list1.connectListNode(node11,node22);
        list1.connectListNode(node22,node33);
        list1.connectListNode(node33,node44);

        Solution su = new Solution();
        ListNode listNode = su.FindFirstCommonNode(node1, node11);
        System.out.println(listNode.Value);

    }
}
