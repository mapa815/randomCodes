/*
PROBLEM STATEMENT

Given a linked list, swap every two adjacent nodes and return its head. 
You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:

Input: head = [1,2,3,4]
Output: [2,1,4,3]

Example 2:

Input: head = []
Output: []

Example 3:

Input: head = [1]
Output: [1]
*/
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
public class Solution {
    public ListNode swapPairs(ListNode A) {
        if(A== null || A.next == null)
            return A;
        ListNode tmp = A;
        ListNode p1 = A;
        ListNode p2 = A.next;
        ListNode start = p2;
        ListNode prev = null;
        while(true)
        {
            ListNode next = p2.next;
            p1.next = next;
            p2.next = p1;
            if(prev!=null)
                prev.next = p2;
            prev = p1;
            p1 = next;
            if(p1 == null)
                break;
            p2 = p1.next;
            if(p2 == null)
                break;
        }
        
        return start;
    }
}
