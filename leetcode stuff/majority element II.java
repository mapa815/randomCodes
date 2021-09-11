/*
PROBLEM STATEMENT

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
Follow-up: Could you solve the problem in linear time and in O(1) space?

Example 1:

Input: nums = [3,2,3]
Output: [3]

Example 2:

Input: nums = [1]
Output: [1]

Example 3:

Input: nums = [1,2]
Output: [1,2]
*/
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> numArray = new ArrayList<>();
        
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            
            else{
                map.put(nums[i], 1);
            }
        }
        
        int limit = nums.length/3;
        for(int key: map.keySet() ){
            if(map.get(key)>limit){
                numArray.add(key);
            }
        }
        return numArray;
    }
}
