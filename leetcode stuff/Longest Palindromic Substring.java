/*
PROBLEM STATEMENT

Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:
Input: s = "cbbd"
Output: "bb"
Example 3:
Input: s = "a"
Output: "a"
Example 4:
Input: s = "ac"
Output: "a"
*/
class Solution {
    public String longestPalindrome(String str) {
        

		int lps[] = manchers(str);
		int ind =0;
		int max = -1;
		for(int i=2;i<lps.length;i++) {
			if(lps[i]>max) {
				max = lps[i];
				ind  = i; 
			}
		}
		
		int aind = ind-max+1;
		int find = (aind-2)/2;
		return(str.substring(find,find+max));
        
    }
    
    
    	public static int[] manchers(String str) {
		
		StringBuilder sb = new StringBuilder("@#");
		int n = str.length();
		for(int i=0;i<n;i++) {
			sb.append(str.charAt(i)+"#");
		}
		sb.append("*");
		// System.out.println(sb);
		int cen = 0;
		int rad = 0;
		n = sb.length();
		int lps[] = new int[n];
		for(int i=1;i<n-1;i++) {
			if(i<=rad) lps[i] = Math.min(lps[2*cen-i], rad-i);
			while(i+lps[i]+1<n && i-lps[i]-1>=0 && sb.charAt(i+lps[i]+1)==sb.charAt(i-lps[i]-1)) {
				lps[i]++;
			}
			if(lps[i]+i>rad) {
				cen =i;
				rad = lps[i]+i;
			}
		}
		
		return lps;
		
		
	}
    
    
}
