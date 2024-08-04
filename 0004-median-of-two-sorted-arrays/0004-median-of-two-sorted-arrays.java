class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int l1, l2, r1, r2;
        int m1, m2;
        int n = n1+n2;
        int lh = (n+1) / 2;
        int low = 0;
        int high = n1;
        while (low <= high) {
            m1 = low + (high - low) / 2;
            m2 = lh - m1;

            l1 = m1 > 0 ? nums1[m1-1] : Integer.MIN_VALUE;
            l2 = m2 > 0 ? nums2[m2-1] : Integer.MIN_VALUE;

            r1 = m1 < n1 ? nums1[m1] : Integer.MAX_VALUE;
            r2 = m2 < n2 ? nums2[m2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n%2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0; 
                }
                return Math.max(l1, l2)*1.0;
            }

            if (l1 > r2) {
                high = m1 - 1;
            } else {
                low = m1 + 1;
            }
        }
        return 0;
    }
}