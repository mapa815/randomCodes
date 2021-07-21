/*
PROBLEM STATEMENT

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        
        for(String s: strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            map.computeIfAbsent(String.valueOf(c), k -> new LinkedList<String>()).add(s);
        }
        
        return new LinkedList<>(map.values());
    }
}
