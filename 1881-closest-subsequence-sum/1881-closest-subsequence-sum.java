class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        List<Integer> firstArray = findAllSums(nums, 0, n/2-1, 0);
        List<Integer> secondArray = findAllSums(nums, n/2, n-1, n/2);
        Collections.sort(secondArray);
        // System.out.println(firstArray);
        // System.out.println(secondArray);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < firstArray.size(); i++) {
            int lb = lowerBound(secondArray, goal-firstArray.get(i));
            if (lb > 0) {
                // System.out.println(firstArray.get(i)+"->"+secondArray.get(lb-1));
                ans = Math.min(ans, Math.abs(goal-firstArray.get(i)-secondArray.get(lb-1)));
            }
            if (lb < secondArray.size()) {
                // System.out.println(firstArray.get(i)+"=->-"+lb);
                ans = Math.min(ans, Math.abs(goal-firstArray.get(i)-secondArray.get(lb)));
            }
        }

        return ans;

    }

    private List<Integer> findAllSums(int[] arr, int start, int end, int offset) {
        List<Integer> res = new ArrayList<>();
        int n = end-start+1;
        int bitlen = (1<<n);
        int mask = 0;
        for (int i = 0; i < bitlen; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                mask = 1<<j;
                if ((i&mask) != 0) {
                    sum += arr[j+offset];
                }
            }
            res.add(sum);
        }

        return res;
    }

    private int lowerBound(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size()-1;
        int ans = arr.size();
        while (left <= right) {
            int mid = left+(right-left) / 2;
            if (arr.get(mid) >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}