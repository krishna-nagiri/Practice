class ListNode {
    int val;
    ListNode next;
}
public class LinkedList {

    public static ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        return getMiddle(head); 
    }
    public static ListNode getMiddle(ListNode head){
        if(head == null || head.next == null)  return head;

        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }
    public static void main(String[] args){
        ListNode head = new ListNode();
        head.val = 1;
        ListNode newNode = new ListNode();
        newNode.val = 2;
        head.next = newNode;
        ListNode tempHead =  middleNode(head);
        while (tempHead != null) {
            System.out.print(tempHead.val + " -> ");
            if(tempHead.next == null) System.out.print("null");
            tempHead = tempHead.next;
        } 
    }
}