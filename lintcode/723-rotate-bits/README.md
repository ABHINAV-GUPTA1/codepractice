<h2><a href="https://www.lintcode.com/problem/723/solution">LintCode Rotate Bits</a></h2><h3>Medium</h3><p>Time: 224 ms | Space: 19.95 MB</p><hr><pre>Solution
6
Notes
Discuss
25
Leaderboard
Record
ALL(6)
C++(3)
Java(2)
Python 3(1)
Create Solution
Bo0lean
Highlight

直接按照题设用位运算求解即可

public class Solution {
    /*
     * @param : a number
     * @param : digit needed to be rorated
     * @return: a number
     */
    public int leftRotate(int n, int d) {
        // write code here
        return (n << d) | (n >> (32 - d));
    }
}

More
Java
2020-06-09
ziruizhao

如果是 rotate right 也是一回事,那么答案就是 return (n >>> d) + (n << (32 - d));

public int leftRotate(int n, int d) {
    // write code here
    return (n >>> (32 - d)) + (n << d);
}

Java
2020-06-09
3
·····
Java
autocomplete turned on
Launch Exam
30 分 00 秒
1
public·class·Solution·{</pre>