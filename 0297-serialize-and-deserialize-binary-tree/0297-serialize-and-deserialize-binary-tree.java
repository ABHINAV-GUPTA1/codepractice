/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            if (tmp == null) {
                sb.append("# ");
                continue;
            }

            sb.append(tmp.val).append(" ");
            q.offer(tmp.left);
            q.offer(tmp.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] dataArr = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for (int i = 1; i < dataArr.length; i++) {
            TreeNode parent = q.poll();
            if (!dataArr[i].equals("#")) {
                parent.left = new TreeNode(Integer.parseInt(dataArr[i]));
                q.offer(parent.left);
            }
            if (!dataArr[++i].equals("#")) {
                parent.right = new TreeNode(Integer.parseInt(dataArr[i]));
                q.offer(parent.right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));