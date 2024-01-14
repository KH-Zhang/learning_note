package others;

public class _05 {
    public static String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        if(str == null){
            return sb.toString();
        }
        char[] chars = str.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' '){
                sb.append('%');
                sb.append('2');
                sb.append('0');
            }else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
