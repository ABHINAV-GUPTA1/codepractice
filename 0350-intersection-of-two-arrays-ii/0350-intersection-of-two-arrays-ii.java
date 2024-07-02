class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return intersect(nums2, nums1);
        }    
        int[] res = new int[n1];
        int[] map = new int[1001];
        for (int i = 0; i < n1; i++) {
            map[nums1[i]]++;
        }
        int j = 0;
        for (int i = 0; i < n2; i++) {
            if (map[nums2[i]] > 0) {
                res[j++] = nums2[i];
                map[nums2[i]]--;
            }
        }
        return Arrays.copyOf(res, j);
    }
}