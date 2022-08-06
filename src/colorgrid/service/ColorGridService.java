package colorgrid.service;

public class ColorGridService {

	private int rows = 12;
	private int columns = 10;
	
	private int[][] inputData =null;
	// Using Memorisation to avoid visit already visited nodes
	private final int[][] visited = new int[rows][columns];

	private final int[][] finalResult = new int[rows][columns];

	private int count;

	private boolean isValid(int x, int y, int key, int[][] input) {
		if (x < rows && y < columns && x >= 0 && y >= 0) {
			return visited[x][y] == 0 && input[x][y] == key;
		} else
			return false;
	}

	private void doBFSearch(int x, int y, int i, int j, int[][] input) {
		// terminating case for BFS
		if (x != y)
			return;

		visited[i][j] = 1;
		count++;
		int[] xMove = { 0, 0, 1, -1 };
		int[] yMove = { 1, -1, 0, 0 };

		for (int u = 0; u < 4; u++)
			if (isValid(i + yMove[u], j + xMove[u], x, input))
				doBFSearch(x, y, i + yMove[u], j + xMove[u], input);
	}

	private void resetVisitedNode() {
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				visited[i][j] = 0;
	}

	private void resetResults(int key, int[][] input) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (visited[i][j] == 1 && input[i][j] == key)
					finalResult[i][j] = visited[i][j];
				else
					finalResult[i][j] = 0;
			}
		}
	}

	private int getFinalResultAsInt(int res) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (finalResult[i][j] != 0)
					return inputData[i][j];
			}
		}
		return -1;
	}

	public int computeLargestConnectedGrid(int[][] input) {
		int currentMax = Integer.MIN_VALUE;
		inputData = input;
		rows = input.length;
		for (int i = 0; i < rows; i++) {
			columns = input[i].length;
			for (int j = 0; j < columns; j++) {
				resetVisitedNode();
				count = 0;
				// Traversing to the right
				if (j + 1 < columns)
					doBFSearch(input[i][j], input[i][j + 1], i, j, input);

				// updating result
				if (count >= currentMax) {
					currentMax = count;
					resetResults(input[i][j], input);
				}
				resetVisitedNode();
				count = 0;
				// Traversing downwards
				if (i + 1 < rows)
					doBFSearch(input[i][j], input[i + 1][j], i, j, input);

				// updating result
				if (count >= currentMax) {
					currentMax = count;
					resetResults(input[i][j], input);
				}
			}
		}
		return getFinalResultAsInt(currentMax);
	}
}
