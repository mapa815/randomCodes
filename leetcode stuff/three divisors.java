/*
PROBLEM STATEMENT

Given an integer n, return true if n has exactly three positive divisors. Otherwise, return false.
An integer m is a divisor of n if there exists an integer k such that n = k * m.

Example 1:
Input: n = 2
Output: false
Explantion: 2 has only two divisors: 1 and 2.

Example 2:
Input: n = 4
Output: true
Explantion: 4 has three divisors: 1, 2, and 4.
*/
class Solution {
    public boolean isThree(int n) {
		if(n < 4) return false;
		int root = (int)Math.sqrt(n);
		if(root * root < n) return false;
		for(int i = 2 ; i <= Math.sqrt(root) ; i++) {
			if(root % i == 0) return false;
		}
		return true;
	}
}
