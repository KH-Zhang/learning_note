package Array.Array_66;
public class Solution {
    public int[] multiply(int[] A){
        int[] a = new int[A.length];
        int[] b = new int[A.length];
        int[] c = new int[A.length];
        a[0] = 1;
        for (int i = 1; i < A.length; i++) {
            a[i]= a[i-1] * A[i-1];
        }
        b[A.length-1] = 1;
        for (int i = A.length-2; i >= 0; i--) {
            b[i] = A[i+1] * b[i+1];
        }
        for (int i = 0; i < A.length; i++) {
            c[i] = a[i] * b[i];
        }
        return c;
    }
}
