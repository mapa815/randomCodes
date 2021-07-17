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
