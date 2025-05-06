//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Main {
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input1 = br.readLine().trim().split("\\s+");
            if (input1.length < 2) {
                System.out.println(-1);
                continue;
            }
            int a = Integer.parseInt(input1[0]);
            int b = Integer.parseInt(input1[1]);

            String[] input2 = br.readLine().trim().split("\\s+");
            if (input2.length == 0) {
                System.out.println(-1);
                continue;
            }

            Node head = new Node(Integer.parseInt(input2[0]));
            Node tail = head;
            for (int i = 1; i < input2.length; i++) {
                tail.next = new Node(Integer.parseInt(input2[i]));
                tail = tail.next;
            }

            Solution ob = new Solution();
            Node newHead = ob.reverseBetween(a, b, head);
            printList(newHead);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution {
    public static Node reverseBetween(int a, int b, Node head) {
        if (head == null || a == b) {
            return head;
        }
        
        Node ans = new Node (-1);
        Node res = ans;
        for (int i = 1; i < a; i++) {
            res.next = head;
            head = head.next;
            res = res.next;
        }
        Node rev = head;
        
        Node curr = head, prev = null, next = null;
        int i = a;
        while (curr != null && i <= b) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        
        res.next = prev;
        rev.next = curr;
        
        
        return ans.next;
    }
    
    
}