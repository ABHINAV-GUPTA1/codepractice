class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sl = s.length();
        int pl = p.length();
        if (sl < pl) {
            return res;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < pl; i++) {
            arr1[p.charAt(i) - 'a']++;
            arr2[s.charAt(i) - 'a']++;
        } 
        if (Arrays.equals(arr1, arr2)) {
            res.add(0);
        }
        int left = 0;
        int right = pl;
        while (right < sl) {
            arr2[s.charAt(left++)-'a']--;
            arr2[s.charAt(right++)-'a']++;
            if (Arrays.equals(arr1, arr2)) {
                res.add(left);
            }
        }
        return res;
    }

}