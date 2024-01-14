package Tree.Tree54;

import Utils.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    ArrayList<BinaryTreeNode> list = new ArrayList<>();
    BinaryTreeNode KthNode(BinaryTreeNode pRoot, int k){
        if(k <= 0){
            return null;
        }
        KthNode(pRoot);
        if(k > list.size()){
            return null;
        }
        return list.get(k - 1);

    }
    void KthNode(BinaryTreeNode pRoot){
        if(pRoot != null){
            KthNode(pRoot.Left);
            list.add(pRoot);
            KthNode(pRoot.Right);
        }
    }
}
