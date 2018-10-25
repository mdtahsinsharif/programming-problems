import java.util.LinkedList;

public class LinkedListClass{
    static int i = 10;
    static HelloNode head;

    static class HelloNode{
        int data;
        HelloNode next;

        HelloNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static HelloNode reverse_list(HelloNode n){
        HelloNode temp = n;
        HelloNode prev = null;
        HelloNode next = null;
        while(temp!=null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    public static void printList(HelloNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String []args) {
        LinkedListClass list = new LinkedListClass();
        list.head = new HelloNode(10);
        list.head.next = new HelloNode(20);
        list.head.next.next = new HelloNode(30);
        list.head.next.next.next = new HelloNode(40);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverse_list(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }



}
