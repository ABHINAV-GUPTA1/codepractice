class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quick(0, nums.length-1, nums, k);
    }
    int quick(int low, int high, int[] arr, int k) {
        while (low <= high) {
            int part = findPart(low, high, arr);
            if (part == k-1) {
                return arr[part];
            }
            if (part > k-1) {
                high = part-1;
            } else {
                low = part+1;
            }
        }

        return -1;
    }

    int findPart(int low, int high, int[] arr) {
        int part = arr[low];
        int i = low+1;
        int j = high;

        while (i <= j) {
            if (part <= arr[i]) {
                i++;
            } else if (part >= arr[j]) {
                j--;
            } else {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }
        }

        int t = arr[low];
        arr[low] = arr[j];
        arr[j] = t;
        return j;
    }
}