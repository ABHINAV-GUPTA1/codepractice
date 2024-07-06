class Solution {
    public int passThePillow(int n, int time) {
        // int ans = 1;
        // int dir = 1;
        // for (int i = 1; i <= time; i++) {
        //     ans = ans + dir;
        //     if (ans == n) {
        //         dir *=-1;
        //     } else if (ans == 1) {
        //         dir *= -1;
        //     }
        // }

        // return ans;

        int fullRound = time / (n-1);
        int extraTime = time%(n-1);
        if (fullRound%2 == 0) {
            return extraTime+1;
        } else {
            return n - extraTime;
        }

    }
}
/**
1 2 3 4 3 2 1 2

 */