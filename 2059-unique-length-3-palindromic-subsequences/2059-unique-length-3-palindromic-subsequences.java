class Solution {
    public int countPalindromicSubsequence(String s) {
        int[][] charPositions = new int[26][2];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(charPositions[i], -1); // Initialize efficiently
        }

        for (int i = 0; i < s.length(); i++) {
            int charIdx = s.charAt(i) - 'a';
            if (charPositions[charIdx][0] == -1) {
                charPositions[charIdx][0] = i;
            }
            charPositions[charIdx][1] = i;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (charPositions[i][0] == -1) {
                continue;
            }
            int leftIdx = charPositions[i][0];
            int rightIdx = charPositions[i][1];

            if (rightIdx - leftIdx > 1) { //Optimization: skip if no inner characters
                Set<Character> set = new HashSet<>();
                for (int j = leftIdx + 1; j < rightIdx; j++) {
                    set.add(s.charAt(j));
                }
                ans += set.size();
            }
        }

        return ans;
    }
}