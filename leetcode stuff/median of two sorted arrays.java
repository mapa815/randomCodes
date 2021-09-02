/*
PROBLEM STATEMENT

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:
Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:
Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:
Input: nums1 = [2], nums2 = []
Output: 2.00000
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length+nums2.length; 
        int num1=0; int num2=0; 
        int p1=0; int p2=0; 
        int count=0;  //number of elements that have been sorted
        while(p1<nums1.length && p2<nums2.length && count<(1+len/2)){ 
            num1=num2;
            if(nums1[p1]<=nums2[p2]) {
                num2=nums1[p1];
                p1++;
            }
            else {
                num2=nums2[p2];
                p2++;
            }
            count++;
        }
        
        while(count<(1+len/2)){
            num1=num2;
            if(p1<nums1.length) {
                num2=nums1[p1];
                p1++;
            }
            else{
                num2=nums2[p2];
                p2++;
            }
            count++;
        }
        
        if(len%2==0) return (num1+(double)num2)/2;
        else return (double)num2;
    }
}
