//447. Search in a Big Sorted Array
// Given a big sorted array with positive integers sorted by ascending order. 
// The array is so big so that you can not get the length of the whole array directly, 
// and you can only access the kth number by ArrayReader.get(k) (or ArrayReader->get(k) for C++). 
// Find the first index of a target number. Your algorithm should be in O(log k), where k is the first index of the target number.
// Return -1, if the number doesn't exist in the array.

    public int searchBigSortedArray(ArrayReader reader, int target) {
    	// jump out by size *2
    	int size = 1;
    	if (reader.get(size - 1) < target) {
    		size = size * 2;
    	}
    	// binary search to find the target
    	int left = 0; 
    	int right = size - 1;
    	while (left + 1 < right) {
    		int mid = left + (right - left)/2;
    		if (reader.get(mid) < target) {
    			left = mid;
    		} else {
    			right = mid;
    		}
    	}

    	if (reader.get(left) == target) {
    		return left;
    	} else if (reader.get(right) == target) {
    		return right;
    	}

    	return -1;
    }