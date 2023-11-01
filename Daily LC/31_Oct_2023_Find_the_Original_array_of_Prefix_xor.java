/*
Problem Link: https://leetcode.com/problems/find-the-original-array-of-prefix-xor/description/

Problem Statement: You are given an integer array pref of size n. Find and return the array arr of size n that satisfies:

pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
Note that ^ denotes the bitwise-xor operation.

It can be proven that the answer is unique.

Solution Approach: 
A XOR B = C
A XOR C = B
the above property will only work in the context of writing a program.
Using this property we can calculate the ans array

*/

/* ------------CODE---------------- */
class Solution {
    public int[] findArray(int[] pref) {

        int n = pref.length;
        int arr[] = new int[n];

        arr[0] = pref[0];

        // pref[1] = arr[0]^arr[1]
        int xor = arr[0];
        for(int i=1; i<n; i++) {
            arr[i] = pref[i]^xor;
            xor = xor^arr[i];
        }
        return arr;
        
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
*/
