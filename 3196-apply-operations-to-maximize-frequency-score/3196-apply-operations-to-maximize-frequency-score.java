class Solution {
    public int maxFrequencyScore(int[] nums, long k) {
        int ans = 1;
        
        int mid;
        int n = nums.length;
        long[] pre = new long[n];
        pre[0] = nums[0];
        int minscore = 1;
        int maxscore = n;
        // sort the array
        Arrays.sort(nums);
        
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i-1] + nums[i];
        }

        while (minscore <= maxscore) {
            mid = minscore+(maxscore-minscore)/2;
            if (isPossible(mid, nums, pre, k)) {
                ans = mid;
                minscore = mid + 1;
            } else {
                maxscore = mid - 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int len, int[] nums, long[] pre, long k) {
        if (len == 0) {
            return false;
        }

        int head = 0;
        int tail = len  - 1;
        int n = nums.length;
        long targetIdx, target;
        long leftOpn, rightOpn;
        
        while (tail < n) {
            targetIdx = head + (tail - head) / 2;
            target = nums[(int) targetIdx];
            if (targetIdx == 0) {
                leftOpn = 0;
            } else {
                // long windowsize = targetIdx-head;
                // long windowSum = windowsize*target;
                
                // long currSum = pre[targetIdx-1] - pre[head] + nums[head];

                leftOpn = Math.abs((targetIdx - head)*target - (pre[(int)targetIdx-1] - pre[head] + nums[head]));
            }

            // long rwsize = tail-targetIdx
            // long rwsum = rwsize*target
            // long currsum = pre[j] - pre[targetIdx]
            rightOpn = Math.abs( (tail-targetIdx)*target - (pre[tail] - pre[(int)targetIdx]) );

            if (leftOpn + rightOpn <= k) {
                return true;
            }
            head++;
            tail++;
        }

        return false;

    }
}