/*
PROBLEM STATEMENT

Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. 
Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. 
For example, there won't be input like 3a or 2[4].

Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:
Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
*/
class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()){
            if (Character.isDigit(c)){
                k = k * 10 + c - '0';
            } else if (c == '['){
                countStack.push(k);
                stringStack.push(currentString);
                //reset
                k = 0;
                currentString = new StringBuilder();
            } else if (c == ']'){
                //decode
                StringBuilder decodedString = stringStack.pop();
                int currK = countStack.pop();
                //currK[currentString]
                while(currK > 0){
                    decodedString.append(currentString);
                    currK--;
                }
                currentString = decodedString;
            } else {
                currentString.append(c);
            }
        }
        
        return currentString.toString();
    }
}
