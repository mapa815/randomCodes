/*
PROBLEM STATEMENT

Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. 
For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1
*/
class Solution {
public:
    int dp[2502];
    int solve(vector<int>& nums, int prev, int idx){
        if(idx==nums.size()) return 0;
        if(dp[idx] != -1) return dp[idx];

        int curSum = 0, maxSum = 0;
        for(int i=idx; i<nums.size(); ++i){
            if(nums[i]>prev){
                curSum=max(1+solve(nums,nums[i],i+1), solve(nums,prev,i+1));
            }
            maxSum = max(maxSum,curSum);
        }
        return dp[idx] = maxSum;
    }
    
    int lengthOfLIS(vector<int>& nums) {
        memset(dp,-1,sizeof(dp));
        return solve(nums,INT_MIN,0);
    }
};
