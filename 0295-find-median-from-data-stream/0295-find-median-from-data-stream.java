class MedianFinder {
    PriorityQueue<Integer> minPq;
    PriorityQueue<Integer> maxPq;

    public MedianFinder() {
        minPq = new PriorityQueue<>();
        maxPq = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxPq.offer(num);
        minPq.offer(maxPq.poll());
        if (maxPq.size() < minPq.size()) {
            maxPq.offer(minPq.poll());
        }
    }
    
    public double findMedian() {
        if (maxPq.size() > minPq.size()) {
            return maxPq.peek();
        }
        return (minPq.peek()+maxPq.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */