// 351. Android Unlock Patterns
class Solution {
    private boolean[] visited = new boolean[9];
    public int numberOfPatterns(int m, int n) {
        int result = 0;
        // 总共有m~n棵树
        for (int i = m; i <= n; i++) {
            result += calcPatterns(-1, i);
            for (int j = 0; j < 9; j++) {
                visited[j] = false;
            }
        }
        return result;
    }
    // 树的层数是len, 树的每层有9个分叉
    private int calcPatterns(int last, int len) {
        if (len == 0) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if (isValid(last,i)) {
                visited[i] = true;
                sum += calcPatterns(i, len - 1);
                visited[i] = false;
            }
        }
        return sum;
    }
    private boolean isValid(int last, int cur) {
        if (visited[cur] == true) {
            return false;
        }
        //first digit of the pattern
        if (last == -1) {
            return true;
        }
        // knight moves or adjacent cells
        if ((cur + last) % 2 == 1) {
            return true;
        }
        // indexes are both end of the diagonals like [0,0], [8,8] 
        int mid = (cur + last) / 2;
        if (mid == 4) {
            return visited[mid];
        }
        // adjacent cells on diagonal [0,0], [1,0]
        if ((cur % 3 != last % 3) && (cur / 3 != last / 3)) {
            return true;
        }
        //all other cells which are not adjacent
        return visited[mid];
    }
}