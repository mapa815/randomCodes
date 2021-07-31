/*
PROBLEM STATEMENT

Given a sorted array of distinct integers and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
*/
class Solution {
    public int searchInsert(int[] nums, int t) {
        int s=0;
        int e=nums.length-1;
        int m=0;
        
        while(s<nums.length && e>=0 && nums[s] <= nums[e]) {
            m = s+(e-s)/2;
            if(nums[m]<t) {
                s=m+1;
            } else if(nums[m]==t) {
                return m;
            } else if(nums[m]>t) {
                e=m-1;
            }
        }
        return e+1;
    }
}
