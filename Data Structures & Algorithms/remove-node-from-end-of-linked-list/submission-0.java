/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int nodes = 0;
        ListNode temp = head;
        while (temp != null) {
            nodes += 1;
            temp = temp.next;
        }
        int index = nodes - n;
        temp = head;
        ListNode prev = null;
        while (index > 0) {
            prev = temp;
            temp = temp.next;
            index -= 1;
        }
        if (prev != null) {
            prev.next = temp.next;
            return head;
        }
        return temp.next;
    }
}
