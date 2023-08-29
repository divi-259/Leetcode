/*
Problem Link: https://leetcode.com/problems/01-matrix/ 

Problem Statement: Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell. The distance between two adjacent cells is 1.

Solution Approach: We will use BFS approach, as DFS is not used to find the shortest path, it will keep on diving deeper.
We will start by putting all the cells where the value is 0 into the queue, and we will keep taking the elements out of the queue while it is not empty.
For every element - we are making sure - we put all its neighbors in the queue only if we can get  a better answer for the neighbor than the current one.
We should also be updating the value in the new neighbors
*/

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length, n = mat[0].length;
        int ans[][] = new int[m][n];
        
        Queue<int[]> q = new ArrayDeque<>();

        // pushing all the cells with 0 value in the queue, and then processing each one by one
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (mat[i][j] == 0) {
                    int arr[] = {i,j};
                    q.offer(arr);
                    ans[i][j] = 0;
                }
                else ans[i][j] = Integer.MAX_VALUE; 
        }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()) {
            int temp[] = q.remove();
            int r = temp[0]; int c = temp[1];
            for(int dir[] : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n || 
                    ans[nr][nc]<= ans[r][c] + 1) continue;
                q.add(new int[] {nr, nc});
                ans[nr][nc] = ans[r][c] + 1;
            }
        }
        return ans;
        
    }
}
