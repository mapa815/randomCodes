/*
PROBLEM STATEMENT

Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].

Example 1:
Input: n = 3
Output: 3

Example 2:
Input: n = 11
Output: 0
Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
*/
class Solution {
public int findNthDigit(int n) {
    /*
    * From      To     Digits       Total Digits
    * 1     ~   9   => 1 digit  =>  9
    * 10    ~   99  => 2 digits =>  90 x 2
    * 100   ~   999 => 3 digits =>  900 x 3
    * 1000  ~   9999=> 4 digits =>  9000 x 4
    *
    * Example:
    * n = 1002
    * 1002 - 9*1 - 90*2 = 813 < 900*3
    *
    * which num we should get the digit from?
    * num = 99 + 813 / 3 = 370
    * left = 813 % 3 = 0, meaning no digit left, so we get the last digit of last number.
    *
    * if "left" is larger than 0, we choose next num and get its "left - 1"th digit.
    *
    * Nth Digit = 0;
    */
    int pow = 0; int digits = 1; int base = 0;
    while(n > 9 * Math.pow(10, pow) * digits) {
        n -= 9 * Math.pow(10, pow) * digits;
        base += 9 * Math.pow(10, pow);

        pow++;digits++;
    }

    int num = base + n / digits;
    int left = n % digits;

    int digit = 0;
    if (left != 0) {
        num += 1;
        digit = left - 1;
    } else {
        digit = digits - 1;
    }

    return String.valueOf(num).charAt(digit) - '0';
    }
}
