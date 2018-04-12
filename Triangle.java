// Triangle
 public int minimumTotal(int[][] triangle) {
 	if (triangle == null || triangle.length == 0 || triangle[0] == null ||triangle.length[0] == 0) {
 		return -1;
 	}
 	// 从memorization理解 Bottom-up的DP
 	int n = triangle.length;
 	int[][] f = new int[n][n];

 	//from the bottom
 	for (int j = 0; j <= n - 1; j++) {
 		f[n - 1][j] = triangle[n - 1][j];
 	}

 	//dp: (i,j) - Math.min((i+1, j+1) , (i+1, j)) + (i, j)
 	for (int i = n - 2; i >= 0; i--) {
 		for (int j = 0; j <= i; j++) {
 			f[i][j] = Math.min(f[i+1][j], f[i+1][j+1]) + triangle[i][j];
 		}
 	}
 	return f[0][0];
 }