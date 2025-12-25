class Solution:
    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        happiness.sort(reverse=True)
        ans = 0
        maxrange = min(len(happiness), k)
        for i in range(maxrange):
            val = happiness[i] - i
            ans += val if val > 0 else 0
        return ans
        