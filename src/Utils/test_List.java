package Utils;

public class test_List {
    public static void main(String[] args) {
        List list = new List();
        ListNode node1 = list.createListNode(1);
        ListNode node2 = list.createListNode(2);
        ListNode node3 = list.createListNode(3);
        ListNode node4 = list.createListNode(4);
        ListNode node5 = list.createListNode(5);

        list.connectListNode(node1,node2);
        list.connectListNode(node2,node3);
        list.connectListNode(node3,node4);
        list.connectListNode(node4,node5);

        list.printList(node1);
    }
}
