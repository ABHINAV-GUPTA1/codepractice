class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        int target[] = new int[26];
        for (String b : words2) {
            int t[]= new int[26];
            for (char c : b.toCharArray()) {
                t[c-'a']++;
                target[c-'a'] = Math.max(target[c-'a'], t[c-'a']);
            }
        }
        
        for (String a : words1) {
            int t[]= new int[26];
            for (char c : a.toCharArray()) {
                t[c-'a']++;
            }
            if (isSubset(t, target)) {
                res.add(a);
            }
        }
        
        return res;
        
    }
    
    private boolean isSubset(int[] src, int[] dest) {
        for (int i = 0; i < 26; i++) {
            if (src[i] < dest[i]) {
                return false;
            }
        }
        return true;
    }
}