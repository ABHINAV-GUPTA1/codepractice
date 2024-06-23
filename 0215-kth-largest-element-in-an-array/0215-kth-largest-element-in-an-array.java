class Solution {

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int pivot = l;
        while (true) {
            pivot = findPivot(l, r, nums);
            if (pivot == k-1) {
                return nums[pivot];
            }
            if (pivot > k-1) {
                r = pivot-1;
            } else {
                l = pivot + 1;
            }
        }    
    }
    
    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    private int findPivot(int l, int r, int[] arr) {
        int pivot = arr[l];

        int i = l+1;
        int j = r;

        while (i <= j) {
            if (arr[i] < pivot && pivot < arr[j]) {
                swap(arr, i, j);
                i++;
                j--;
            } 
            if (arr[i] >= pivot) {
                i++;
            }
            if (arr[j] <= pivot) {
                j--;
            }
        }
        swap(arr, j, l);
        return j;
    }
}