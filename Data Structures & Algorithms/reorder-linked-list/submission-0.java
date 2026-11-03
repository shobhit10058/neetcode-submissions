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
    public void reorderList(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            listNodes.add(temp);
            temp = temp.next;
        }
        temp = head;
        int st = 1, end = listNodes.size() - 1;
        boolean pointer = true;
        while (st <= end) {
            if (pointer) {
                temp.next = listNodes.get(end);
                temp = listNodes.get(end);
                end -= 1;
            } else {
                temp.next = listNodes.get(st);
                temp = listNodes.get(st);
                st += 1;
            }
            pointer = !pointer;
        }
        if (temp != null) {
            temp.next = null;
        }
    }
}
