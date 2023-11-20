import java.util.*;
import java.math.*;
import java.lang.*;

class Node {
    int data;
    Node next; // This is a reference to the next node in the linked list. It represents the
               // connection between nodes.

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // Method to insert at Beginning.
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data); // calling Node constructor.
        newNode.next = head; // Moving the head.
        head = newNode; // assigning the newNode value to head node.
        System.out.println("Done!");
    }

    // Method to insert at End.
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            System.out.println("Done!");
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            System.out.println("Done!");
        }
    }

    // Method to insert in between.
    public void insertInBetween(int data, int position) {
        Node newNode = new Node(data);
        if (position <= 0) {
            System.out.println("Invalid position must be greater than 0");
            return;
        }
        if (position == 1) {
            newNode.next = head;
            head = newNode; // assigning the value to head.
            System.out.println("Done!");
        } else {
            Node current = head;
            int currentPostion = 1;
            while (current != null && currentPostion < position - 1) {
                current = current.next;
                currentPostion++;
            }
            System.out.println("Done!");
            if (current == null) {
                System.out.println("position invlaid. Exceeds the limit.");
            } else {
                newNode.next = current.next;
                current.next = newNode;
                System.out.println("Done!");
            }

        }
    }

    // Method to Display the list.
    public void display() {
        System.out.print("Displaying results.....= \t");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " \t");
            current = current.next;
        }
        System.out.println();
    }

    // Method to perform bubble sort on data displayed.
    public void bubbleSort() {
        if (head == null || head.next == null) {
            return; // already sorted.
        }
        boolean swapped;
        Node current;
        Node tail = null;
        do {
            swapped = false;
            current = head;
            while (current.next != tail) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
            tail = current;
        } while (swapped);
    }

    // Method to Delete from Beginning.
    public void removeBeginning() {
        if (head != null) {
            head = head.next;
            System.out.println("Done!");
        } else {
            System.out.println("List is empty. Cannot remove any element.");
        }
    }

    // Method to Delete at End.
    public void removeEnd() {
        if (head == null) {
            System.out.println("List is empty . Cannot remove any element.");
            return;
        }
        if (head.next == null) {
            head = null;
            System.out.println("Done!");
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
            System.out.println("Done!");
        }
    }

    // Method to delete a specific value.
    public void removSpec(int specvalue) {
        if (head == null) {
            System.out.println("List is empty . Cannot remove any element.");
            return;
        }
        if (head.data == specvalue) {
            head = head.next;
            System.out.println("Done!");
            return;
        } else {
            Node current = head;
            while (current.next != null && current.next.data != specvalue) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
            } else {
                System.out.println("Value not found in list.");
            }
        }
    }

    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        Scanner sc = new Scanner(System.in);
        boolean mainMenu = true;
        // MAIN MENU
        while (mainMenu) {
            System.out.println(
                    "*********MAIN MENU*********  \n 1. Insert \n 2.Display \n 3.Delete \n 4.Exit \n Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("**********Insert**********");
                    boolean submenu = true;
                    // SUBMENU
                    while (submenu) {
                        System.out.println("Enter the value to be inserted : ");
                        int value = sc.nextInt();
                        System.out.println(
                                "Enter the position where you want to insert \n 1. At Beginning \n 2. At End \n 3. In Between \n 4.Back\n Enter your choice: ");
                        int choice1 = sc.nextInt();
                        switch (choice1) {
                            case 1:
                                ls.insertAtBeginning(value);
                                break;
                            case 2:
                                ls.insertAtEnd(value);
                                break;
                            case 3:
                                System.out.println("Enter the  value at which you have to insert the value: ");
                                int pos1 = sc.nextInt();
                                ls.insertInBetween(value, pos1);
                                break;
                            case 4:
                                submenu = false; // breaks out of subMenu.
                                break;
                        }
                    }
                    continue;
                case 2:
                    System.out.println("**********Display**********");
                    ls.display(); // displays the list.
                    System.out.println("Do you want to sort the list? (Y/N): ");
                    char sort = sc.next().charAt(0);
                    if (sort == 'Y' || sort == 'y') {
                        ls.bubbleSort();
                    } else {
                        System.out.println("OK");
                    }
                    System.out.println("*****SORTED LIST*****");
                    ls.display();
                    break;
                case 3: // Delete
                    System.out.println("**********Delete**********");
                    System.out.println(
                            "How do you want to delete? \n 1. From Beginning \n 2. From End \n 3. Specific \n Enter your choice :");
                    int choice2 = sc.nextInt();
                    switch (choice2) {
                        case 1:
                            ls.removeBeginning();
                            break;
                        case 2:
                            ls.removeEnd();
                            break;
                        case 3:
                            System.out.println("Enter the value you want to delete: ");
                            int delvalue = sc.nextInt();
                            ls.removSpec(delvalue);
                        default:
                            break;
                    }
                    break;
                case 4:
                    System.out.println("**********EXIT**********");
                    mainMenu = false; // breaks out of Main Menu.
                    break;
            }

        }
        sc.close();
    }
}