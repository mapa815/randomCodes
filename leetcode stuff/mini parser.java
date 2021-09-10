/*
PROBLEM STATEMENT

Given a string s represents the serialization of a nested list, implement a parser to deserialize it and return the deserialized NestedInteger.
Each element is either an integer or a list whose elements may also be integers or other lists.

Example 1:

Input: s = "324"
Output: 324
Explanation: You should return a NestedInteger object which contains a single integer 324.

Example 2:

Input: s = "[123,[456,[789]]]"
Output: [123,[456,[789]]]
Explanation: Return a NestedInteger object containing a nested list with 2 elements:
1. An integer containing value 123.
2. A nested list containing two elements:
    i.  An integer containing value 456.
    ii. A nested list with one element:
         a. An integer containing value 789
*/


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if (!s.contains("[")) { // corner case, just int.
            return new NestedInteger(Integer.valueOf(s));
        }
        
        NestedInteger res = new NestedInteger();
        Stack<NestedInteger> stk = new Stack<>();
        int sign = 1;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            }
            else if (c == '-') {
                sign = -1;
            }
            else if (c == ',') {
                if (s.charAt(i - 1) != ']') { // there can be '[' before ,
                     NestedInteger intNi = new NestedInteger(num * sign);
                     stk.push(intNi);
                }
                sign = 1;
                num = 0; // only need sign and num update here
            }
            else if (c == '[') {
                NestedInteger ni = null; // smart to push null as '[' mark
                stk.push(ni);
            }
            else { // ]
                // Only when previous chars are number, then do this
                if (i > 0 && s.charAt(i - 1) >= '0' && 
                             s.charAt(i - 1) <= '9') { 
                    NestedInteger intNi = new NestedInteger(num * sign);
                    stk.push(intNi);
                }
              
                NestedInteger ni = new NestedInteger();
                List<NestedInteger> lst = new ArrayList<>();
                while (stk.peek() != null) {
                    lst.add(stk.pop());
                }
                for (int j = lst.size() - 1; j >= 0; j--) { // reverse order
                    ni.add(lst.get(j));
                }
                stk.pop();
                stk.push(ni); // don't forget push for next round
                res = ni;
            }
            
        }
        return res;
    }
}
