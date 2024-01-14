package Utils;

public class List {

    public ListNode createListNode(int value){
        ListNode node = new ListNode();
        node.Value = value;
        node.Next = null;
        return node;
    }

    public void connectListNode(ListNode current,ListNode next){
        if(current == null){
            System.out.println("Error to connect two node");
        }
        current.Next = next;
    }

    public void printListNode(ListNode node){
        if(node == null){
            System.out.println("the node is null");
        }else{
            System.out.println("the value of the node is :" + node.Value);
        }
    }

    public void printList(ListNode head){
        ListNode node = head;
        while(node != null){
            System.out.println(node.Value);
            node = node.Next;
        }
    }

    /*//删除函数需要重新考虑
    void destoryList(ListNode head){
        ListNode node = head;
        while(node != null){
            head = head.Next;
            node = null;
            node = head;
        }
    }*/

    public void add(ListNode head){

    }

    public void removeNode(ListNode head,int value){
        if(head == null){
            return ;
        }
        ListNode toBeDelete = null;
        if(head.Value == value){
            toBeDelete = head;
            head = head.Next;
        }else{
            ListNode node = head;
            while(node.Next != null && node.Next.Value != value){
                node = node.Next;
            }
            if(node.Next != null && node.Next.Value == value){
                toBeDelete = node.Next;
                node.Next = node.Next.Next;
            }

        }
        
    }

}
