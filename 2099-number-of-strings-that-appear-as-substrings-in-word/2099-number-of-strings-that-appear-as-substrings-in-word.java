class Solution {

    public int numOfStrings(String[] patterns, String word) { 
        int ans = 0;
        for (int i = 0; i < patterns.length; i++) {
            if (word.contains(patterns[i])) {
                ans++;
            }
        }
        return ans;
    }

    public int numOfStrings1(String[] patterns, String word) {
        Set<String> set = new HashSet<>();
        int n = word.length();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                set.add(word.substring(i, j));
            }
        }
        // System.out.println(set);
        int ans = 0;
        for (String s: patterns) {
            if (set.contains(s)) {
                ans++;
            }
        }
        return ans;
    }
}