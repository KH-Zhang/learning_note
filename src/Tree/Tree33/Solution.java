package Tree.Tree33;

import java.util.Arrays;
//代码可优化

public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence){
        //仅仅用来判断为空的情况
        if(sequence.length == 0){
            System.out.println("false");
            return false;
        }

        int root = sequence[sequence.length -1];
        int i ;
        for ( i = 0; i < sequence.length - 1; i++) {
            if(sequence[i] > root){

                break;
            }
        }
        int index = i;
        //左子树不用判断一定正确

        //判断右子树
        for (int j = index; j < sequence.length - 1; j++) {
            if(sequence[j] < root){
                System.out.println("false");
                return false;
            }
        }

        if(index > 0){
            VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,index));
        }

        if(index < sequence.length -1 ){
            VerifySquenceOfBST(Arrays.copyOfRange(sequence,index,sequence.length -1));
        }

        System.out.println("true");
        return true;

    }
}
