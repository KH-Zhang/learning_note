package Char.Char_58;

public class Solution {
    public String ReverseSentence(String str) {
        if(str == null){
            return null;
        }
        char[] chars = str.toCharArray();
        revrese(chars,0,str.length()-1);
        int i = 0;
        for (int j = 0; j < chars.length; j++) {
            if(chars[j] == ' '){
                revrese(chars,i,j-1);
                i = j+1;
            }
        }
        revrese(chars,i,chars.length-1);
        return new String(chars);
    }

    private void revrese(char[] chars,int left,int right){
        while(left < right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
