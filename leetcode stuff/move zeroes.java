/*
PROBLEM STATEMENT

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.
*/

public class Solution {
	public void moveZeroes(int[] nums) {
		int len = nums.length;
		int first = 0;
		int second = 1;
		while (first < len && second < len) {
			if (nums[first] == 0 && nums[second] == 0) second++;
			else if (nums[first] == 0 && nums[second] !=0) {
				nums[first] = nums[second];
				nums[second] = 0;
				first++;
				second++;
			} else {
				first++;
				second++;
			}
		}
		
		for (int e : nums) System.out.println(e);
	}
}
