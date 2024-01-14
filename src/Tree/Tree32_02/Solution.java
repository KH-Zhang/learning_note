package Tree.Tree32_02;

import Utils.BinaryTreeNode;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 之字形打印二叉树
 */

public class Solution {

    public ArrayList<ArrayList<Integer>> Print(BinaryTreeNode pRoot){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null){
            return result;
        }

        int count = 0;
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();

        stack1.push(pRoot);
        while (stack1 != null || stack2 != null){
            ArrayList<Integer> res = new ArrayList<>();

            if(count % 2 == 0){
                while (stack1 != null){
                    BinaryTreeNode pop = stack1.pop();
                    if(pop.Left !=null){
                        stack2.push(pop.Left);
                    }
                    if(pop.Right != null){
                        stack2.push(pop.Right);
                    }
                    res.add(pop.Value);
                }
            }

            if(count % 2 == 1){
                while (stack2 != null){
                    BinaryTreeNode pop = stack2.pop();
                    if(pop.Right != null){
                        stack1.push(pop.Right);
                    }
                    if(pop.Left !=null){
                        stack1.push(pop.Left);
                    }
                    res.add(pop.Value);
                }
            }
            result.add(res);

        }
        return result;
    }
}
