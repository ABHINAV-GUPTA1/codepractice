class Solution {
    int transform(String A, String B) {
        // code here
        int res = 0;
        if (A.length() != B.length()) {
            return -1;
        }

        int arr[] = new int[256];
        int i = A.length() - 1;
        int j = B.length() - 1;

        for (int k = 0; k <= i; k++) {
            arr[A.charAt(k)]++;
            arr[B.charAt(k)]--;
        }

        for (int k = 0; k < 256; k++) {
            if (arr[k] != 0) {
                return -1;
            }
        }

        while (i >= 0) {
            if (A.charAt(i) != B.charAt(j)) {
                res++;
            } else {
                j--;
            }
            i--;
        }
        return res;
    }
}