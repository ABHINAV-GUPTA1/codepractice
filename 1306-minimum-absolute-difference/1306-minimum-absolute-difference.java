class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i-1];
            if (diff < min) {
                min = diff;
                res = new ArrayList<>();
                res.add(List.of(arr[i-1], arr[i]));
            } else if (diff ==  min) {
                res.add(List.of(arr[i-1], arr[i]));
            }
        }
        return res;
    }
}