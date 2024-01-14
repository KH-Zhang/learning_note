package Tree.Tree32_01;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 层序遍历，一层一层输出
 */
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> qu = new LinkedList<>();

        //为空的处理方法
        if(pRoot == null){
            return result;
        }

        qu.add(pRoot);
        while(!qu.isEmpty()){
            ArrayList<Integer> rs = new ArrayList<>();
            int size = qu.size();
            for (int i = 0; i <size ; i++) {
                TreeNode poll = qu.poll();
                rs.add(poll.val);
                if(poll.left != null){
                    qu.add(poll.left);
                }
                if(poll.right != null){
                    qu.add(poll.right);
                }
            }
            result.add(rs);
        }
        return result;
    }
}
