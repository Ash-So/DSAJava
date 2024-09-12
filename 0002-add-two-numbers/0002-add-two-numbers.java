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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // O(max(t1, t2)) O(max(t1, t2))
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        int carry = 0;

        while(t1 != null || t2 != null || carry == 1){
            int v1 = (t1 != null) ? t1.val : 0;
            int v2 = (t2 != null) ? t2.val : 0;

            int sum = v1 + v2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            curr.next = newNode;
            curr = curr.next;

            if(t1 != null) t1 = t1.next;
            if(t2 != null) t2 = t2.next;
        }

        return dummyHead.next;
    }
}