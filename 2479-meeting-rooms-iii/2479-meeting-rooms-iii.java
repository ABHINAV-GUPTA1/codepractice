class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Integer> availPq = new PriorityQueue<>((a,b)->a-b);
        for (int i = 0; i < n; i++) {
            availPq.offer(i); // initialize avail Q
        }
        Arrays.sort(meetings, (a,b)->a[0]-b[0]); // sort based on start time
        PriorityQueue<int[]> meetPq = new PriorityQueue<>((a,b)->{ // endtime, room number
            if (a[0] == b[0]) {
                return a[1]-b[1];
            }
            return a[0]-b[0];
        }); 
        
        int meetLen = meetings.length;
        int[] count = new int[meetLen];
        int[] tmp;
        int ans = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < meetLen; i++) {
            while (!meetPq.isEmpty() && meetPq.peek()[0] <= meetings[i][0]) {
                availPq.offer(meetPq.poll()[1]);
            }
            int delayed = meetings[i][0];
            if (availPq.isEmpty()) {
                tmp = meetPq.poll();
                delayed = tmp[0];
                availPq.offer(tmp[1]);
            }
            int currRoom = availPq.poll();
            count[currRoom]++;
            if  (count[currRoom] > max) {
                max = count[currRoom];
                ans = currRoom;
            } else if (count[currRoom] == max) {
                ans = Math.min(ans, currRoom);
            }
            meetPq.offer(new int[]{delayed+(meetings[i][1]-meetings[i][0]), currRoom});
        }
        return ans;
    }
}