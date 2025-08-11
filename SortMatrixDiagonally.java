import java.util.*;

public class SortMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int row = mat.length - 1;
        int col = 0;
        for (int r = row; r >= 0; r--) {
            sort(mat, r, 0);
        }
        for (int c = col; c < mat[0].length; c++) {
            sort(mat, 0, c);
        }
        return mat;
    }

    private void sort(int[][] mat, int row, int col) {
        List<Integer> nums = new ArrayList<>();
        for (int i = row, j = col; i < mat.length && j < mat[row].length; i++, j++) {
            nums.add(mat[i][j]);
        }

        Collections.sort(nums);

        for (int i = row, j = col; i < mat.length && j < mat[row].length; i++, j++) {
            mat[i][j] = nums.removeFirst();
        }
    }
}
