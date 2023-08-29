/*
Problem Link: https://leetcode.com/problems/repeated-substring-pattern/description/

Problem Statement: Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

Solution Approach: 
The substring needs to be a divisor of the given string, 
we can take all substrings that are divisors of s and build a string,  if that is equal to original string s, then return true else return false.

*/

/* ------------CODE---------------- */
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        
        int n = s.length();
        
        // take all divisors string into consideration

        for(int i=1; i<=n/2; i++) {

            if(n%i==0) {
                StringBuilder sb = new StringBuilder();
                // append the initial string n/i times 
                for(int j=0; j<n/i; j++) {
                    sb.append(s.substring(0,i));
                }
                // check if string formed like this is equal to original one
                if(s.equals(sb.toString()))
                return true;
            }
        }

        return false;
    }
}

/*
Time Complexity: O(n.root(n)) - a number can have only 2.root(n) divisors
Space Complexity: O(n) - for the temporary stringbuilder
*/