class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        boolean[] allowedArr = getHashBooleanArr(allowed);
        for (int i = 0; i < words.length; i++) {
            int[] arr = getHashIntArr(words[i]);
            boolean flag = true;
            for (int idx = 0; idx < 26; idx++) {
                if (arr[idx] > 0) {
                    if (!allowedArr[idx]) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                count++;
            }
        }

        return count;
    }

    private int[] getHashIntArr(String s) {
        int[] arr = new int[26]; 
        for (char c : s.toCharArray()) {
            arr[c-'a']++;
        }
        return arr;
    }

    private boolean[] getHashBooleanArr(String s) {
        boolean[] arr = new boolean[26]; 
        for (char c : s.toCharArray()) {
            arr[c-'a'] = true;
        }
        return arr;
    }
}