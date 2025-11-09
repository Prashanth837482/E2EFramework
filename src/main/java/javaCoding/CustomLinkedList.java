package javaCoding;

class CustomLinkedList1 {
    Node head;

    // Node class (inner static for simplicity)
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Add node at the end
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode; // first node becomes head
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    //https://chatgpt.com/c/6906f0ec-2d68-8322-bbff-11a5262ba1cc
    // find element using two pointer approach
    public void findMiddleElement() {
    	
    	Node slow = head;
    	Node fast = head;
    	while(fast!=null && fast.next!=null) {   // This condition is to get the upper middle element when linked list contains even length. ex: 10,20,30,40 output: 30
    //  while(fast!=null && fast.next.next!=null) {   // This condition is to get the lower middle element when linked list contains even length. ex: 10,20,30,40 output: 20		
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	System.out.println("Middle element in linked list is: "+slow.data);
    	
    }
    
    // https://chatgpt.com/c/6906f420-5780-8322-8216-c3e2a1e9b646
    public void reverseLinkedList() {
    	Node prev = null;
    	Node current = head;
    	while(current!=null) {
    		Node next = current.next;   // Store next node
    		current.next = prev;  // Reverse the link by pointing current node's next to previous one
    		prev = current;      // Move prev forward -> this current will become prev for next element or node	
    		current = next;      // Move current forward -> to traverse until the end of original linked lsit
    	}
    	head = prev;  // New head after reversal
    	printList();
    }
}

public class CustomLinkedList {
    public static void main(String[] args) {
        CustomLinkedList1 list = new CustomLinkedList1();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        list.printList();
        
        list.findMiddleElement();
        list.reverseLinkedList();
    }
}

