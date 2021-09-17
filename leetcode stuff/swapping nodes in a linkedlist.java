/*
PROBLEM STATEMENT

You are given the head of a linked list, and an integer k.
Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]

Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]

Example 3:

Input: head = [1], k = 1
Output: [1]

Example 4:

Input: head = [1,2], k = 1
Output: [2,1]

Example 5:

Input: head = [1,2,3], k = 2
Output: [1,2,3]
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
class Solution {
    public ListNode swapNodes(ListNode head, int k)
    {
        if(head==null || head.next==null) return head;

        ListNode temp=head;
        int count=1;
        ListNode f=null;
        ListNode l=null;
        while(temp!=null)
        {
            temp=temp.next;
            count++;
        }
        int last=count-k;
        count=1;
        temp=head;
        while(temp!=null)
        {
            if(count==k)
            {
               f=temp;
            }
            if(count==last)
            {
               l=temp;

            }
            temp=temp.next;
            count++;
        }
        count=f.val;
        f.val=l.val;
        l.val=count;
        return head;
    }
}
