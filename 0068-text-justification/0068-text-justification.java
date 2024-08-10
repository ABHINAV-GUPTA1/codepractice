class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0; 
        int n = words.length;
        List<String> res = new ArrayList<>();
        while (i < n) {
            int j = i+1;
            int wordLen = words[i].length();
            int spaces = 0;
            while (j < n && spaces+wordLen + words[j].length()+1 <= maxWidth) {
                wordLen += words[j].length();
                spaces++;
                j++;
            } 

            int remSpaces = maxWidth - wordLen;
            int eachWordSpaces = spaces == 0 ? 0 : remSpaces / spaces;
            int extraSpace = spaces == 0 ? 0 : remSpaces % spaces;
            if (j == n) {
                eachWordSpaces = 1;
                extraSpace = 0;
            }            
            
            res.add(getLineJustified(i, j, eachWordSpaces, extraSpace, maxWidth, words));
            i = j;
        }

        return res;
    }

    private String getLineJustified(int i, int j, int eachSpace, int extraSpace, int maxLen, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (int idx = i; idx < j; idx++) {
            sb.append(words[idx]);
            if (idx == j - 1) {
                continue;
            }
            for (int space = 0; space < eachSpace; space++) {
                sb.append(" ");
            }
            if (extraSpace > 0) {
                sb.append(" ");
                extraSpace--;
            }
        }

        while (sb.length() < maxLen) {
            sb.append(" ");
        }

        return sb.toString();
    } 
}