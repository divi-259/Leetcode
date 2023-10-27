/*
Problem Link: https://leetcode.com/problems/longest-palindromic-substring/description/

Problem Statement: Given a string s, return the longest palindromic substring in s.

Solution Approach: 
For every index i in the string, have an external function expandfromMiddle to return the longest length of palindrome that
can be formed as this index in the middle.
Also keep in mind two kinds of test cases where palindrome can be of even or odd length.

*/

/* ------------CODE---------------- */

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len<2)
        return s;
        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); i++) {
            int len1 = expandFromMiddle(s, i, i);  // racecar example, checking for e==e
            int len2 = expandFromMiddle(s, i, i+1);
            int lenz = Math.max(len1,len2);
            if(lenz > end-start) {
                start = i - ((lenz-1)/2);
                end = i + (lenz/2);
            }
        }
        return s.substring(start, end+1);
    }


    public int expandFromMiddle(String s, int left, int right) {
        if(s==null || left>right)
            return 0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
        }
        return right-left-1;
    }
}
/*
Time Complexity: O(n^2)
Space Complexity: O(1) - we do not need any extra space
*/
