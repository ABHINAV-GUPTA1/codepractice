class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        for (int i = 0; i < fruits.length; i++) {
            int left = 0;
            while (left < baskets.length) {
                if (baskets[left] >= fruits[i]) {
                    baskets[left] = -1;
                    count++;
                    break;
                }
                left++;
            }

        }
        return fruits.length - count;
    }
}