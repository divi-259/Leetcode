/*
Problem Link: https://leetcode.com/problems/maximal-network-rank/

Problem Statement: There is an infrastructure of n cities with some number of roads connecting these cities. Each roads[i] = [ai, bi] indicates that there is a bidirectional road between cities ai and bi.
The network rank of two different cities is defined as the total number of directly connected roads to either city. If a road is directly connected to both cities, it is only counted once.
The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.
Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.

Solution Approach: 
It seems that we need to take every pair into consideration and get the rank, we can do that in O(n^2) complexity,
But we need to create adjacency list in such a way that we can get the count of nodes attached to a node in O(1) time, 
and also we can get if two nodes in a pair are connected or not, that will take O(1) time complexity.
We can use set to store the nodes in our adjacency list to get better access.
*/

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {

        HashMap<Integer, HashSet<Integer>> adjlist = new HashMap<>();

        for(int i=0; i<n; i++) {
            adjlist.put(i, new HashSet<Integer>());
        }

        for(int i=0; i<roads.length; i++) {
            int src = roads[i][0];
            int dest = roads[i][1];

            adjlist.get(src).add(dest);
            adjlist.get(dest).add(src);
        }

        int maxRank = 0;
        
        // calculating rank for each pair
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {

                int count = adjlist.get(i).size() + adjlist.get(j).size();
                if(adjlist.get(i).contains(j))
                count--;
                maxRank = Math.max(maxRank, count);

            }
        }
        return maxRank;
        
        
    }
}

/*
Time complexity: O(n^2), and space complexity = O(n^2) 
*/