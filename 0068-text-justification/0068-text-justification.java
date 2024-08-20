class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int n = words.length;
        while (i < n) {
            int space = 0;
            int j = i + 1;
            int currLen = words[i].length();

            while (j < n && words[j].length() + currLen + 1 + space <= maxWidth) {
                currLen += words[j].length();
                space++;
                j++;
            }
            int remSpace = maxWidth - currLen;
            int eachWordSpace = space == 0 ? 0 : remSpace / space;
            int extraSpace = space == 0 ? 0 : remSpace % space;
            if (j == n) {
                eachWordSpace = 1;
                extraSpace = 0;
            }
            res.add(getLine(i, j, words, eachWordSpace, extraSpace, maxWidth));
            
            i = j;
        }    

        return res;
    }
    private static final String EMPTY = " ";
    private String getLine(int i, int j, String[] arr, int eachWordSpace, int extraSpaces, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        while (i < j) {
            sb.append(arr[i]);
            if (i == j-1) {
                break;
            }
            for (int space = 0; space < eachWordSpace; space++) {
                sb.append(EMPTY);
            }
            if (extraSpaces > 0) {
                sb.append(EMPTY);
                extraSpaces--;
            }
            i++;
        }

        while (sb.length() < maxWidth) {
            sb.append(EMPTY);
        }
        
        return sb.toString();
    }
}