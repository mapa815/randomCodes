/*
PROBLEM STATEMENT

Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. 
If no such two words exist, return 0.

Example 1:
Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".

Example 2:
Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".

Example 3:
Input: words = ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.
*/
class Solution {
    public int maxProduct(String[] words) {
        int max = 0; 
        for (int i = 0; i < words.length - 1; i++) {     // Compare current word
            String word1 = words[i];
            for (int j = i + 1; j < words.length; j++) {     // With each remain word
                String word2 = words[j];
                boolean failed = false;
                char prev = ' ';
                for (char c : word2.toCharArray()) {     // Compare all characters in the pair of words.
                    if (prev != c) {       // Dont bother checking consecutive repeated characters
                        if (word1.contains(String.valueOf(c))) {   
                            failed = true;     
                            break;      
                        }
                        prev = c;
                    }
                }
                if (!failed) {    
                    max = Math.max(max, word1.length() * word2.length());    
                }
            }
        }
        return max; 
     }
}
