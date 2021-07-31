/*
PROBLEM SATEMENT

You are given a string word that consists of digits and lowercase English letters.
You will replace every non-digit character with a space. For example, "a123bc34d8ef34" will become " 123  34 8  34". Notice that you are left with some integers 
that are separated by at least one space: "123", "34", "8", and "34".
Return the number of different integers after performing the replacement operations on word.
Two integers are considered different if their decimal representations without any leading zeros are different.
*/
class Solution {
    public int numDifferentIntegers(String word) {
        String replaced = word.replaceAll("[a-z]", " "); //replace all a-z characters
        Set<String> nums = new HashSet();
        String [] words = replaced.split(" "); //split based on space character
        for (String s : words) {
            if (s.trim().length() > 0) //if word is not empty add to the set
                nums.add(s.replaceAll("^0*", "")); //replace all leading zeros - ^matchs the beginning zeros * as many as zeros will be matched
        }
        return nums.size();
    }
}
