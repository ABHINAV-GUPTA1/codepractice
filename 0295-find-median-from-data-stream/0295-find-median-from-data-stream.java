class MedianFinder {
    
    PriorityQueue<Integer> leftMinHeap;
    PriorityQueue<Integer> rightMaxHeap;

    public MedianFinder() {
        leftMinHeap = new PriorityQueue<>();
        rightMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        leftMinHeap.offer(num);
        rightMaxHeap.offer(leftMinHeap.poll());
        if (leftMinHeap.size() < rightMaxHeap.size()) {
            leftMinHeap.offer(rightMaxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (leftMinHeap.size() == rightMaxHeap.size()) {
            return (leftMinHeap.peek() + rightMaxHeap.peek()) / 2.0;
        }
        return leftMinHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */