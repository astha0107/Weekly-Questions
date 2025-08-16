import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class deep_clone_linkedlist {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        
        return map.get(head);
    }
    public void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            int randomVal = (curr.random != null) ? curr.random.val : -1;
            System.out.println("Node(" + curr.val + ") Random → " + randomVal);
            curr = curr.next;
        }
    }
    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        deep_clone_linkedlist solution = new deep_clone_linkedlist();
        Node clonedHead = solution.copyRandomList(n1);

        System.out.println("Original List:");
        solution.printList(n1);
        System.out.println("\nCloned List:");
        solution.printList(clonedHead);
    }
}
