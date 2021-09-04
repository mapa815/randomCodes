/*
PROBLEM STATEMENT

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, 
and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:
Input: nums = []
Output: []
Example 3:
Input: nums = [0]
Output: []
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(nums.length<3){
            return result;
        }
        
        if(nums.length==3){
        
            if(nums[0]+nums[2]+nums[1]==0){
            
                result.add(Arrays.asList(nums[0],nums[1],nums[2]));
                return result;
            }
            
            else{
                return result;
            }
        }
        
        Arrays.sort(nums);
        int index =-1;
        
        for(int i =0; i<nums.length-2;i++){
            
            int s1 = -nums[i];// storing 1st element in a variable and adding 2 elements whose sum is samein magnitude but diff in sign to s1
            int front = i+1;
            int back = nums.length-1;
            
            while(front<back){
                int s2 = nums[front]+nums[back];
                if(s2>s1){
                    back--;
                }
                else if (s2<s1)
                    front++;
                else{
                    index++;
                    result.add(Arrays.asList(nums[i],nums[front],nums[back]));
                    
                    while(front<back && result.get(index).get(1)==nums[front]) // if these loops were not applied then the while looop will run for infinity
                        front++;
                    
                    while(front<back && result.get(index).get(2)==nums[back])
                        back--;
                }
            }
            
            while(i<nums.length-2 && nums[i]==nums[i+1])// if same element is repeated in s1 then it will ignore it so that our result will not contain repeated list
                i++;
        }
        return result;
    }
}
