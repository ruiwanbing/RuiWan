// 130. Surrounded Regions
class Point {
	int x;
	int y;
	public Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Solution {
	static int[] deltaX = {1, 0, 0, -1};
	static int[] deltaY = {0, 1, -1, 0};
	public void solve(char[][] board) {
       if (board == null || board.length == 0 || board[0].length == 0) {
       	return;
       }
       int row = board.length;
       int col = board[0].length;
       Queue<Point> queue = new LinkedList<>();
       // change 'O ' on edges to '+'
       for (int i = 0; i < row; i++) {
       		if (board[i][0] == 'O') {
       			board[i][0] = '+';
       			queue.add(new Point(i, 0));
       		}
       		if (board[i][col - 1] == 'O') {
       			board[i][col - 1] = '+';
       			queue.add(new Point(i, col - 1));
       		}
       }
       for (int j = 0; j < col; j++) {
       	if (board[0][j] == 'O') {
       		board[0][j] = '+';
       		queue.add(new Point(0, j));
       	}
       	if (board[row - 1][j] == 'O') {
       		board[row - 1][j] = '+';
       		queue.add(new Point(row - 1, j));
       	}
       }
       // BFS change '0' connected to edge to '+'
       while (!queue.isEmpty()) {
       	Point p = queue.poll();
       	for (int i = 0; i < 4; i++) {
       		Point newP = new Point(p.x + deltaX[i], p.y + deltaY[i]);
       		if (!isBound(newP.x, newP.y, board)) {
       			continue;
       		}
       		if (board[newP.x][newP.y] == 'O') {
       			board[newP.x][newP.y] = '+';
       			queue.add(newP);
       		}
       	}
       }
      // turn all '0' to 'X' and turn all '+' to '0' 
       for (int i = 0; i < row; i++) {
       	for (int j = 0; j < col; j++) {
       		if (board[i][j] == 'O') {
       			board[i][j] = 'X';
       		}
       		if (board[i][j] == '+') {
       			board[i][j] = 'O';
       		}
       	}
       }
    }
    private boolean isBound(int x, int y, char[][]board) {
    	return x >=0 && x < board.length && y >= 0 && y < board[0].length;
    }
}