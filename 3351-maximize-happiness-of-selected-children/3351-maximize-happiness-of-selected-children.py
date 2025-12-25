class Solution:
    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        happiness.sort(reverse=True)
        ans = 0
        for i in range(k):
            val = happiness[i] - i
            if val < 0:
                return ans
            ans += val
        return ans
        