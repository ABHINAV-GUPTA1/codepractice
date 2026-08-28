<h2><a href="https://www.lintcode.com/problem/1017/solution">LintCode Similar RGB Color</a></h2><h3>Easy</h3><p>Time: 295 ms | Space: 22.48 MB</p><hr><pre>Solution
27
Notes
Discuss
61
Leaderboard
Record
ALL(27)
Python 3(13)
Java(12)
C++(3)
JavaScript(1)
Create Solution
伟大的狗子
Highlight

方法：独立性 + 枚举
我们可以发现，颜色中的每一维都是独立的，因此我们只需要分别计算出 color = #ABCDEF 中与 AB，CD 和 EF 相似度最大的颜色即可。最终的答案为这三个颜色的结合。

java
python
class Solution {
    public String similarRGB(String color) {
        return "#" + f(color.substring(1, 3)) + f(color.substring(3, 5)) + f(color.substring(5));
    }

    public String f(String comp) {
        int q = Integer.parseInt(comp, 16);
        q = q / 17 + (q % 17 > 8 ? 1 : 0);
        return String.format("%02x", 17 * q);
    }
}
More
Java
Python 3
2022-05-16
10
伟大的狗子
Highlight

方法：枚举
由于从 #000 到 #fff 一共只有 16^3 = 4096 种颜色，因此我们可以枚举这些颜色，并计算其与 color 的相似度。

java
python
public class Solution {
    public String similarRGB(String color) {
        int hex1 = Integer.parseInt(color.substring(1), 16);
        int ans = 0;
        for (int r = 0; r < 16; ++r)
            for (int g = 0; g < 16; ++g)
                for (int b = 0; b < 16; ++b) {
                    int hex2 = 17 * r * (1 << 16) + 17 * g * (1 << 8) + 17 * b;
                    if (similarity(hex1, hex2) > similarity(hex1, ans))
                        ans = hex2;
                }

        return String.format("#%06x", ans);
    }

    public int similarity(int hex1, int hex2) {
        int ans = 0;
        for (int shift = 16; shift >= 0; shift -= 8) {
            int col1 = (hex1 >> shift) % 256;
            int col2 = (hex2 >> shift) % 256;
            ans -= (col1 - col2) * (col1 - col2);
        }
        return ans;
    }
}
More
Java
Python 3
2022-05-16
5
Bo0lean
Highlight

形如AA的十六进制数必定是17的倍数，我们只要判断离原数最接近的17的倍数是多少即可。

class Solution:
    """
    @param color: the given color
    @return: a 7 character color that is most similar to the given color
    """
    #形如AA的十六进制数必定是17的倍数，我们只要判断离原数最接近的17的倍数是多少即可。
    def similarRGB(self, color):
        # Write your code here
        def geClosest(s):
            return min(['00', '11', '22', '33', '44', '55', '66', '77', '88', '99', 'aa', 'bb', 'cc', 'dd', 'ee', 'ff'],
                key=lambda x: abs(int(s, 16) - int(x, 16)))

        res = [geClosest(color[i:i+2]) for i in range(1, len(color), 2)]
        return '#' + ''.join(res)

More
Python 3
2020-06-09
2
2
Bo0lean
Highlight

形如AA的十六进制数必定是17的倍数，我们只要判断离原数最接近的17的倍数是多少即可。

public class Solution {
    /**
     * @param color: the given color
     * @return: a 7 character color that is most similar to the given color
     */
    // 形如AA的十六进制数必定是17的倍数，我们只要判断离原数最接近的17的倍数是多少即可。
    public String similarRGB(String color) {
        // Write your code here

        StringBuilder sb = new StringBuilder(color.length());
        sb.append("#");
        for (int i = 1; i < color.length(); i += 2){
            sb.append(getHexDigits(color.charAt(i), color.charAt(i + 1)));
        }
        return sb.toString();
    }

    private String getHexDigits(char c1, char c2){
        int d1 = Character.isDigit(c1)? c1 - '0': 10 + c1 - 'a';
        int d2 = Character.isDigit(c2)? c2 - '0': 10 + c2 - 'a';

        int sum       = d1 * 16 + d2;
        int index     = sum / 17; // [ 0x00(0) , 0x11(17), 0x22(34),  0x33(51), ........., 0xff(255) ]
        int remainder = sum % 17;
        if (remainder > 17 / 2){
            index++;
        }

        char c = 0 <= index && index <= 9? (char)('0' + index): (char)('a' + index - 10);
        return String.valueOf(c) + String.valueOf(c);
    }    
}

More
Java
2020-06-09
Bo0lean
Highlight

形如AA的十六进制数必定是17的倍数，我们只要判断离原数最接近的17的倍数是多少即可。

class Solution {
public:
    /**
     * @param color: the given color
     * @return: a 7 character color that is most similar to the given color
     */
    // 形如AA的十六进制数必定是17的倍数，我们只要判断离原数最接近的17的倍数是多少即可。
    string helper(string str) {
        string dec_to_hex = "0123456789abcdef", res = "";

        int dec_num = stoi(str, nullptr, 16);
        int q = dec_num / 17;
        if ((dec_num % 17) > 8) q = q + 1;
        res = res + dec_to_hex[q] + dec_to_hex[q];
        return res;
    }

    string similarRGB(string &color) {
        // Write your code here
        return "#" + helper(color.substr(1, 2)) + helper(color.substr(3, 2)) + helper(color.substr(5, 2));
    }    
};

More
C++
2020-06-09
qingmo

因为r,g,b每一个数都是16进制，所以只要得到每一个r,g,b的两位十六进制数，然后比较转换第一位还是第二位就好。我们知道最后的结果必须是AA，所以最后的结果是17的倍数。很明显，如果这个数n除以17的余数大于8那么这个数距离 (n / 17 + 1) * 17更近

public String similarRGB(String color) {
        // Write your code here
        return "#" + helper(color.substring(1, 3)) + helper(color.substring(3, 5)) + helper(color.substring(5));
    }
    private String helper(String s){
        int c = Integer.parseInt(s, 16);
        c = c / 17 + (c % 17 > 8? 1 : 0);
        return String.format("%02x", c * 17);
    }

More
Java
2021-09-10
6

很容易发现 shorthand color 就是 RGB 都可以被17整除的颜色。
所以只需要分别对 RGB 部分除以 17 取整，就可以得到对应的值，然后格式化为十六进制即可。

class Solution:
    """
    @param color: the given color
    @return: a 7 character color that is most similar to the given color
    """
    def similarRGB(self, color):
        red = int(color[1:3], 16)
        green = int(color[3:5], 16)
        blue = int(color[5:7], 16)
        
        r = round(red / 17) * 17
        g = round(green / 17) * 17
        b = round(blue / 17) * 17
        
        return '#%02x%02x%02x' % (r, g, b)

More
Python 3
2020-06-09
6
我是王阳

解题思路
题解代码

python
class Solution:
    """
    @param color: the given color
    @return: a 7 character color that is most similar to the given color
    """
    def similar_r_g_b(self, color: str) -> str:
        # Write your code here
        a=['0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f']
        string='#'
        for i in range(1,6,2):
            if color[i]==color[i+1]:
                string=string+color[i]+color[i]
            elif a.index(color[i])-a.index(color[i+1])>0:
                if a.index(color[i])-a.index(color[i+1])>8:
                    string=string+a[int(color[i], 16)-1]+a[int(color[i], 16)-1]
                else:
                    string=string+color[i]+color[i]
            else:
                if a.index(color[i+1])-a.index(color[i])>8:
                    string=string+a[int(color[i], 16)+1]+a[int(color[i], 16)+1]
                else:
                    string=string+color[i]+color[i]
        return string

More
Python 3
2024-01-13
2
1
Celiorty

娱乐一行流，分成3个数字转10进制后靠近17倍数取整后转回16进制，添加#输出。#800
题解代码

python
class Solution:
    """
    @param color: the given color
    @return: a 7 character color that is most similar to the given color
    """
    def similarRGB(self, color):
        # Write your code here
        return '#' + ''.join(['{:02x}'.format(round(int(color[i] + color[i + 1], 16) / 17) * 17) for i in (1, 3, 5)])

More
Python 3
2021-12-10
2
HUE

解题思路
题解代码

cpp
class Solution {
public:
    /**
     * @param color: the given color
     * @return: a 7 character color that is most similar to the given color
     */
    string similarRGB(string &color) {
        return "#" + helper(color.substr(1, 2)) + helper(color.substr(3, 2)) + helper(color.substr(5, 2));
    }

    string helper(string str) {
        string res = "";
        int source = stoi(str, nullptr, 16);
        int target = source / 17 + (source % 17 > 8 ? 1 : 0);
        if (target < 10) {
            res += target + '0';
            res += target + '0';
        } else {
            res += target % 10 + 'a';
            res += target % 10 + 'a';
        }
        return res;
    }
};

More
C++
2021-10-12
1
1
2
3
·····
Java
autocomplete turned on
Launch Exam
15 分 00 秒
1
2
3
4
5
6
7
public·class·Solution·{
····/**
·····*·@param·color:·the·given·color
·····*·@return:·a·7·character·color·that·is·most·similar·to·the·given·color
·····*/
·····public·String·similarRGB(String·color)·{
········return·"#"·+·f(color.substring(1,·3))·+·f(color.substring(3,·5))·+·f(color.substring(5));</pre>