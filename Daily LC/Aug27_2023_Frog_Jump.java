/*
Problem Link: https://leetcode.com/problems/frog-jump/

Problem Statement: 
A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.

If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction

Solution Approach: //to do

*/

/* ------------CODE---------------- */

class Solution {
    HashMap<Integer, Integer> mark = new HashMap<>();
    int dp[][] = new int[2001][2001];
    
    boolean solve(int[] stones, int n, int index, int prevJump) {
        // If reached the last stone, return 1.
        if (index == n - 1) {
            return true;
        }
        
        // If this subproblem has already been calculated, return it.
        if (dp[index][prevJump] != -1) {
            return dp[index][prevJump] == 1;
        }
        
        boolean ans = false;
        // Iterate over the three possibilities {k - 1, k, k + 1}.
        for (int nextJump = prevJump - 1; nextJump <= prevJump + 1; nextJump++) {
            if (nextJump > 0 && mark.containsKey(stones[index] + nextJump)) {
                ans = ans || solve(stones, n, mark.get(stones[index] + nextJump), nextJump);
            }
        }

        // Store the result to fetch later.
        dp[index][prevJump] = (ans ? 1 :0);
        return ans;
    }
    
    public boolean canCross(int[] stones) {
        // Mark stones in the map to identify if such stone exists or not.
        for (int i = 0 ; i < stones.length; i++) {
            mark.put(stones[i], i);
        }
        
        //Mark all states as -1 to denote they're not calculated.
        for (int i = 0; i < 2000; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return solve(stones, stones.length, 0, 0);
    }
}
/*
Time Complexity: 
Space Complexity: 
*/