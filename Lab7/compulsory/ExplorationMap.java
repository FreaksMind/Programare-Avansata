package lab7;

import java.util.ArrayList;
import java.util.List;

public class ExplorationMap {
	private final SharedMemory[][] matrix;

	public ExplorationMap(int size) {
		matrix = new SharedMemory[size][size];
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				matrix[i][j] = new SharedMemory(size);
			}
		}
	}

	public boolean visit(int row, int col, Robot robot) {
		synchronized (matrix[row][col]) {
			if (!matrix[row][col].isVisited()) {
				List<Token> tokens = new ArrayList<>();
				tokens = matrix[row][col].extractTokens(robot.getNumTokens());
				matrix[row][col].setVisited(true);
				matrix[row][col].addTokens(tokens);
				System.out.println(robot.getName() + " succesfully visited a cell!");
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder matrix = new StringBuilder();
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix.length; j++) {
				matrix.append(this.matrix[i][j]);
				matrix.append(" ");
			}
			matrix.append("\n");
		}
		return matrix.toString();
	}
}
