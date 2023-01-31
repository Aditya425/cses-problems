import java.util.*;

public class GridPaths19 {
	static String s = "";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		System.out.println(gridPaths(0, 0, 0));
	}

	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int RIGHT = 0;
	static int LEFT = 1;
	static int DOWN = 2;
	static int UP = 3;
	static int[][] vis = new int[7][7];

	static boolean isValid(int x, int y, int z) {
		return x >= y && x < z;
	}

	static int gridPaths(int x, int y, int pos) {
		if (!isValid(x, 0, 7) || !isValid(y, 0, 7)) {
			return 0;
		}

		if (pos >= s.length()) {
			if (x == 6 && y == 0) {
				return 1;
			}
			return 0;
		}

		if (x == 6 && y == 0) {
			return 0;
		}

		if (vis[x][y] == 1) {
			return 0;
		}

		boolean[] visited = new boolean[4];
		for (int i = 0; i < 4; i++) {
			if (isValid(x + dx[i], 0, 7) && isValid(y + dy[i], 0, 7)) {
				if (vis[x + dx[i]][y + dy[i]] == 1) {
					visited[i] = true;
				} else {
					visited[i] = false;
				}
			}
		}

		if (visited[UP] && !visited[LEFT] && !visited[RIGHT] && visited[DOWN]) {
			return 0;
		}

		if (visited[LEFT] && visited[RIGHT] && !visited[UP] && !visited[DOWN]) {
			return 0;
		}

		if (isValid(x - 1, 0, 7) 
			&& isValid(y - 1, 0, 7) && vis[x -1][y - 1] == 1 && !visited[UP] && !visited[LEFT]) {
				return 0;
			}

		if (isValid(x - 1, 0, 7) && 
			isValid(y + 1, 0, 7) && vis[x - 1][y + 1] == 1 && !visited[UP] && !visited[RIGHT]) {
				return 0;
			}

		if (isValid(x + 1, 0, 7) && isValid(y - 1, 0, 7) 
			&& vis[x + 1][y - 1] == 1 && !visited[LEFT] && !visited[DOWN]) {
				return 0;
			}

		if (isValid(x + 1, 0, 7) && isValid(y + 1, 0, 7) 
			&& vis[x + 1][y + 1] == 1 && !visited[DOWN] && !visited[RIGHT]) {
				return 0;
			}

		vis[x][y] = 1;
		int numberOfPaths = 0;
		if (s.charAt(pos) == '?') {
			for (int i = 0; i < 4; i++) {
				numberOfPaths += gridPaths(x + dx[i], y + dy[i], pos + 1);
			}
		} else {
			if (s.charAt(pos) == 'R') {
				numberOfPaths += gridPaths(x, y + 1, pos + 1);
			} else if (s.charAt(pos) == 'L') {
				numberOfPaths += gridPaths(x, y - 1, pos + 1);
			} else if (s.charAt(pos) == 'U') {
				numberOfPaths += gridPaths(x - 1, y, pos + 1);
			} else if (s.charAt(pos) == 'D') {
				numberOfPaths += gridPaths(x + 1, y, pos + 1);
			}
		}
		vis[x][y] = 0;
		return numberOfPaths;
	}
}
