/*
PROBLEM STATEMENT

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, 
where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) return;
        else if(m == 0){
            for(int i = 0; i<nums2.length;i++)
                nums1[i]=nums2[i];
            return;
        }
	    int res[]= new int[m+n];
	    int j=0,k=0,o=0;
	    for(int i =0 ; i<nums1.length ;i++){
	        if(j>=m||k>=n) break;
	        if(nums1[j] < nums2[k] && j<m){
	            o=i;
	            res[i] = nums1[j];
	            j++;
	        }else {
	            o=i;
	            res[i] = nums2[k];
	            k++;
	        }
	    }
	    if(j<m && k>=n){    
	        for(int i=o+1;i<res.length && j<m;i++){
	            res[i] = nums1[j];
	            j++;
	        }
	    }
	    else if(k<n && j>=m){
	        for(int i=o+1;i<res.length && k<n;i++){
	            res[i] = nums2[k];
	            k++;
	        }
	    }
	    for(int i = 0; i<nums1.length;i++)
	            nums1[i]=res[i];
    }
}
