class CustomStack {

    int[] arr;
    int capacity;
    int size;
    public CustomStack(int maxSize) {
        capacity = maxSize;
        arr = new int[capacity];
        size = -1;
    }
    private boolean isValidInsert() {
        return size+1 < capacity;
    }
    public void push(int x) {
        if (!isValidInsert()) {
            return;
        }
        arr[++size] = x;
    }
    
    public int pop() {
        if (size == -1) {
            return -1;
        }
        return arr[size--];
    }
    
    public void increment(int k, int val) {
        int minSize = Math.min(k-1, size);
        for (int i = 0; i <= minSize; i++) {
            arr[i] += val; 
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */