/*
PROBLEM STATEMENT

Given an m x n matrix, return a new matrix answer where answer[row][col] is the rank of matrix[row][col].
The rank is an integer that represents how large an element is compared to other elements. It is calculated using the following rules:

The rank is an integer starting from 1.
If two elements p and q are in the same row or column, then:
If p < q then rank(p) < rank(q)
If p == q then rank(p) == rank(q)
If p > q then rank(p) > rank(q)
The rank should be as small as possible.
The test cases are generated so that answer is unique under the given rules.

Example 1:

Input: matrix = [[1,2],[3,4]]
Output: [[1,2],[2,3]]
Explanation:
The rank of matrix[0][0] is 1 because it is the smallest integer in its row and column.
The rank of matrix[0][1] is 2 because matrix[0][1] > matrix[0][0] and matrix[0][0] is rank 1.
The rank of matrix[1][0] is 2 because matrix[1][0] > matrix[0][0] and matrix[0][0] is rank 1.
The rank of matrix[1][1] is 3 because matrix[1][1] > matrix[0][1], matrix[1][1] > matrix[1][0], and both matrix[0][1] and matrix[1][0] are rank 2.

Example 2:

Input: matrix = [[7,7],[7,7]]
Output: [[1,1],[1,1]]

Example 3:

Input: matrix = [[20,-21,14],[-19,4,19],[22,-47,24],[-19,4,19]]
Output: [[4,2,3],[1,3,4],[5,1,6],[1,3,4]]
*/
class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        TreeMap<Integer, List<int[]>> map = new TreeMap<Integer, List<int[]>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.putIfAbsent(matrix[i][j], new ArrayList<>());
                map.get(matrix[i][j]).add(new int[]{i, j});
            }
        }


        int[] rank = new int[m + n];
        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            HashMap<Integer, Integer> parentMap = new HashMap<Integer, Integer>();
            for (int[] pair : entry.getValue()) {
                union(parentMap, pair[0], pair[1] + m);
            }

            HashMap<Integer, List<Integer>> groups = new HashMap<Integer, List<Integer>>();
            for (Integer value : parentMap.keySet()) {
                int parent = find(parentMap, value);
                groups.putIfAbsent(parent, new ArrayList<>());
                groups.get(parent).add(value);
            }

            for (Map.Entry<Integer, List<Integer>> group : groups.entrySet()) {
                int maxRank = 0;
                for (Integer value : group.getValue()) {
                    maxRank = Math.max(maxRank, rank[value]);
                }

                for (Integer value : group.getValue()) {
                    rank[value] = maxRank + 1;
                }
            }

            for (int[] pair : entry.getValue()) {
                matrix[pair[0]][pair[1]] = rank[pair[0]];
            }
        }

        return matrix;
    }

    private int find(HashMap<Integer, Integer> parentMap, int value) {
        if (parentMap.get(value) == value) {
            return value;
        }

        parentMap.put(value, find(parentMap, parentMap.get(value)));
        return parentMap.get(value);
    }


    private void union(HashMap<Integer, Integer> parentMap, int u, int v) {
        if (!parentMap.containsKey(u)) {
            parentMap.put(u, u);
        }
        if (!parentMap.containsKey(v)) {
            parentMap.put(v, v);
        }

        int pu = find(parentMap, u);
        int pv = find(parentMap, v);
        if (pu != pv) {
            parentMap.put(pu, pv);
        }
    }
}
