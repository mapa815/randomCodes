/*
PROBLEM STATEMENT

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
The replacement must be in place and use only constant extra memory.

Example 1:
Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:
Input: nums = [3,2,1]
Output: [1,2,3]

Example 3:
Input: nums = [1,1,5]
Output: [1,5,1]

Example 4:
Input: nums = [1]
Output: [1]
*/
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1)
            return;
        int i = nums.length -1;
        while(i > 0 && nums[i-1] >= nums[i]){
            i--;
        }
        
        reverse(nums, i);
        if(i == 0) //Next Permutation not possible
            return;
        int swapIndex = binarySearch(nums, i , nums.length-1, nums[i-1]); // Pick num greater than nums[i-1]
        swap(nums, swapIndex, i-1);
    }
    
    public void reverse(int[] nums, int start){
        int half = start + (nums.length - start)/2;
        int end = nums.length-1;
        while(start < half){
            swap(nums, start , end);
            start++;
            end--;
        }
    }
    
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public int binarySearch(int[] nums, int start , int end, int find){
        while(start < end){
            int mid = start + (end - start)/2;
            if(nums[mid] > find){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        
        return start;
    }
}
