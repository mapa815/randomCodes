/*
PROBLEM STATEMENT

For some fixed n, an array nums is beautiful if it is a permutation of the integers 1, 2, ..., n, such that:
For every i < j, there is no k with i < k < j such that nums[k] * 2 = nums[i] + nums[j].
Given n, return any beautiful array nums.  (It is guaranteed that one exists.)
*/

/*
ALGORITHM EXPLANATION

Create a vector called ans, insert 1 into ans
While size of ans < N
create a vector temp
for i in range 0 to size of ans – 1
if ans[i] * 2 – 1 <= N, then insert ans[i] * 2 – 1 into temp array
for i in range 0 to size of ans – 1
if ans[i] * 2 <= N, then insert ans[i] * 2 into temp array
set ans := temp
return ans
*/

class Solution {
    public int[] beautifulArray(int N) {
        int[] res = new int[N];
        if (N == 1) 
        {
            return new int[] {1};
        }
        else if (N == 2) 
        {
            return new int[] {1, 2};
        }
        else
        {
            int[] odds = beautifulArray((N + 1) / 2);
            int[] even = beautifulArray(N / 2);
            for (int i = 0; i < odds.length; i ++) 
            {
                res[i] = odds[i] * 2 - 1;
            }
            for (int j = 0; j < even.length; j ++) 
            {
                res[odds.length + j] = even[j] * 2;
            }
        }
        return res;
    }
}
