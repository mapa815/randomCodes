/*
PROBLEM STATEMENT

You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. 
Each Ai or Bi is a string that represents a single variable.
You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

Example 1:
Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
Example 2:
Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:
Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
*/
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Node>> graph = buildGraph(equations,values);
        
        double[] result = new double[queries.size()];
        
        for(int i=0;i<queries.size();i++){
            result[i] = dfs(queries.get(i).get(0),queries.get(i).get(1),new HashSet<>(),graph);
        }
        
        return result;
    }
    
    public double dfs(String src, String dest, Set<String> visited, Map<String,List<Node>> graph){
        
        if(!(graph.containsKey(src) && graph.containsKey(dest))){
            return -1.0;
        }
         if(src.equals(dest)){
             return 1.0;
         }
           visited.add(src);
         for(Node node: graph.get(src)){             
             if(!visited.contains(node.key)){
                 double ans =dfs(node.key,dest,visited,graph);
                 if(ans!=-1.0){
                     return ans*node.value;
                 }
             }
         }  
         return -1.0;
    }
    
    public Map<String,List<Node>> buildGraph(List<List<String>> equations,double[] val){
        Map<String,List<Node>> graph = new HashMap<>();
        for(int i=0;i<val.length;i++){
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            graph.putIfAbsent(src,new ArrayList<>());
            graph.putIfAbsent(dest,new ArrayList<>());
            graph.get(src).add(new Node(dest,val[i]));
            graph.get(dest).add(new Node(src,1/val[i]));
        }
        return graph;
    }
    
    static class Node{
        String key;
        double value;
        
        public Node(String key,double value){
            this.key = key;
            this.value = value;
        }
    }
}
