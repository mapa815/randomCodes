/*
PROBLEM STATEMENT

Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

The steps of the insertion sort algorithm:
Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
It repeats until no input elements remain.
The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. 
One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
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
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        int count=1;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        
        int [] arr=new int[count-1];
        temp=head;
        for(int i=0;i<count-1;i++){
            arr[i]=temp.val;
            temp=temp.next;
        }
        
        for(int i=1;i<count-1;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
        ListNode newHead=new ListNode(arr[0]);
        ListNode trav=newHead;
        int i=1;
        while(count-1>i){
            trav.next=new ListNode(arr[i]);
            trav=trav.next;
            i++;
        }
        return newHead;
    }
}
