class Solution {
    public int minPartitions(String n) {
            char max = '0';
            for (char c : n.toCharArray()) {
                if (max < c) {
                    max = c;
                }
            }

            return (max - '0');
    }
}