/*
PROBLEM STATEMENT

Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.
The length of the path between two nodes is represented by the number of edges between them.

Example 1:

Input: root = [5,4,5,1,1,5]
Output: 2

Example 2:

Input: root = [1,4,5,4,4,5]
Output: 2
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int longestUnivaluePath(TreeNode root) {
        int[] res = new int[1];
        if (root != null) dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode node, int[] res) {
        int l = node.left != null ? dfs(node.left, res) : 0; // Longest-Univalue-Path-Start-At - left child
        int r = node.right != null ? dfs(node.right, res) : 0; // Longest-Univalue-Path-Start-At - right child
        int resl = node.left != null && node.left.val == node.val ? l + 1 : 0; // Longest-Univalue-Path-Start-At - node, and go left
        int resr = node.right != null && node.right.val == node.val ? r + 1 : 0; // Longest-Univalue-Path-Start-At - node, and go right
        res[0] = Math.max(res[0], resl + resr); // Longest-Univalue-Path-Across - node
        return Math.max(resl, resr);
    }
}
