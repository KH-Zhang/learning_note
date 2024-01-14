package others;

public class _67 {
    public static int StrToInt(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;
        if(length == 0){
            return 0;
        }
        int bitIndex = 1;
        int result = 0;
        for (int i = chars.length - 1; i > 0; i--) {
            if(chars[i] < '0' || chars[i] > '9'){
                return 0;
            }

            String s = chars[i]+"";
            int i1 = Integer.parseInt(s);
            result += i1 * bitIndex;
            bitIndex *= 10;
        }
        if(chars[0] == '-'){
            return result * (-1);
        }else if (chars[0] == '+'){
            return result;
        }else {
            return result + Integer.parseInt(chars[0]+"") * bitIndex;
        }

    }

    public static void main(String[] args) {
        String s = "-2147483649";
        //System.out.println(StrToInt(s));
        int index = 1000000000;
        int i = 147483649;
        int j = 2;
        int result = i + j * index;
        System.out.println(j * index);
        System.out.println(result);
    }
}
