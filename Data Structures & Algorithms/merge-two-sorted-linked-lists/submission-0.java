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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode temp = null;
        while (list1 != null && list2 != null) {
            int currVal = 0;
            if (list1.val < list2.val) {
                currVal = list1.val;
                list1 = list1.next;
            } else {
                currVal = list2.val;
                list2 = list2.next;
            }
            if (head == null) {
                head = new ListNode(currVal);
                temp = head;
            } else {
                ListNode currNode = new ListNode(currVal);
                temp.next = currNode;
                temp = currNode;
            }
        }
        if (list1 != null) {
            if (temp == null) {
                head = list1;
            } else {
                temp.next = list1;
            }
        }
        if (list2 != null) {
            if (temp == null) {
                head = list2;
            } else {
                temp.next = list2;
            }
        }
        return head;
    }
}