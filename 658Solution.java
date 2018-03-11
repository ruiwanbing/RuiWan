// 658. Find K Closest Elements
//Assumption: 
//1. sorted array, 2. choose smaller one when tie, 3. k in right range
//4. The result should also be sorted in ascending order.
public List<Integer> findClosestElements(int[] arr, int k, int x) {
	List<Integer> list = new ArrayList<>();
	if (arr == null || arr.length == 0) {
		return list;
	}

	// binary search to find the bounds
	int left = 0;
	int right = arr.length - 1;
	while (left + 1 < right) {
		int mid = left + (right - left)/2;
		if (arr[mid] < x) {
			left = mid;
		} else {
			right = mid;
		}
	}
	
	//post process
	while (k > 0) {
		// move left if closer 
		if (left >= 0 && right <= arr.length - 1 && Math.abs(x - arr[left]) <= Math.abs(arr[right] - x)) {
			list.add(arr[left]);
			left--;
		// otherwise move right || left out of range
		} else if (right < arr.length){
			list.add(arr[right]);
			right++;
		// right out of range
		} else if (left >= 0) {
			list.add(arr[left]);
			left--;
		}
		k--;
    }
	Collections.sort(list);
	return list;
}
// version2
public List<Integer> findClosestElements(int[] arr, int k, int x) {
	//built-in to find bounds
	//return: index of the search key, if it is contained in the array; otherwise, (-(insertion point) - 1).
	int index = Arrays.binarySearch(arr, x);
	if (index < 0) {
		index = -(index + 1);
	}
	List<Integer> list = new ArrayList<>();
	int i = index - 1;
	int j = index;
	while (k > 0) {
		if (i < 0 || (j < arr.length && (x - arr[i] > arr[j] - x) ) {
			list.add(arr[j]);
			j++;
		} else {
			list.add(arr[i]);
			i--;
		}
		k--;
	}
	Collections.sort(list);
	return list;
}
