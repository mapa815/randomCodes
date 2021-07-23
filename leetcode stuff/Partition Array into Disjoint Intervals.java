/*
PROBLEM STATEMENT

Given an array nums, partition it into two (contiguous) subarrays left and right so that:

Every element in left is less than or equal to every element in right.
left and right are non-empty.
left has the smallest possible size.
Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.
*/

class Solution {
    public int partitionDisjoint(int[] nums) {
        int maxLeft = nums[0];
        int max = nums[0];
        int p = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<maxLeft){
                maxLeft = max;
                p=i;
            } else if(max<nums[i]) {
                max=nums[i];
            }
        }
        
        return p+1;
    }
}
