class MedianFinder {

    PriorityQueue<Integer> minPq;
    PriorityQueue<Integer> maxPq;

    public MedianFinder() {
        minPq = new PriorityQueue<>();
        maxPq = new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        minPq.offer(num);
        maxPq.offer(minPq.poll());
        if (minPq.size() < maxPq.size()) {
            minPq.offer(maxPq.poll());
        }
    }
    
    public double findMedian() {
        if (maxPq.size() == minPq.size()) {
            return (maxPq.peek()+minPq.peek()) / 2.0;
        }
        return minPq.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */