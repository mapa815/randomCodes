/*
PROBLEM STATEMENT

For some fixed n, an array nums is beautiful if it is a permutation of the integers 1, 2, ..., n, such that:
For every i < j, there is no k with i < k < j such that nums[k] * 2 = nums[i] + nums[j].
Given n, return any beautiful array nums.  (It is guaranteed that one exists.)
*/

/*
ALGORITHM EXPLANATION

Sort the array nums, ans := 0, diff := Infinity, n := size of nums
for i in range 0 to n – 1
left := i + 1, right := n – 1
while left < right
temp := nums[left] + nums[right] + nums[i]
If |target – temp| < diff, then ans := temp and diff := |target – temp|
If temp = target, then return temp,
Otherwise when temp > target, then decrease right by 1, else increase left by 1
return ans
*/

