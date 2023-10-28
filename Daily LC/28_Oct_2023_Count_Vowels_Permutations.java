/*
Problem Link: https://leetcode.com/problems/count-vowels-permutation/description/

Problem Statement: Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.

Solution Approach: Think of how any vowel is reversely connected in this scenario


*/

/* ------------CODE---------------- */
class Solution {
    int a =0, e=1, i=2, o=3, u=4, mod = (int)(1e9+7);
    public int countVowelPermutation(int n) {
        
        long[] dp = new long[5];
        long[] prevdp = new long[5];

        Arrays.fill(prevdp, 1L); // for n==1, all the strings are of length 1

        while( n > 1) {
            dp[a] = (prevdp[e] + prevdp[i] + prevdp[u]) % mod;
            dp[e] = (prevdp[a] + prevdp[i]) % mod;
            dp[i] = (prevdp[e] + prevdp[o]) % mod;
            dp[o] = prevdp[i] % mod;
            dp[u] = (prevdp[i] + prevdp[o] ) % mod;
            n--;
            long[] temp = dp;
            dp = prevdp;
            prevdp = temp;
        }

        return (int)(prevdp[a] + (prevdp[e] + (prevdp[i] + (prevdp[o] + prevdp[u])%mod)%mod)%mod)%mod;


    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/
