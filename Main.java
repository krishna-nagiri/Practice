// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        
        
        Main m = new Main();
        Main.printLinkedList(m.reverseNode(head));
       
    }
    public static Node mergeSortLogic(Node head){
        if(head == null || head.next == null) return head;


        return head;
    }
    public static void printLinkedList(Node head){
    if(head == null){
        return;
    }
    if(head.next != null){
        System.out.print(head.data +"->");
    }
    if(head.next == null){
        System.out.print(head.data);
    }
    
    printLinkedList(head.next);
}
public Node reverseNode(Node head){
    if(head == null || head.next == null){
        return head;
    }
    Node newHead = reverseNode(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
}
private  Node getMiddle(Node head){
    if(head == null || head.next == null){
        return head;
    }
    Node slow = head;
    Node fast = head.next;

    while(fast != null || fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
}
class Node{
    int data;
    Node next;
    
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
