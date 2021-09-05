/*
PROBLEM STATEMENT

Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

Example 1:
Input: a = 2, b = [3]
Output: 8

Example 2:
Input: a = 2, b = [1,0]
Output: 1024

Example 3:
Input: a = 1, b = [4,3,3,8,5,2]
Output: 1

Example 4:
Input: a = 2147483647, b = [2,0,0]
Output: 1198
*/
class Solution {
    public int superPow(int a, int[] b) {
        a %= 1337;
        int res = 1;
        for(int i = 0; i < b.length; i++){
            // calculate res ^ 10
            int left = 1;
            for(int j = 0; j < 10; j++){
                left = (left * res) % 1337;
            }
            // calculate a ^ b[i]
            int right = 1;
            for(int j = 0; j < b[i]; j++) {
                right = (right * a % 1337) % 1337;
            }
            
            // calculate result
            res = (left * right) % 1337;  
        }
        
        return res;
    }
}
