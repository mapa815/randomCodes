/*
PROBLEM STATEMENT

Given an integer x, return true if x is palindrome integer.
An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
*/
class Solution {
    public boolean isPalindrome(int x) {
        int t = x;
        if(t<0){
            return false;
        }
        int sum = 0;
        while(t!=0){
            int rem = t%10;
            sum = sum*10+rem;
            t=t/10;
        }
        if(x==sum){
            return true;
        }
            return false;
    }
}
