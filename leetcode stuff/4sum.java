class Solution {
    public List<List<Integer>> fourSum(int[] a, int t) {
        Arrays.sort(a);
        Set<List<Integer>> res = new HashSet<>();
        for(int i=0;i<a.length-1-1-1;i++){
            if(a[i]*4>t){break;}
            for(int j=i+1;j<a.length-1-1;j++){
                int l=j+1,h=a.length-1;
                while(l<h){
                    int sum = a[i]+a[j]+a[l]+a[h];
                    if(sum==t){res.add(Arrays.asList(a[i],a[j],a[l],a[h]));l++;h--;}
                    if(sum>t){h--;}
                    if(sum<t){l++;}
                }
            }
        }
        return new ArrayList<>(res);
    }
}
