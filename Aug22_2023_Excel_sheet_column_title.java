/*
Problem Link: https://leetcode.com/problems/excel-sheet-column-title/description/

Problem Statement: Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

Solution Approach: 
Handle number by its mod, and keep dividing till it is greater than 0.
Update the char at the start of the stringbuilder object

*/

/* ------------CODE---------------- */
class Solution {
    public String convertToTitle(int columnNumber) {

        int n = columnNumber;
        StringBuilder str = new StringBuilder();

        while(n>0) {
            n--; // To handle the case when n becomes 26
            str.insert(0, (char)('A' + n%26));
            n = n/26;
        }

        return str.toString();
        
    }
}

/*
Time Complexity: O(logn) - base will be 26, as at each iteration n gets divided by 26
Space Complexity: O(1)
*/