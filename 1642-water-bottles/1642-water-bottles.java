class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int k = numBottles/numExchange;
        int carry = 0;
        while ((numBottles+carry)/numExchange > 0) {
            k = (numBottles+carry)/numExchange;
            carry = (numBottles+carry)%numExchange;
            numBottles = k;
            ans += k;
        }
        return ans;
    }
}