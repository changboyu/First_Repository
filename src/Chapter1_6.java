public class Chapter1_6 {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		Chapter1_6 test = new Chapter1_6();
		test.showMatrix(matrix);
		System.out.println();
		test.showMatrix(test.createMatrix(matrix));
		System.out.println();
		test.rotateMatrix(matrix);
		test.showMatrix(matrix);
	}

	public void rotateMatrix(int[][] matrix) {
		// right rotate
		for (int layer = 0; layer < matrix.length / 2; ++layer) {
			int first = layer;
			int last = matrix.length - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;

				// save top
				int top = matrix[first][i];

				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top;
			}
		}
		
		//left rotate
		 for (int layer = 0; layer < matrix.length; layer++) {
		 int first = layer;
		 int last = matrix.length - 1 - layer;
		 for (int i = first; i < last; i++) {
		 int offset = i - first;
		
		 // save top
		 int top = matrix[first][i];
		
		 // right -> top
		 matrix[first][i] = matrix[i][last];
		
		 // bottom ->right
		 matrix[i][last] = matrix[last][last - offset];
		
		 // left -> bottom
		 matrix[last][last - offset] = matrix[last - offset][first];
		
		 // top -> left
		 matrix[last - offset][first] = top;
		 }
		 }
	}

	public int[][] createMatrix(int[][] matrix) {

		int[][] result = new int[matrix.length][matrix.length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				result[i][j] = matrix[j][matrix.length - i - 1];

			}
		}
		return result;
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
