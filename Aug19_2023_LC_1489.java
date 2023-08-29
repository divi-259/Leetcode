/*
Problem Link: https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/

Problem Statement: Given a weighted undirected connected graph with n vertices numbered from 0 to n - 1, 
and an array edges where edges[i] = [ai, bi, weighti] represents a bidirectional and weighted edge between nodes ai and bi.
 A minimum spanning tree (MST) is a subset of the graph's edges that connects all vertices without cycles and with the minimum possible total edge weight
Find all the critical and pseudo-critical edges in the given graph's minimum spanning tree (MST). 
An MST edge whose deletion from the graph would cause the MST weight to increase is called a critical edge. 
On the other hand, a pseudo-critical edge is that which can appear in some MSTs but not all.

Note that you can return the indices of the edges in any order.

Solution Approach: 
A graph can have only one min spanning tree weight, but It can have multiple MSTs giving same weight.
A critical edge should appear in all the MSTs as removing it will increase the weight of the MST.
Pseudo critical edge is an edge that appears in some MSTs but not all.
For each edge, to identify if it's critical, we remove it from the graph and re-calculate the MST weight (again using Kruskal's algorithm). 
If the MST weight increases or it's impossible to connect all nodes without this edge (i.e., the graph is not connected), 
this edge is critical. An important hint toward this approach is that the constraints state n≤100n \le 100n≤100, 
which means performing Kruskal's many times is a feasible strategy.
Read along the comments in the code to understand the solution better.

TO DO : Read Article and understand about Union Find - https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/editorial/
*/

/* ------------CODE---------------- */


/*
Time Complexity: 
Space Complexity: 
*/