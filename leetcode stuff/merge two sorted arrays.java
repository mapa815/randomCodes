/*
PROBLEM STATEMENT

Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
*/

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //preliminary conditions
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        
        //defining the head and tail 
        //head of the resultant list will be that hed which is smaller and same for tail.
        
        ListNode head=null,tail=null;
        if(l1.val<=l2.val){
            head=tail=l1;
            l1=l1.next;      //moving l1 one step ahead of the head and tail
        }
        else{
            head=tail=l2;
            l2=l2.next;          //moving l2 one step ahead of the head and tail
        }
        
        /* we will iterate the 'head' and 'tail' pointers till
        they both become null simultaneously */
        while(l1!=null && l2!=null){
            
            /*if the value of current head of 1st list is is smaller 
            thn the val of the head of 2nd list,thn
            point next of tail to the curr head of 1st list 
            & update tail and head */
            
            if(l1.val<=l2.val){
                tail.next=l1;
                tail=l1;
                l1=l1.next;
            }
            else{
                tail.next=l2;
                tail=l2;
                l2=l2.next;
            }
        }
        
        /* if either of the heads become null.
        point next of tail to the head of other list. */
        if(l1==null){
            tail.next=l2;
        }
        else{
            tail.next=l1;
        }
        return head;                 //return head
    }
}
