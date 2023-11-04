/*
Problem Link: https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/description/

Problem Statement: We have a wooden plank of the length n units. Some ants are walking on the plank, each ant moves with a speed of 1 unit per second. Some of the ants move to the left, the other move to the right.

When two ants moving in two different directions meet at some point, they change their directions and continue moving again. Assume changing directions does not take any additional time.

When an ant reaches one end of the plank at a time t, it falls out of the plank immediately.

Given an integer n and two integer arrays left and right, the positions of the ants moving to the left and the right, return the moment when the last ant(s) fall out of the plank.

Solution Approach: 
If two ants bump into each other and change directions, it's the same as if these ants continue as nothing happens.

So, we can think about that plank as a two-way street. So, find the maximum units that any ant needs to travel.
*/

/* ------------CODE---------------- */
class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        
        int max = 0;
        for(int curr : left) {
            max = Math.max(curr, max);
        }
        for(int curr : right) {
            max = Math.max(n-curr, max);
        }
        return max;

    }
}

/*
Time Complexity: O(n+m)
Space Complexity: O(1)
*/
