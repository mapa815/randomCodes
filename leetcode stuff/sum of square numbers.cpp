/*
PROBLEM STATEMENT

Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:
Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:
Input: c = 3
Output: false
Example 3:
Input: c = 4
Output: true
Example 4:
Input: c = 2
Output: true
Example 5:
Input: c = 1
Output: true
*/
class Solution {
public:
    bool judgeSquareSum(int c) {
        long long a=0,b=sqrt(c);
        while(a<=b)
        {
            if((a*a+b*b)==c)
                return true;
            else if((a*a+b*b)>c)
                b--;
            else
                a++;
        }
        return false;
    }
};
