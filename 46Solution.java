// 46. Permutations
//Assumption: given distinct numbers, return all possible permutations
//[1,2,3] -- [ [1,2,3],[1,3,2], [2,1,3], [2,3,1], [3,1,2],[3,2,1]]

public List<List<Integer>> permute(int[] nums) {
	List<List<Integer>> result = new ArrayList<>();
	list<Integer> path = new ArrayList<>();
	int[] visited = new int[nums.length];
	helper(result, path, visited, nums);
	return result;
}
private void helper(List<List<Integer>> result, list<Integer> path, int[] visited, int[] nums) {
	//base case
	if (path.size() == nums.length) {
		result.add(new ArrayList<>(path));
		return;
	}
	for (int i = 0; i < nums.length; i++) {
		if (visited[i] == 1) {
			continue;
		}
		visited[i] = 1;
		path.add(nums[i]);
		helper(result, path, visited, nums);
		path.remove(path.size() - 1);
		visited[i] = 0;
	}

}