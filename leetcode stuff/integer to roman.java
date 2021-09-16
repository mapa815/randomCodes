/*
PROBLEM STATEMENT

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. 
The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. 
Instead, the number four is written as IV. Because the one is before the five we subtract it making four. 
The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.

Example 1:

Input: num = 3
Output: "III"

Example 2:

Input: num = 4
Output: "IV"

Example 3:

Input: num = 9
Output: "IX"

Example 4:

Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.

Example 5:

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/
class Solution {
    public static char romanCharacter(int x) {
        switch (x) {
            case 1:
                return 'I';
            case 5:
                return 'V';
            case 10:
                return 'X';
            case 50:
                return 'L';
            case 100:
                return 'C';
            case 500:
                return 'D';
            default:
                return 'M';
        }
    }
    
    public String intToRoman(int n) {
        StringBuilder sb = new StringBuilder();
        int[] arr = {1, 5, 10, 50, 100, 500, 1000};
        for (int i = 6; i >= 0; i--){
            if (n >= arr[i]) {
                int temp = n / arr[i];
                n %= arr[i];
                while (temp --> 0) {
                    sb.append(romanCharacter(arr[i]));
                }
            }
            if (n < arr[i] && i > 0 && arr[i] == 5 * arr[i-1]) {
                if (n / arr[i-1] == 4) {
                    n %= arr[i-1];
                    sb.append(romanCharacter(arr[i-1])).append(romanCharacter(arr[i]));
                }
            }
            if (n < arr[i] && i > 1 && arr[i] == 2 * arr[i-1]) {
                if (n / arr[i-2] == 9) {
                    n %= arr[i-2];
                    sb.append(romanCharacter(arr[i-2])).append(romanCharacter(arr[i]));
                }
            }
        }
        return sb.toString();
    }
}
