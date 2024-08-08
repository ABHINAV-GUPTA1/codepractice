class Solution {
    public boolean isValidSerialization(String preorder) {
        int countOfSlot = 1;
        for (String s: preorder.split(",")) {
            if (countOfSlot <= 0) {
                return false;
            }
            if (s.equals("#")) {
                countOfSlot -= 1;
            } else {
                countOfSlot += 1;
            }
        }

        return countOfSlot == 0;
    }
}