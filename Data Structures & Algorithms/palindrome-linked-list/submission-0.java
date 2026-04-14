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
    public boolean isPalindrome(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode currNode = slow;
        ListNode prev = null;

        while(currNode != null)
        {
            ListNode next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;
        }

        ListNode p1 = head;
        ListNode p2 = prev;

        while(p2 != null)
        {
            if(p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;

    }
}



