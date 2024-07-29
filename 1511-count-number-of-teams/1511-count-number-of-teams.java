class Solution {
    public int numTeams(int[] rating) {
        int ans = 0;
        int leftSmall;
        int leftLarge;
        int rightSmall;
        int rightLarge;
        int n = rating.length;
        for (int j = 1; j < n -1; j++) {
            leftSmall = 0;
            leftLarge = 0;
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    leftSmall++;
                } else if (rating[i] > rating[j]) {
                    leftLarge++;
                }
            }
            rightSmall = 0;
            rightLarge = 0;
            for (int k = j+1; k < n; k++) {
                if (rating[j] < rating[k]) {
                    rightLarge++;
                } else if (rating[j] > rating[k]) {
                    rightSmall++;
                }
            }

            ans += (leftSmall*rightLarge) + (leftLarge*rightSmall);
        }

        return ans;
    }
}