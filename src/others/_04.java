package others;

public class _04 {
    public boolean Find(int target, int [][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int row = 0;
        int col = cols -1;
        if(rows == 0 || cols == 0){
            return false;
        }
        while (row <= rows-1 && col >= 0){
            if(array[row][col] == target){
                return true;
            }else if(array[row][col] < target){
                row++;
            }else {
                col--;
            }
        }
        return  false;
    }
}
