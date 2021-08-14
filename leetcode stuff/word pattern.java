/*
PROBLEM STATEMENT

Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false
*/
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<Character> setChar=new HashSet<>();
        Set<String> setString=new HashSet<>();
            String[] sSplit = s.split(" ");
		if (pattern.length() != sSplit.length) {
			return false;
		} 
        
        else {
			for (int i = 0; i < pattern.length(); i++) {
				char c=pattern.charAt(i);
                setChar.add(c);
				if (!map.containsKey(c)) {
					map.put(c, sSplit[i]);
				} else {
					if(!map.get(c).equals(sSplit[i])){
						return false;
					}
                        map.put(c,sSplit[i]);
				}
			}
        setString.addAll(map.values());
    }
        return setString.size()==setChar.size();
}
}
