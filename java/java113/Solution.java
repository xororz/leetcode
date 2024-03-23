package java113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, res);
        return res;
    }

    public void dfs(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> res) {
        System.out.println(path);
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                path.add(root.val);
                res.add(new LinkedList<Integer>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        dfs(root.left, targetSum - root.val, path, res);
        dfs(root.right, targetSum - root.val, path, res);
        path.remove(path.size() - 1);
        return;
    }

    public TreeNode toTree(List<Integer> list) {
        if (list.size() == 0)
            return null;
        TreeNode root = new TreeNode(list.get(0));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < list.size()) {
            TreeNode cur = queue.remove();
            if (list.get(i) != null) {
                cur.left = new TreeNode(list.get(i));
                queue.add(cur.left);
            } else {
                cur.left = null;
            }
            i++;
            if (i < list.size()) {
                if (list.get(i) != null) {
                    cur.right = new TreeNode(list.get(i));
                    queue.add(cur.right);
                } else {
                    cur.right = null;
                }
                i++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Integer[] arr = { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1 };
        List<Integer> list = new ArrayList<>();
        for (Integer i : arr) {
            list.add(i);
        }
        TreeNode tree = s.toTree(list);
        System.out.println(s.pathSum(tree, 22));
    }
}