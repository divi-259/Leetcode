/*
Problem Link: https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/

Problem Statement: Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.
Note:
The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
A subtree of root is a tree consisting of root and all of its descendants.

Solution Approach: 
recursively calculate sum and number of nodes for every subtree with the help of a helper method.
Keep a global count variable, and increase it as and when you find a relevant solution.

*/

/* ------------CODE---------------- */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Pair<A, B> {
    A key;
    B value;
}

public class Solution {
    int count = 0; // To keep track of nodes with the given property

    public int countUniValueSubtrees(TreeNode root) {
        helper(root);
        return count;
    }

    // Helper function to recursively traverse the tree and count unique value subtrees.
    private Pair<Integer, Integer> helper(TreeNode root) {
        if (root == null) {
            Pair<Integer, Integer> temp = new Pair<Integer, Integer>();
            temp.key = 0; // Initialize sum at this node as 0
            temp.value = 0; // Initialize the number of nodes as 0
            return temp;
        }

        if (root.left == null && root.right == null) {
            count++; // If the node is a leaf, it's a unique value subtree
            Pair<Integer, Integer> ans = new Pair<>();
            ans.key = root.val; // Sum at this node
            ans.value = 1; // Number of nodes including this node (which is 1)
            return ans;
        }

        // Recursively process the left and right subtrees
        Pair<Integer, Integer> left = helper(root.left);
        Pair<Integer, Integer> right = helper(root.right);

        int sum = left.key + right.key + root.val;
        int avg = sum / (1 + left.value + right.value);

        // If the average value of this subtree is equal to the current node's value, it's a unique value subtree
        if (avg == root.val) {
            count++;
        }

        Pair<Integer, Integer> ret = new Pair<>();
        ret.key = sum; // Sum of values in this subtree
        ret.value = 1 + left.value + right.value; // Number of nodes in this subtree

        return ret;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n) - stack space
*/
