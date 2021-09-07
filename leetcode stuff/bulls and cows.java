/*
PROBLEM STATEMENT

*/
// 2 Pass digit counts solution
// Time complexity: O(N)
// Space complexity: O(1)
class Solution {
    public String getHint(String secret, String guess) {
        final int N = secret.length();
        int[] digits = new int[10];
        int bulls = 0;
        for (int i = 0; i < N; i++) {
            int ch1 = secret.charAt(i) - '0';
            int ch2 = guess.charAt(i) - '0';
            if (ch1 == ch2) {
                bulls++;
            }
            digits[ch1]++;
        }
        int cows = -bulls;  // Note: cows start from -bulls to remove the position match digits.
        for (int i = 0; i < N; i++) {
            int ch2 = guess.charAt(i) - '0';
            if (digits[ch2] > 0) {
                digits[ch2]--;
                cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
