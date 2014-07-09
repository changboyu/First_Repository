import java.util.ArrayList;
import java.util.Arrays;

public class Chapter1_7 {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 0, 9 } };
		// int[][] matrix2 = new int[10][10];

		Chapter1_7 test = new Chapter1_7();
		test.setMatrix1(matrix, 3, 3);
		test.showMatrix(matrix);

	}

	public int[][] setMatrix1(int[][] matrix, int m, int n) {
		ArrayList<Integer> i_index = new ArrayList<Integer>();
		ArrayList<Integer> j_index = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					i_index.add(i);
					j_index.add(j);
				}
			}

		}
		for (int a : i_index) {
			for (int j = 0; j < n; j++)
				matrix[a][j] = 0;
		}
		for (int b : j_index) {
			for (int i = 0; i < m; i++)
				matrix[i][b] = 0;
		}
		return matrix;
	}

	public int[][] setMatrix(int[][] matrix) {
		int[][] p = matrix;
		String rowS = null;
		for (int row[] : matrix)
			rowS = Arrays.toString(row);
		String ans = (rowS.contains("0")) ? "yes" : "no";
		System.out.println(ans);
		System.out.println(rowS);

		return p;
	}

	public void showMatrix(int[][] matrix) {
		for (int[] items : matrix) {
			for (int item : items) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}

}
