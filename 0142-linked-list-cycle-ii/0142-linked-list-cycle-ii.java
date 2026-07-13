/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // reached meeting point 
                slow = head; // reset the slow's position to start while keeping the fast at meeting point 
                while (slow != fast) {
                    // now both are moving at same speed
                    slow = slow.next; 
                    fast = fast.next;
                }
                return slow; // or fast as both are pointing to the same spot
            }
        }

        return null;
    }
}