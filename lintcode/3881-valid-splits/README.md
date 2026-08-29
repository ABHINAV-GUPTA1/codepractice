<h2><a href="https://www.lintcode.com/problem/3881/description">LintCode Valid Splits</a></h2><h3>Easy</h3><p>Time: 573 ms | Space: 34.30 MB</p><hr><pre>Given an array of integers nums of length n, you can do the following:

Split the array into two left and right non-empty arrays nums[0, ... , i] and nums[i + 1, ... , n - 1], sort these two parts from smallest to largest, and merge left and right after sorting

If the merged array **is also ordered from smallest to largest, then we call this operation a valid split.

Find and return the number of valid splits in the array nums.

LintCode - Online Judge Solution

Candidate Written Test Screening, Team Competency Assessment, Programming Teaching Exercises, Online Exam Grading

WeChat for information

1
≤
𝑛
𝑢
𝑚
𝑠
.
𝑙
𝑒
𝑛
𝑔
𝑡
ℎ
≤
1
0
5
1≤nums.length≤10
5
−
1
0
9
≤
𝑛
𝑢
𝑚
𝑠
[
𝑖
]
≤
1
0
9
−10
9
≤nums[i]≤10
9
Example

Example 1:

Input:
nums = [1, 3, 2, 4]
Output:
2
Explanation:
You can perform the following splits:
[1] + [3, 2, 4] -> [1] + [2, 3, 4] -> [1, 2, 3, 4]
[1, 3] + [2, 4] -> [1, 3] + [2, 4] -> [1, 3, 2, 4]
[1, 3, 2] + [4] -> [1, 2, 3] + [4] -> [1, 2, 3, 4]
The number of valid splits is 2

Example 2:

Input:
nums = [3, 1, 2, 0]
Ouput:
0
Explanation:
You can perform the following splits:
[3] + [1, 2, 0] -> [3] + [0, 1, 2] -> [3, 0, 1, 2]
[3, 1] + [2, 0] -> [1, 3] + [0, 2] -> [1, 3, 0, 2]
[3, 1, 2] + [0] -> [1, 2, 3] + [0] -> [1, 2, 3, 0]
There are no valid splits

Example 3:

Input:
nums = [0, 0, 0, 0]
Output:
3
Explanation:
You can perform the following splits:
[0] + [0, 0, 0]
[0, 0] + [0, 0]
[0, 0, 0] + [0]
The number of valid splits is 3
Related Knowledge
学习《2025年1月北美大厂最新面试真题精讲》课程中的2.3Google：最新面试精选002相关内容 ，了解更多相关知识！</pre>