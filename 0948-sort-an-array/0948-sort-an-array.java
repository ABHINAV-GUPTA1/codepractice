class Solution {
    static Random random = new Random();
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = findPivot(arr, left, right);
        quickSort(arr, left, pivot-1);
        quickSort(arr, pivot+1, right);
    }

    int findPivot(int[] arr, int left, int right) {
        findRandomAndSwap(arr, left, right);
        int pivot = left;
        int i = left+1;
        int j = right;
        while (i <= j) {
            if (arr[pivot] > arr[i]) {
                i++;
            } else if (arr[pivot] < arr[j]) {
                j--;
            } else {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            } 
        }
        int t = arr[pivot];
        arr[pivot] = arr[j];
        arr[j] = t;
        return j;
    }

    private void findRandomAndSwap(int arr[], int left, int right) {
        int idx = random.nextInt(right-left+1)+left;
        int t = arr[idx];
        arr[idx] = arr[left];
        arr[left] = t;
    }

}