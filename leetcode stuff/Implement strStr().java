/*
PROBLEM STATEMENT

Implement strStr().
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
*/

class Solution {
    public int strStr(String haystack, String needle) {
        
        if (needle.isEmpty())
            return 0;

        // start iterating over the haystack (starting from 0 but end early to leave room for the tail end of the needle)
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            // start comparing the characters in the needle to the current view of the haystack
            // going in reverse allows you to exit early
            for (int j = needle.length() - 1; j >= 0; j--) {

                if (haystack.charAt(i+j) != needle.charAt(j)) // if at any point they dont equal we can break
                    break;

                if (j == 0) // if we reached the first/last char comparison without a break they must be equal
                    return i;
            }

        }
        return - 1; // iterated over the whole haystack, breaking every time on the inner loop
    }
}
