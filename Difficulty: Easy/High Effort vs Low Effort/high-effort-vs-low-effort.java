class Solution {
    public int maxTask(int[] h, int[] l) {
        // code here
        int n = h.length;

        int prev2 = 0; 
        int prev1 = 0; 

        for (int i = 0; i < n; i++) {

            int curr = Math.max(h[i] + prev2, l[i] + prev1);

            prev2 = prev1;

            prev1 = curr;

        }

        

        return prev1;    
    }
}