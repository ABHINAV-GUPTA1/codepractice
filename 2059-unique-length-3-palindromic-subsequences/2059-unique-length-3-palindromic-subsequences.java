class Solution {
    public int countPalindromicSubsequence(String s) {
        List<int[]> list = new ArrayList<>(Arrays.asList(new int[26][]));
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int charIdx = s.charAt(i) - 'a';
            if (list.get(charIdx) == null) {
                list.set(charIdx, new int[]{-1,-1});
            }
            if (list.get(charIdx)[0] == -1) {
                list.get(charIdx)[0] = i;
            }
            list.get(charIdx)[1] = i;
            // System.out.println("\t char"+charIdx);
        }
        Set<Character> set;
        for (int i = 0; i < 26; i++) {
            if (list.get(i) == null) {
                continue;
            }
            int leftIdx = list.get(i)[0];
            int rightIdx = list.get(i)[1];
            set = new HashSet<>();
            for (int j = leftIdx+1; j < rightIdx; j++) {
                set.add(s.charAt(j));
            }
            ans += set.size();
        }

        return ans;
    }
}