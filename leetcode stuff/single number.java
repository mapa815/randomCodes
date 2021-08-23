/*
PROBLEM STATEMENT


*/
class Solution {
    public int singleNumber(int[] nums) 
    {         
        int singleNum = 0;
        for(int i = 0; i < nums.length; i++)
            singleNum ^= nums[i];
        return singleNum;
    }
}
