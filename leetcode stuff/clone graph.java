/*
PROBLEM STATEMENT

Given a reference of a node in a connected undirected graph.
Return a deep copy (clone) of the graph.
Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}

Test case format:

For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. 
The graph is represented in the test case using an adjacency list.
An adjacency list is a collection of unordered lists used to represent a finite graph. 
Each list describes the set of neighbors of a node in the graph.
The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.

Example 1:

Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).

Example 2:

Input: adjList = [[]]
Output: [[]]
Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.

Example 3:

Input: adjList = []
Output: []
Explanation: This an empty graph, it does not have any nodes.
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

public class Solution {
        // O(n^2) time where n is the number of nodes. This is because for each node we iterate through all its neighbours and in the worst case all nodes are connected to each other.
    // O(n) space because we have exactly one map entry for each node and each node gets added and removed from the queue exactly once.
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();      // Maps a node from original graph to the corresponding node in the cloned graph.
        Deque<Node> queue = new ArrayDeque<>();     // Do a BFS to create a copy of all nodes and create a copy of all edges.
        map.put(node, new Node(node.val));
        queue.addLast(node);
        while (queue.size() > 0) {
            Node currNode = queue.removeFirst();             
            // Create edges for currNode in the cloned graph.
            for (Node currNeighbor : currNode.neighbors) {
                if (!map.containsKey(currNeighbor)) {
                    map.put(currNeighbor, new Node(currNeighbor.val));         // Create a copy of currNeighbor.
                    queue.addLast(currNeighbor);                               // Add currNeighbor to the queue so that its edges will be added to the cloned graph.
                }
                map.get(currNode).neighbors.add(map.get(currNeighbor));       // Create the edge between currNode and the currNeighbor in the cloned graph.
            }
        }
        return map.get(node);
    }
}
