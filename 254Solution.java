// 254. Factor Combinations
//Assumption: n is always positive, 1<factors<n
class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        getFactorsHelper(result, path, n, 2);
        return result;
    }
    private void getFactorsHelper(List<List<Integer>> result, List<Integer> path, int n, int start) {
        //base case
        if (n <= 1) {
            //not contain self - n 
            if (path.size() > 1) {
                result.add(new ArrayList<>(path));
                return;
            }
        }
        // from 2 to n iterate to find factors
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                path.add(i);
                getFactorsHelper(result, path, n/i, i);
                // backtracking: add first then remove
                path.remove(path.size() - 1);
            }
        }
    }
}