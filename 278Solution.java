// 278. First Bad Version
public class Solution extends VersionControl {
	// binary search: time O(logn) space O(1)?
     public int firstBadVersion(int n) {
     	// start from 1
    	int left = 1;
    	int right = n;
    	while (left + 1 < right) {
    	int mid = left + (right - left) / 2;
    		if (isBadVersion(mid)) {
    			//maybe the first bad version, cannot use right = mid - 1
    			right = mid;
    		} else {
    			left = mid;
    		}
    	}
    	// postprocess
    	if (isBadVersion(left)) {
    	 	return left;
    	} else if (isBadVersion(right)) {
    		return right;
    	}
    	return -1;
    }
}