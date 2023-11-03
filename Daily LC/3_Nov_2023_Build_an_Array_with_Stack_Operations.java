/*
Problem Link: https://leetcode.com/problems/build-an-array-with-stack-operations/

Problem Statement: You are given an integer array target and an integer n.

You have an empty stack with the two following operations:

"Push": pushes an integer to the top of the stack.
"Pop": removes the integer on the top of the stack.
You also have a stream of the integers in the range [1, n].

Use the two stack operations to make the numbers in the stack (from the bottom to the top) equal to target. You should follow the following rules:

If the stream of the integers is not empty, pick the next integer from the stream and push it to the top of the stack.
If the stack is not empty, pop the integer at the top of the stack.
If, at any moment, the elements in the stack (from the bottom to the top) are equal to target, do not read new integers from the stream and do not do more operations on the stack.
Return the stack operations needed to build target following the mentioned rules. If there are multiple valid answers, return any of them.

Solution Approach: 
The code builds an array following a given sequence of push ("Push") and pop ("Pop") operations to 
create an array arr. 
The algorithm iterates through the arr and the goal is to reach the values mentioned in arr.
 If the current value in arr is greater than the current stream value (stream), 
 it performs pushes until they match. If there are any unnecessary elements on the stack, 
 it performs pops to discard them. If the stream is equal to the current value in arr, 
 it adds a push operation.

This process ensures that the list contains the correct sequence of operations to transform the 
stream into the desired array arr.

*/

/* ------------CODE---------------- */

class Solution {
    public List<String> buildArray(int[] arr, int n) {
        
        List<String> list = new ArrayList<>();
        int stream = 1;
        
        for(int i=0; i<arr.length; i++) {
            int curr = arr[i];
            int count = 0;
            
            // Keep pushing until you reach the current value
            while(stream < curr) {
                list.add("Push");
                stream++;
                count++;
            }
            
            // Pop the elements not needed in the target array
            while(count > 0) {
                count--;
                list.add("Pop");
            }
            
            // If the stream element is equal to the current one, add a push
            if(stream == curr) {
                list.add("Push");
                stream++;
            }
        }
        
        return list;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n) - for the return output
*/
