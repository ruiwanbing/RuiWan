// 349. Intersection of Two Arrays
public class Solution {
	// 1. two sets 求并集
	public int[] intersection1(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> intersect = new HashSet<>();
		for (int n : nums1) {
			set.add(n);
		}
		for (int m : nums2) {
			// 可以用 set.add(m), 但是要考虑nums2里元素重复多次	
			if (set.contains(m)) {
				intersect.add(m);
			}
		}
		int[] ans = new int[intersect.size()];
		int i = 0;
		for (int num : intersect) {
			ans[i++] = num;
		}
		return ans;
	} 
	//2. two pointers
    public int[] intersection2(int[] nums1, int[] nums2) {
    	  Set<Integer> set = new HashSet<>();
    	  // 先对两数组排序
    	  Arrays.sort(nums1);
    	  Arrays.sort(nums2);
    	  // 重复元素（nums1[i] == nums2[j]）加到set 移动俩个指针
    	  for (int i = 0; i < nums1.length; ) {
    	  		for (int j = 0; j < nums2.length; ) {
    	  			if (nums1[i] == nums2[j]) {
    	  				set.add(nums1[i]);
    	  				i++;
    	  				j++;
    	  			} else if (nums1[i] < nums2[j]) {
    	  				i++;
    	  			} else {
    	  				j++;
    	  			}
    	  		}
    	  }
    	  int[] ans = new int[set.size()];
    	  int i = 0;
    	  for (int num : set) {
    	  	ans[i++] = num;
    	  }
    	  return ans;
    }
}