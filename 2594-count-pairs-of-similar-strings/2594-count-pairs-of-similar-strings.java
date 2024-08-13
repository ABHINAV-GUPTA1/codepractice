class Solution {
    public int similarPairs(String[] words) {
        int count = 0;
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (!map.containsKey(words[i])) {
                    map.put(words[i], getArr(words[i]));
                }
                if (!map.containsKey(words[j])) {
                    map.put(words[j], getArr(words[j]));
                }
                if (isSimilar(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }
    Map<String, int[]> map;
    private boolean isSimilar(String s, String t) {
        int[] arr1 = map.get(s);
        int[] arr2 = map.get(t);
        for (int i = 0; i < 26; i++) {
            if ((arr1[i] != 0 && arr2[i] == 0)  || (arr1[i] == 0 && arr2[i] != 0)) {
                return false;
            }
        }
        return true;
    }

    private int[] getArr(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) -'a']++;
        }
        return arr;
    }
}