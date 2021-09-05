/*
PROBLEM STATEMENT

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"
*/
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char carry = '0';
        int i = num1.length() - 1;
        String solution = "";
        while (i >= 0) {
            int j = num2.length() - 1;
            String currRow = "";
            carry = '0';
            while (j >= 0) {
                String sol = multiplyAndCarry(num1.charAt(i), num2.charAt(j), carry);
                currRow = "" + sol.charAt(sol.length() - 1) + currRow;
                if (sol.length() == 2) {
                    if (j == 0) {
                        currRow = "" + sol.charAt(0) + currRow; 
                    } else {
                        carry = sol.charAt(0);
                    }
                } else {
                    carry = '0';
                }
                j--;
            }
            int nZeroes = num1.length() - 1 - i;
            int k = 0;
            while (k < nZeroes) {
                currRow = currRow + '0';
                k++;
            }
            // System.out.println(currRow);
            solution = addTwoString(currRow, solution);
            // System.out.println(solution);
            i--;
        }
        return solution;
    }
    
    private String multiplyAndCarry(char a, char b, char carry) {
        int aInt = (int) (a - '0');
        int bInt = (int) (b - '0');
        int carryInt = (int) (carry - '0');
        int ans = aInt * bInt + carryInt;
        return Integer.toString(ans);
    }
    
    private String addTwoString(String s1, String s2) {
        if (s1.equals("")) {
            return s2;
        } else if (s2.equals("")) {
            return s1;
        }
        int iS1 = s1.length() - 1, iS2 = s2.length() - 1;
        char carry = '0';
        String solution = "";
        while (iS1 >= 0 || iS2 >= 0) {
            String sol;
            if (iS1 < 0) {
                sol = addAndCarry('0', s2.charAt(iS2), carry);
            } else if (iS2 < 0) {
                sol = addAndCarry('0', s1.charAt(iS1), carry);
            } else {
                sol = addAndCarry(s1.charAt(iS1), s2.charAt(iS2), carry);
            }
            solution = "" + sol.charAt(sol.length() - 1) + solution;
            if (sol.length() == 2) {
                if (iS1 <= 0 && iS2 <= 0) {
                    solution = "" + sol.charAt(0) + solution;
                } else {
                    carry = sol.charAt(0);
                }                
            } else {
                carry = '0';
            }
            iS1--;
            iS2--;
        }
        return solution;
    }
    
    private String addAndCarry(char a, char b, char carry) {
        int aInt = (int) (a - '0');
        int bInt = (int) (b - '0');
        int carryInt = (int) (carry - '0');
        int ans = aInt + bInt + carryInt;
        return Integer.toString(ans);
    }
}
