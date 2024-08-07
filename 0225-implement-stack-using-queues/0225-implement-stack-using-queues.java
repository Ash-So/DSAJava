class MyStack {
    Queue<Integer> q = new LinkedList<>();
    public MyStack() {
        
    }
    
    // O(N)
    public void push(int x) {
        q.add(x);
        for(int i = 1 ; i < q.size() ; i++){
            q.add(q.remove());
        }
    }

    // O(1)
    public int pop() {
        return q.remove();
    }
    
    // O(1)
    public int top() {
        return q.peek();
    }
    
    // O(1)
    public boolean empty() {
        if(q.size() != 0) return false;
        else return true;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */