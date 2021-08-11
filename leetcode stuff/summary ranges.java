/*
PROBLEM STATEMENT

You are given a sorted unique integer array nums.
Return the smallest sorted list of ranges that cover all the numbers in the array exactly. 
That is, each element of nums is covered by exactly one of the ranges, 
and there is no integer x such that x is in one of the ranges but not in nums.
Each range [a,b] in the list should be output as:
"a->b" if a != b
"a" if a == b
*/

class Solution {
      public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList(nums.length); 
        StringBuilder sb = new StringBuilder(); 
        for (int i = 0; i < nums.length; i++) {
            int startRange = i; //always start with the current index as the start range
            sb.delete(0, sb.length()); //delete string builder all content
            while (i < nums.length - 1 && nums[i + 1] - nums[i] == 1) i++; //increase the index of the range till the increase is by one
            if (i == startRange) { // if the index still equals to start range then it means that there is no range therefore add the number in ranges
                ranges.add(String.valueOf(nums[startRange]));
            } else { // this means that there is a range therefore add the range in ranges
                sb.append(nums[startRange]);
                sb.append("->");
                sb.append(nums[i]); //i is the end of the range
                ranges.add(sb.toString());
            }
        }        
        return ranges;
    } 
}
