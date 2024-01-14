package List.List_18;

import Utils.List;
import Utils.ListNode;

public class test {
    public static void main(String[] args) {
        List list = new List();
        ListNode node1 = list.createListNode(1);
        ListNode node2 = list.createListNode(2);
        ListNode node3 = list.createListNode(3);
        ListNode node4 = list.createListNode(3);
        ListNode node5 = list.createListNode(4);
        ListNode node6 = list.createListNode(4);
        ListNode node7 = list.createListNode(5);

        list.connectListNode(node1,node2);
        list.connectListNode(node2,node3);
        list.connectListNode(node3,node4);
        list.connectListNode(node4,node5);
        list.connectListNode(node5,node6);
        list.connectListNode(node6,node7);

        Solution su =new Solution();
        ListNode listNode = su.deleteDuplication(node1);
        list.printList(listNode);
    }
}
