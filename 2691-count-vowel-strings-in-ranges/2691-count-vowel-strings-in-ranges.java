class Solution {
    int[] fenwick;
    private void update(int i, int x) {
        int n = fenwick.length;
        while (i < n) {
            fenwick[i] += x;
            i += (i & (-i));
        }
    }

    private int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += fenwick[i];
            i -= (i & (-i));
        }
        return sum;
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        boolean vowel[] = checkAndGetIfVowelArr(words);
        int[] pre = new int[vowel.length+1];
        pre[0] = 0;
        for (int i = 1; i < pre.length; i++) {
            pre[i] = (vowel[i-1] ? 1 : 0 ) + pre[i-1];
        }
        int ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = pre[queries[i][1]+1]-pre[queries[i][0]];
        }
        return ans;
    }
    
    // fenwick tree based approach
    public int[] vowelStrings1(String[] words, int[][] queries) {
        boolean vowel[] = checkAndGetIfVowelArr(words);
        fenwick = new int[words.length+1];
        for (int i = 0; i < words.length; i++) {
            update(i+1, vowel[i]?1:0);
        }
        int ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = query(queries[i][1]+1)-query(queries[i][0]);
        }
        return ans;
    }

    boolean[] checkAndGetIfVowelArr(String[] arr) {
        boolean[] ans = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = isVowel(arr[i]);
        }
        return ans;
    }

    private boolean isVowel(String s) {
        return isVowelChar(s.charAt(0)) && isVowelChar(s.charAt(s.length()-1));
    }

    private boolean isVowelChar(char c) {
        switch(c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}