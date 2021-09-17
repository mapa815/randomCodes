/*
PROBLEM STATEMENT

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // or Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        ArrayList<int[]> list = new ArrayList<>();
        // list.add(intervals[0]);
        int lsp = intervals[0][0];  // last starting poin 
        int lep = intervals[0][1];  // last ending point
        for(int i =0; i < intervals.length; i++){
            int sp = intervals[i][0];
            int ep = intervals[i][1];
            if(lep < sp){
                // Interval is found
                int[] sublist = {lsp,lep};
                list.add(sublist);
                lsp = sp;
                lep = ep;
            }else if(lep < ep) {
                lep = ep;
            }else{
                // fully overlaping
                // noting to do here
            }
        }
        int[] sublist = {lsp,lep};
        list.add(sublist);
        return list.toArray(new int[list.size()][]);
    }
}
