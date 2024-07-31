class Solution {
    int width = 0;
    int[][] dp;
    public int minHeightShelves(int[][] books, int shelfWidth) {
        width = shelfWidth;
        dp = new int[books.length+1][shelfWidth+1];
        for (int i = 0; i <= books.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, 0, books);
    }

    private int f(int idx, int currWidth, int maxHeight, int[][] books) {
        if (idx >= books.length) {
            return maxHeight;
        }
        if (dp[idx][currWidth] != -1) {
            return dp[idx][currWidth];
        }
        int booksH = books[idx][1];
        int booksW = books[idx][0];
        int keep = (int)1e9;
        int nkeep = (int)1e9;
        if (currWidth+booksW <= width) {
            keep = f(idx+1, currWidth+booksW, Math.max(maxHeight, booksH), books);
        }
        nkeep = maxHeight + f(idx+1, booksW, booksH, books);
        return dp[idx][currWidth] = Math.min(keep, nkeep);
    }
}