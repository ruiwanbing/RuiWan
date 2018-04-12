// Assumption:  unsorted array arr[] ,  both x and y are different and present in arr[].
// time O(n)
public int minDist(int arr[], int n, int x, int y) {
	int min = Integer.MAX_VALUE;
	for (int i = 0; i < arr.length; i++) {
		for (int j = i + 1; j < arr.length; j++) {
			if (arr[i] == x && arr[j] == y && Math.abs(i, j) < min) {
				min = Math.abs(i, j);
			}
		}
	}
	return min;
}