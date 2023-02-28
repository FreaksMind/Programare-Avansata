package lab1.homework;

public class Main {

	//Al shrafat Maroan
	public class main {

		public static void main(String[] args) {
			if (args.length != 1) {
				System.out.println("Enter argument please!");
				System.exit(-1);
			}
			int n = 0;
			try {
				n = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.out.println("Please input a number!");
				System.exit(-1);
			}
			if (n < 1) {
				System.out.println("Please choose a number >= 1!");
				System.exit(-1);
			}

			long start = System.currentTimeMillis();

			int[][] latinSquare = new int[n][n];
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					latinSquare[i][j] = ((j + i) % n) + 1;
				}
			}

			long end = System.currentTimeMillis();

			if (n < 10) {
				for (int i = 0; i < n; ++i) {
					StringBuilder columns = new StringBuilder();
					StringBuilder rows = new StringBuilder();
					for (int j = 0; j < n; ++j) {
						// System.out.print(latinSquare[i][j] + " ");
						rows.append(latinSquare[i][j]);
						columns.append(latinSquare[j][i]);
					}
					System.out.printf("Row(%d) ", i);
					System.out.print(rows.toString());
					System.out.printf(" Column(%d) ", i);
					System.out.print(columns.toString());
					System.out.println(" ");
				}
			}

			System.out.printf("Time elapsed: %d ms.", (end - start));
		}
	}

}
