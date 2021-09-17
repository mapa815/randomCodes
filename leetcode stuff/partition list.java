/*
PROBLEM STATEMENT

Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:
Input: head = [2,1], x = 2
Output: [1,2]
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
    public ListNode partition(ListNode head, int x) {
        ListNode head2 = new ListNode();
        var temp = head2;
        var itt = head;
        while(itt != null){
            if(itt.val < x){
                temp.next = new ListNode(itt.val);
                temp = temp.next;
                itt.val = -101;
            }
            itt = itt.next;
        }
        while(head != null){
            if(head.val >= x && head.val != -101){
                temp.next = new ListNode(head.val);
                temp = temp.next;
            }
            head = head.next;
        }
        return head2.next;
    }
}
