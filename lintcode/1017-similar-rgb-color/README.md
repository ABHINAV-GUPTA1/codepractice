<h2><a href="https://www.lintcode.com/problem/1017">LintCode Similar RGB Color</a></h2><h3>Easy</h3><p>Time: N/A | Space: N/A</p><hr><pre>In the following, every capital letter represents some hexadecimal digit from 0 to f.

The red-green-blue color "#AABBCC" can be written as "#ABC" in shorthand. For example, "#15c" is shorthand for the color "#1155cc".

Now, say the similarity between two colors "#ABCDEF" and "#UVWXYZ" is abs((AB - UV)^2 + (CD - WX)^2 + (EF - YZ)^2).

Given the color "#ABCDEF", return a 7 character color that is most similar to #ABCDEF, and has a shorthand (that is, it can be represented as some "#XYZ")

LintCode - Online Judge Solution

Candidate Written Test Screening, Team Competency Assessment, Programming Teaching Exercises, Online Exam Grading

WeChat for information

color is a string of length 7.
color is a valid RGB color: for i > 0, color[i] is a hexadecimal digit from 0 to f
Any answer which has the same (highest) similarity as the best answer will be accepted.
All inputs and outputs should use lowercase letters, and the output is 7 characters.
Example

Example 1:

Input:

color = "#09f166"

Output:

"#11ee66"

Explanation:

The similarity is -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -73.
This is the highest among any shorthand color.

Example 2:

Input:

color = "#010000"

Output:

"#000000"

Explanation:

The similarity is -(0x01 - 0x00)^2 -(0x00 - 0x00)^2 - (0x00 - 0x00)^2 = -1 -0 -0 = -1.
This is the highest among any shorthand color.</pre>