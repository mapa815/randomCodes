/*
PROBLEM STATEMENT

Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
*/
class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(k == 0)  return num;
        if(k == len) return "0";
        
        Stack<Character> stack = new Stack<>();
        int index = 0;
        
        while(index < len){
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(index)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(index++));
        }
        while(k-- > 0) stack.pop();
        
        String smallest = "";
        while(!stack.isEmpty()) smallest = stack.pop() + smallest;
        
		// delete leading zeros
        while(smallest.length() > 1 && smallest.charAt(0) == '0')
            smallest = smallest.substring(1);
        
        return smallest;
    }
}
