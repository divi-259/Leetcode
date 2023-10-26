/*
Problem Link: https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

Problem Statement: You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

A row i is weaker than a row j if one of the following is true:

The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.

Solution Approach: create an array of row size with 2 cols, and add the number of 1s as well as corresponding index
of the row in this array. Sort this array on the basis of count of 1s (0th index).
Return answer in the desired array of k size.

*/

/* ------------CODE---------------- */
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        

        int m = mat.length;
        int n = mat[0].length;

        int ans[][] = new int[m][2];

        // we can store the number of 1s with correspoding row index in above array
        // and then we can sort the above array on the basis of number of soldiers

        for(int i=0; i<m; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                if(mat[i][j]==1)
                    count++;
                else break;
            }
            ans[i][0] = count;
            ans[i][1] = i;
        }

        Arrays.sort(ans, (a, b) -> Integer.compare(a[0], b[0]));

        int ret[] = new int[k];

        for(int i=0; i<k; i++) {
            ret[i] = ans[i][1];
        }
        return ret;

    }
}

/*
Time Complexity: O(m*n)
Space Complexity: O(m+k)
*/
