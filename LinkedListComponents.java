
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

import java.util.*;

public class LinkedListComponents {
    /**
     * @param head: the head
     * @param g:    an array
     * @return: the number of connected components in G
     */
    public int numComponents(ListNode head, int[] g) {
        // Write your code here
        Set<Integer> gSet = new HashSet<>();
        for (int i : g) {
            gSet.add(i);
        }
        int numComponents = 0;
        ListNode current = head;
        while (current != null) {
            if (gSet.contains(current.val)) {
                numComponents++;
                while (current != null && gSet.contains(current.val)) {
                    gSet.remove(current.val);
                    current = current.next;
                }
            } else {
                current = current.next;
            }
        }
        return numComponents;
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