/*
Problem Link: https://leetcode.com/problems/binary-trees-with-factors/description/ 

Problem Statement: 
Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.

We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node's value should be equal to the product of the values of its children.

Return the number of binary trees we can make. The answer may be too large so return the answer modulo 109 + 7.
Solution Approach: 
/**sort the array so as to start with the smallest element, as larger elements can be formed with the help of smaller one
 * and use HashMap to record each Integer, and the number of trees with that Integer as root
 * (1) each integer A[i] will always have one tree with only itself
 * (2) if A[i] has divisor (a) in the map, and if A[i]/a also in the map
 *     then a can be the root of its left subtree, and A[i]/a can be the root of its right subtree; 
 *     the number of such tree is map.get(a) * map.get(A[i]/a) [calculating all possible combinations]
 * (3) sum over the map will give us all possible trees
 */

*/

/* ------------CODE---------------- */

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        long mod = 1000000007;
        Arrays.sort(arr);
        Map<Integer, Long> hmap = new HashMap<>();
        long count = 1;
        hmap.put(arr[0], count);

        for(int i=1; i<arr.length; i++) {
            // intializing count for each node
            count = 1;
            int curr = arr[i];
            for(Integer n : hmap.keySet()) {
                if(curr%n==0 && hmap.containsKey(curr/n)) {
                    count += (hmap.get(curr/n) * hmap.get(n))%mod;
                }
            }
            hmap.put(curr, count);
        }

        long ans = 0;
        for(Integer temp: hmap.keySet()) {
            ans = (ans + hmap.get(temp))%mod;
        }

        return (int)ans;
    }
}
/*
Time Complexity: O(n^2) - all about traversing number of elements in the hashmap
Space Complexity: 
*/
