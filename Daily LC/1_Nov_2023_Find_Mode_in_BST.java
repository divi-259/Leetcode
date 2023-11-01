/*
Problem Link: https://leetcode.com/problems/find-mode-in-binary-search-tree/

Problem Statement: Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

If the tree has more than one mode, return them in any order.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.

Solution Approach: 
The logic lies in traversing the tree in inorder fashion and keeping a count, prev and max variable to
be populated as and when required.

*/

/* ------------CODE---------------- */

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
    Integer prev = null;
    int count = 1;
    int max = 0;
    public int[] findMode(TreeNode root) {
     if(root==null) return new int[0];

     List<Integer> list = new ArrayList<>();
     helper(root, list);   
     int ans[] = new int[list.size()];
     for(int i=0; i<list.size(); i++) {
         ans[i] = list.get(i);
     }
     return ans;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if(root==null)
            return;
        helper(root.left, list);
        if(prev!=null) {
            if(root.val == prev)
                count++;
            else count = 1;
        }
        // the logic here is beautiful, keeping a count in the order the nodes appear in a BST
        // and as soon as it increased the max - clear the list, and make it the new max, and add th
        // current node's value in the list
        // if we are going to get multiple nodes with same count, we can keep adding them in the list
        if(count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        }
        else if(count==max) {
            list.add(root.val);
        }
        prev = root.val;
        helper(root.right, list);
    }
}
/*
Time Complexity: O(n) - to traverse all the nodes in the BST
Space Complexity: O(1) [we are ignoring the stack space when traversing the tree]
*/
