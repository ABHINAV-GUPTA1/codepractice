class Solution {

    private Boolean[] memo;
    public boolean winnerSquareGame(int n) {
        memo = new Boolean[n + 1];
        return canWin(n);
    }

    private boolean canWin(int remainingStones) {
        // Base case: no stones left means previous player took the last stone and won
        if (remainingStones <= 0) {
            return false;
        }
      
        // Check if we've already computed the result for this state
        if (memo[remainingStones] != null) {
            return memo[remainingStones];
        }
      
        // Try all possible square number moves
        // j * j represents the square number of stones to remove
        for (int j = 1; j * j <= remainingStones; j++) {
            // If any move leads to opponent losing, current player wins
            if (!canWin(remainingStones - j * j)) {
                memo[remainingStones] = true;
                return true;
            }
        }
      
        // If no winning move exists, current player loses
        memo[remainingStones] = false;
        return false;
    }
}