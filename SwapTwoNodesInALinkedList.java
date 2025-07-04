/**
 * Definition for ListNode
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

public class SwapTwoNodesInALinkedList {
    /**
     * @param head: a ListNode
     * @param v1:   An integer
     * @param v2:   An integer
     * @return: a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // write your code here
        ListNode n1 = findNode(head, v1);
        ListNode n2 = findNode(head, v2);
        if (n1 == null || n2 == null) {
            return head;
        }
        if (getIndex(head, n2) < getIndex(head, n1)) {
            ListNode temp = n1;
            n1 = n2;
            n2 = temp;
        }
        ListNode n1Prev = findPrevNode(head, n1);
        ListNode n1Next = n1.next;
        ListNode n2Prev = findPrevNode(head, n2);
        ListNode n2Next = n2.next;
        n1.next = n2Next;
        if (n2Prev == n1) {
            n2.next = n1;
        } else {
            n2.next = n1Next;
            if (n2Prev != null) {
                n2Prev.next = n1;
            }
        }
        if (n1Prev != null) {
            n1Prev.next = n2;
        } else {
            head = n2;
        }
        return head;
    }

    private ListNode findNode(ListNode head, int value) {
        ListNode node = head;
        while (node != null && node.val != value) {
            node = node.next;
        }
        return node;
    }

    private ListNode findPrevNode(ListNode head, ListNode node) {
        if (node == head) {
            return null;
        }
        ListNode prev = head;
        while (prev != null && prev.next.val != node.val) {
            prev = prev.next;
        }
        return prev;
    }

    private int getIndex(ListNode head, ListNode node) {
        int i = 0;
        ListNode n = head;
        while (n != null && n != node) {
            i++;
            n = n.next;
        }
        if (n == null) {
            return -1;
        }
        return i;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}