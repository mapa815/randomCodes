/*
We can easily see that in order for the array to have equal parts, in each part the number of ones should be equal.
The above implies that the totalOnes should be divisible by 3.
Now lets understand of basic cases
totalOnes = 0: If this is the case any two indices can divide into 3 equal parts since all will be zero
totalOnes%3 !=0: Since total ones is not divisble solution is not possible, so we return [-1,-1]
Next we know that each part will have k = totalOnes/3 ones. Also if we start from the end the target which we want for each part will start as soon as we have taken k ones. So we can keep track of this index from where target starts. Note: This index might not be the index j as there can be leading zeroes which will not change the target.
Now we have to find if its possible to build the same target from start to the end.
Now to get the index i we can start from index 0 and move to the index of first 1 (What we do here is ignore leading zeroes). Now we start comparing elements from the target index and index i. If its equal then this part can be equal to target.
We do the similar operation for the second part.
*/
class Solution {
    public int[] threeEqualParts(int[] arr) {
        int totalOnes = 0;
        for(int e:arr){
            if(e==1){
                totalOnes++;
            }
        }
        
        int l = arr.length;
        if(totalOnes==0){
            return new int[] {0, l-1};
        }
        if(totalOnes%3!=0){
            return new int[] {-1,-1};
        }
        
        int k=totalOnes/3; // Each part will have k number of 1's
        int targetIdx = l; // This first index of '1' which starts the equal part
        
        while(k>0){
            targetIdx--;
            if(arr[targetIdx]==1){
                k--;
            }
        }
        
        int i = isPartPossible(arr, 0, targetIdx);
        if(i==-1){
            return new int[] {-1,-1};
        }
        int j = isPartPossible(arr, i, targetIdx);
        if(j==-1){
            return new int[] {-1,-1};
        }
        
        return new int[] {i-1,j};
    }
    
    private int isPartPossible(int[] arr, int i, int start) {
        while(arr[i]==0){
            i++;
        }
        while(start<arr.length){
            if(arr[i]!=arr[start]) {
                return -1;
            }
            i++;
            start++;
        }
        return i;
    }
}
