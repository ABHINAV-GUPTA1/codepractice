class Solution {
    Random r;
    public int findKthLargest(int[] nums, int k) {
        r = new Random();
        return quick(0, nums.length-1, nums, k);
    }
    
    void shuffle (int arr[], int low, int high) {
        int ridx = r.nextInt(high-low+1)+low;
        int t = arr[ridx];
        arr[ridx] = arr[low];
        arr[low] = t;
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
        shuffle(arr, low, high);
        int part = arr[low];
        int i = low+1;
        int j = high;

        while (i <= j) {
            // if (part <= arr[i]) {
            //     i++;
            // } else if (part >= arr[j]) {
            //     j--;
            // } else {
            //     int t = arr[i];
            //     arr[i] = arr[j];
            //     arr[j] = t;
            //     i++;
            //     j--;
            // }

            if (arr[i] < part && arr[j] > part) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }

            if (arr[i] >= part) {
                i++;
            }
            if (arr[j] <= part) {
                j--;
            }
        }

        int t = arr[low];
        arr[low] = arr[j];
        arr[j] = t;
        return j;
    }
}