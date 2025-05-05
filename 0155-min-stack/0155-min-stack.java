
class MinStack {
    Stack<Long> st;
    long min;
    public MinStack() {
        st = new Stack<>();
        min = -1;
    }
    
    public void push(int val) {
        if (st.isEmpty()) {
            min = val;
            st.push((long) val);
        } else {
            if (min < val) {
                st.push((long) val);
            } else {
                long newVal = (long) 2*val - min;
                st.push(newVal);
                min = val;
            }
        }
    }
    
    public void pop() {
        if (st.isEmpty()) {
            return;
        }
        long val = st.pop();
        if (val < min) {
            min = 2 * min - val;
        }
    }
    
    public int top() {
        if (st.isEmpty()) {
            return -1;
        }
        long val = st.peek();
        return (int) ((val > min) ? val : min);
    }
    
    public int getMin() {
        if (st.isEmpty()) {
            return -1;
        }
        return (int) min;
    }
}

/***
    Using Pair in stack but not space efficient
    TC: O(1) for getMin
 */
class MinStackMethod1 {
    Stack<Pair<Integer, Integer>> st;
    public MinStackMethod1() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if (st.isEmpty()) {
            st.push(new Pair<>(val, val));
        } else {
            st.push(new Pair<>(val, Math.min(val, st.peek().getValue())));
        }
    }
    
    public void pop() {
        if (!st.isEmpty()) {
            st.pop();
        }
    }
    
    public int top() {
        if (st.isEmpty()) {
            return -1;
        }
        return st.peek().getKey();
    }
    
    public int getMin() {
        if (st.isEmpty()) {
            return -1;
        }
        return st.peek().getValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */