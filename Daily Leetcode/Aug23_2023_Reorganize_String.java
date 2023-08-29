/*
Problem Link: https://leetcode.com/problems/reorganize-string/description/

Problem Statement: Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

Solution Approach: Keep freq count of the string chars, if the max freq char is exceeding more than half
of the array size, not possible to make the new string - return empty string.
Else keep putting the chars at alternate places - starting with max char freq

*/

/* ------------CODE---------------- */

class Solution {
    public String reorganizeString(String s) {
        
        int n = s.length();
        int arr[] = new int[26];
        
        // Fill in the alphabet frequency array
        for(int i=0;i<n;i++){
            
            char a = s.charAt(i);
            arr[a-'a']++;
            
        }
        // Get the freq of letter with max freq
        int maxFreq = 0;
        int letter = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>maxFreq)
            {
                maxFreq = arr[i];
                letter = i;
            }
        }
        // Return empty string if string is not possible
        if(maxFreq>(n+1)/2)
            return "";
        
        char ret[] = new char[n];
        int index = 0;
        // Fill in the new string at 0,2,4... indices
        while(arr[letter]>0){
            ret[index] = (char)(letter + 'a');
            index+=2;
            arr[letter]--;
        }
        
        // Now keep on filling the remaining even indices and then start with odd indices
        for(int i=0;i<26;i++){ // Travesring each indices of 26 sized array
            
            while(arr[i]>0){
                // this is to keep track of the residual index from filling the largest freq char first
                if(index>=n)
                    index=1;
                ret[index] = (char)(i + 'a');
                index = index+2;
                arr[i]--;
            }
        }
        
        return String.valueOf(ret);
    }
}
/*
Time Complexity: O(n)
Space Complexity: O(1) - just need O(26) space to handle the freq of all the chars
*/