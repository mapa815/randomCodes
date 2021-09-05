/*
PROBLEM STATEMENT

Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.

Example 1:
Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:
Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
*/
class Solution {
public:
    int longestSubstring(string s, int k) {
        int n=s.size(),f=0;
        map<char,int> m;
        for(int i=0;i<n;i++){
         m[s[i]]++;
        }
        bool a[26]={0};
        a[0]=0;
        for(auto i:m)
        {
            if(i.second<k){a[i.first-'a']=1;f=1;}
        }
        if(f==0)return n;
        int j=0,i,ans=0;
        for( i=0;i<n;i++)
        {
            if(a[s[i]-97]==1)
            {   
                ans=max(ans,longestSubstring(s.substr(j,i-j),k));j=i+1;
            }
        }
        return ans=max(ans,longestSubstring(s.substr(j,i-j),k));
    }
};
