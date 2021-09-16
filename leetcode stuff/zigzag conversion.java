/*
PROBLEM STATEMENT

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:

Input: s = "A", numRows = 1
Output: "A"
*/
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 0 || numRows == 1) {
			return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j = i;
            while (j < s.length()) {
                sb.append(s.charAt(j));
                j += 2 * numRows - 2;
                int k = j - 2 * i;
                if (i != numRows - 1 && i != 0 && k < s.length()) {
                    sb.append(s.charAt(k));
                }
            }
        }
        return sb.toString();
    }
}
