/*
PROBLEM STATEMENT

Given the root of a binary tree, return the inorder traversal of its nodes' values.
*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode temp=root;
        while(temp!=null || !stack.isEmpty()){
            while(temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            if(!stack.isEmpty() ){
                TreeNode top = stack.pop();
                ans.add(top.val);
                temp=top.right;
            }
        }
        return ans;
    }
}
