//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");

            Solution obj = new Solution();

            String encodedString = obj.encode(s);
            String decodedStrings[] = obj.decode(encodedString);

            for (String x : decodedStrings) {
                System.out.print(x + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    public String encode(String s[]) {
        StringBuilder sb = new StringBuilder();
        
        for (String str : s) {
            sb.append((char) str.length())
                .append(str);
        }
        
        return sb.toString();
    }

    public String[] decode(String s) {
        List<String> res = new ArrayList<>();
        int index = 0;
        int size = 0;
        int length = s.length();
        while (index < length) {
            size = s.charAt(index++);
            res.add(s.substring(index, index + size));
            index = index + size;
        }
        
        return res.toArray(new String[0]);
    }
}