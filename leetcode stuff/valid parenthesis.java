/*
PROBLEM STATEMENT

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Example 1:
Input: s = "()"
Output: true
Example 2:
Input: s = "()[]{}"
Output: true
Example 3:
Input: s = "(]"
Output: false
*/
class Solution {
 
    boolean valid(char b, char e) {
        return b == '(' && e == ')' || b == '{' && e == '}' || b == '[' && e == ']';
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (valid(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty();  
    } 
} 
