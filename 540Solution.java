// 540. Single Element in a Sorted Array
// Assumption: a sorted array, single element that appears only once, 
//             solution should run in O(log n) time and O(1) space.
public int singleNonDuplicate(int[] nums) {
   int start = 0;
   int end = nums.length - 1;
   while (start < end) {
   	  int mid = start + (end - start) / 2;
   	  if (mid % 2 == 1) {
   	  	mid = mid - 1;
   	  }
   	  // 0 1 1 3 3 4 4
   	  // in the left side
   	  if (nums[mid] != nums[mid + 1]) {
   	  	end = mid;
   	  }
   	  // 1 1 3 3 4 
   	  // in the right side
   	  if (nums[mid] == nums[mid + 1]) {
   	  	start = mid + 2;
   	  }
   }
   return nums[start];
}