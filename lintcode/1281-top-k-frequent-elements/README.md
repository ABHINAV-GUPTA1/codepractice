<h2><a href="https://www.lintcode.com/problem/1281/solution">LintCode Top K Frequent Elements</a></h2><h3>Medium</h3><p>Time: 460 ms | Space: 25.89 MB</p><hr><pre>Solution
40
Notes
Discuss
54
Leaderboard
Record
ALL(40)
Java(20)
Python 3(11)
C++(8)
C(2)
Csharp(1)
Go(1)
TypeScript(1)
Create Solution
LintCodeOfficial
Official

这题可以通过最小堆或者桶排实现：

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>>(
            new Comparator<Map.Entry<Integer, Integer>>() {
                public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                    return e1.getValue() - e2.getValue();
                }
            });
        for (int i = 0; i < nums.length; i++) {
            if (!hashmap.containsKey(nums[i])) {
                hashmap.put(nums[i], 1);
            } else {
                hashmap.put(nums[i], hashmap.get(nums[i]) + 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry);
            } else if (queue.peek().getValue() < entry.getValue()) {
                queue.poll();
                queue.offer(entry);
            }
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : queue)
            ans.add(entry.getKey());
        return ans;
    }
}

More
Java
2021-04-08
2
2
伟大的狗子
Highlight

方法：堆
思路与算法

java
cpp
c
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            ret.add(queue.poll()[0]);
        }
        return ret;
    }
}
More
Java
C++
C
2022-05-20
10
伟大的狗子
Highlight

方法：基于快速排序
思路与算法

java
cpp
c
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<int[]>();
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count});
        }
        int[] ret = new int[k];
        qsort(values, 0, values.size() - 1, ret, 0, k);
        List<Integer> res = new ArrayList<>();
        for (int i: ret)
            res.add(i);
        return res;
    }

    public void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, picked, start);
        
        int pivot = values.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start) {
            qsort(values, start, index - 1, ret, retIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {
                qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }
}
More
Java
C++
C
2022-05-20
9
Bo0lean
Highlight
class Solution:
    def topKFrequent(self, nums, k):
        # 统计元素的频率
        freq_dict = dict()
        for num in nums:
            freq_dict[num] = freq_dict.get(num, 0) + 1
            
        # 按照频率进行排序
        freq_dict_sorted = sorted(freq_dict.items(), key=lambda x: x[1], reverse=True)
        
        # 取前k个元素返回
        ret = list()
        for i in range(k):
            ret.append(freq_dict_sorted[i][0])
        return ret

More
Python 3
2020-06-09
2
1
Bo0lean
Highlight
class Solution {
public:
    /**
     * @param nums: the given array
     * @param k: the given k
     * @return: the k most frequent elements
     */
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> freq;
        auto it = nums.begin();
        for (int n : nums) if (!freq[n]++) *it++ = n;
        nums.resize(freq.size());
        nth_element(
            nums.begin(), nums.begin() + (k - 1), nums.end(),
            [&](int a, int b) { return freq[a] > freq[b]; });
        nums.resize(k);
        return move(nums);
    }
};

More
C++
2020-06-09
4
haiyu

参考了花花酱的思路，先统计出frequency之后，不使用heap来做取最大的k个，而是把频率当做一个递增的array取最大的x个具体的方法是，算出频率之后，转换成一个频率->number list的map，从MaxFreq向1 traverse，依次把结果加到results中
复杂度是O(N)，统计频率是O(N), 转换还是O(k)，k是distinct number个数，最后的traverse是O(MaxFreq)，上限是O(N)

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> results = new ArrayList<>();
        if (nums == null || nums.length == 0 || k == 0) return results;
        //统计词频
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            maxFreq = Math.max(maxFreq, map.get(num));
        }
        //建立从词频到词的索引
        Map<Integer, List<Integer>> freqToNum = new HashMap<>();
        for (int key: map.keySet()) {
            int freq = map.get(key);
            if (!freqToNum.containsKey(freq)) {
                freqToNum.put(freq, new ArrayList<>());
            }
            freqToNum.get(freq).add(key);
        }
        for (int freq = maxFreq; freq > 0; freq--) {
            if (freqToNum.containsKey(freq)) {
                for (int num: freqToNum.get(freq)) {
                    results.add(num);
                    if (results.size() == k) return results;
                }
            }
        }
        return results;
    }
}

More
Java
2021-09-23
3
satoshi

解题思路
this is easy solution. https://gta.sg

python
from typing import (
    List,
)

class Solution:
    """
    @param nums: the given array
    @param k: the given k
    @return: the k most frequent elements
             we will sort your return value in output
    """
    def top_k_frequent(self, nums: List[int], k: int) -> List[int]: 
        # Write your code here
        return [i for i, _ in collections.Counter(nums).most_common(k)]

More
Python 3
2024-12-26
1
Celiorty

One line solution, beat 100%🤔.
题解代码

python
class Solution:
    """
    @param nums: the given array
    @param k: the given k
    @return: the k most frequent elements
    """
    def topKFrequent(self, nums, k):
        # Write your code here
        return [i for i, _ in collections.Counter(nums).most_common(k)]

More
Python 3
2021-11-13
1
Haruna

这题count所有数字的频率之后用heap解就是很直观的O(Nlogk)。不过再贴一个练习quick select的：类似于quick select，我们只需要一个partially sorted array， 所以可以做到平均O(N)的时间， worst case O（N2）

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = collections.Counter(nums)
        
        vals = list(count.keys())
        
        self.sort(vals, count, 0, len(vals) - 1, k)
        return vals[:k]
        
    def sort(self, nums, count_dict, i, j, k):    
        left, right = i, j
        
        if left >= right:
            return
        
        pivot = count_dict[nums[(i + j) // 2]]
        
        while left <= right:
            while left <= right and count_dict[nums[left]] > pivot:
                left += 1
            while left <= right and count_dict[nums[right]] < pivot:
                right -= 1
            
            if left <= right:
                nums[left], nums[right] = nums[right], nums[left]
                left += 1
                right -= 1
        
        if k - 1 <= right:
            return self.sort(nums, count_dict, i, right, k)
        if k - 1 >= left:
            return self.sort(nums, count_dict, left, j, k)

More
Python 3
2021-02-22
1
MiddleDB

用了一个辅助类，pair存element和element出现的次数，然后用最大堆全部放进去，倒出来k个就行了。代码有点长，觉得比较好理解。

class Pair {
    int val;
    int frequency;
    public Pair(int val, int frequency) {
        this.val = val;
        this.frequency = frequency;
    }
}

class PairComparator implements Comparator<Pair> {
    public int compare (Pair a, Pair b) {
        return b.frequency - a.frequency;
    }
}

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(k,new PairComparator());
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i],1);
            } else {
                map.put(nums[i],map.get(nums[i]) + 1);
            }
        }
        
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            maxHeap.add(new Pair(entry.getKey(),entry.getValue()));
        }
        
        for (int i = 0; i < k; i++) {
            Pair temp = maxHeap.poll();
            result.add(temp.val);
        }
        return result;
    } 
}

More
Java
2021-01-18
1
1
1
2
3
4
·····
Java
autocomplete turned on
Launch Exam
30 分 00 秒
1
2
3
4
5
6
7
8
9
10
public·class·Solution·{
····/**
·····*·@param·nums:·the·given·array
·····*·@param·k:·the·given·k
·····*·@return:·the·k·most·frequent·elements
·····*··········we·will·sort·your·return·value·in·output
·····*/
····public·List<Integer>·topKFrequent(int[]·nums,·int·k)·{
········//·Write·your·code·here
········Map<Integer,·Integer>·occurrences·=·new·HashMap<Integer,·Integer>();</pre>