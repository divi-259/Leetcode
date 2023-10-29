/*
Problem Link: https://leetcode.com/problems/poor-pigs/description/ 

Problem Statement: There are buckets buckets of liquid, where exactly one of the buckets is poisonous. To figure out which one is poisonous, you feed some number of (poor) pigs the liquid to see whether they will die or not. Unfortunately, you only have minutesToTest minutes to determine which bucket is poisonous.

You can feed the pigs according to these steps:

Choose some live pigs to feed.
For each pig, choose which buckets to feed it. The pig will consume all the chosen buckets simultaneously and will take no time. 
Each pig can feed from any number of buckets, and each bucket can be fed from by any number of pigs.
Wait for minutesToDie minutes. You may not feed any other pigs during this time.
After minutesToDie minutes have passed, any pigs that have been fed the poisonous bucket will die, and all others will survive.
Repeat this process until you run out of time.
Given buckets, minutesToDie, and minutesToTest, return the minimum number of pigs needed to figure out which bucket is poisonous within the allotted time.

Solution Approach: 
1. What if you only have one shot?

If we have x pigs, we could use them to represent (encode) 2^x buckets.

2. What if we could have more than one attempts?

If we have t attempts, we could use t+1-based number to represent (encode) the buckets. 

*/

/* ------------CODE---------------- */
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

     int attempts = minutesToTest/minutesToDie;
     int count = 0;
     while(Math.pow(attempts+1, count) < buckets) {
         count++;
     }
     return count;

    }
}

/*
Time Complexity: O(log(buckets))
Space Complexity: O(1)
*/
