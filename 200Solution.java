// ============ BFS ==============
 class Coordinate{
 	int x;
 	int y;
 	public Coordinate(int x, int y) {
 		this.x = x;
 		this.y = y;
 	}
 }

 int[] deltaX = {1, 0, 0, -1};
 int[] deltaY = {0, 1, -1, 0};
 public int numIslands(char[][] grid) {
 	int n = grid.length;
 	int m = grid[0].length;
 	int num = 0;
 	for (int i = 0; i < n; i++) {
 		for (int j = 0; j < m; j++) {
 			if(grid[i][j] == '1') {
 				markByBFS(grid, i, j);
 				num++;
 			}
 		}
 	}	
 	return num;
 }
 private void markByBFS(char[][] grid, int i, int j) {
 	Queue<Coordinate> q = new LinkedList<>();
 	q.offer(new Coordinate(i, j));
 	grid[i][j] = '0';
 	while (!q.isEmpty()) {
 		Coordinate point = q.poll();
 		for (int i = 0; i < 4; i++) {
 			Coordinate nei = new Coordinate(point.x + deltaX[i], point.y + deltaY);
 			if (!inBound(nei.x, nei.y, grid)) {
 				continue;
 			}
 			if (grid[nei.x][nei.y] == '1') {
 				q.offer(nei);
 				grid[nei.x][nei.y] = '0';
 			}
 		}
 	}
 }
 private boolean inBound (int x, int y, char[][] grid) {
 	return x >= 0 && (x < grid.length) && y >=0 && (y < grid[0].length);
 }

 