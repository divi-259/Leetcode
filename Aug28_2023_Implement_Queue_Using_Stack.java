/*
Problem Link: https://leetcode.com/problems/implement-stack-using-queues/description/

Problem Statement: Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Solution Approach: 

*/

/* ------------CODE---------------- */
class MyStack {

    private Deque<Integer> q;

    public MyStack() {
        q = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q.addLast(x);
    }
    
    public int pop() {
        return q.removeLast();
    }
    
    public int top() {
        return q.getLast();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}


/*
Time Complexity: 
Space Complexity: 
*/