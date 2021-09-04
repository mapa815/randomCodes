/*
PROBLEM STATEMENT

Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:
Input: nums = [0,0,0], target = 1
Output: 0
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length-1];
        Arrays.sort(nums);

        for (int start = 0; start < nums.length - 2; start++) {
            int middle = start + 1;
            int end = nums.length - 1;
            
            while (middle < end) {
                int sum = nums[start] + nums[middle] + nums[end];  
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                     while(middle<end && nums[end] == nums[end-1]) end--;
                     end--;
                } else {
                    while(middle<end && nums[middle] == nums[middle+1]) middle++;
                    middle++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
