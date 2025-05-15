//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    public String findOrder(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> in = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        for (String w : words) {
            for (char c : w.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                in.putIfAbsent(c, 0);
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minlen = Math.min(w1.length(), w2.length());
            for (int j = 0; j < minlen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (adj.get(w1.charAt(j)).contains(w2.charAt(j))) {
                        break;
                    }
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    in.put(w2.charAt(j), in.getOrDefault(w2.charAt(j), 0) + 1);
                    break;
                }
                if (j == minlen - 1 && w1.length() > w2.length()) {
                    return "";
                }
            }
        }
        
        for (Map.Entry<Character, Integer> mw : in.entrySet()) {
            if (mw.getValue() == 0) {
                q.offer(mw.getKey());
            }
        }
        
        while (!q.isEmpty()) {
            char u = q.poll();
            sb.append(u);
            if (!adj.containsKey(u)) {
                continue;
            }
            for (char v : adj.get(u)) {
                in.put(v, in.get(v) - 1);
                if (in.get(v) == 0) {
                    q.offer(v);
                }
            }
        }
        
        return sb.length() >= in.size() ? sb.toString() : "";
        
        
    }
}


//{ Driver Code Starts.

public class GFG {
    private static boolean validate(String[] original, String order) {
        Map<Character, Integer> mp = new HashMap<>();
        for (String word : original) {
            for (char ch : word.toCharArray()) {
                mp.put(ch, 1);
            }
        }
        for (char ch : order.toCharArray()) {
            if (!mp.containsKey(ch)) {
                return false;
            }
            mp.remove(ch);
        }
        if (!mp.isEmpty()) {
            return false;
        }

        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            indexMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < original.length - 1; i++) {
            String a = original[i];
            String b = original[i + 1];
            int k = 0, n = a.length(), m = b.length();

            while (k < n && k < m && a.charAt(k) == b.charAt(k)) {
                k++;
            }

            if (k < n && k < m &&
                indexMap.get(a.charAt(k)) > indexMap.get(b.charAt(k))) {
                return false;
            }
            if (k != n && k == m) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()); // Number of test cases

        while (t-- > 0) {
            String[] words = sc.nextLine().split(" ");
            String[] original = Arrays.copyOf(words, words.length);

            Solution ob = new Solution();
            String order = ob.findOrder(words);

            if (order.isEmpty()) {
                System.out.println("\"\"");
            } else {
                System.out.println(validate(original, order) ? "true" : "false");
            }
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends