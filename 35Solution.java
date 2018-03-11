 // 35. Search Insert Position
 class Solution {
    //Given a sorted array, no duplicates
    //BUT the inserted element may be in the array
     public int searchInsert(int[] nums, int target) {
     	//[1] insert 1 -> 0
         if (nums.length == 1) {
             if (target <= nums[0]) {
                 return 0;
             } else {
                 return 1;
             }
         }
           //binary search
           int left = 0;
           int right = nums.length - 1;
           while (left + 1 < right) {
            int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid;
                } else {
                    right = mid;
                }
           }
           //post process
           //[1,3] insert 1 -> 0
           //[1,3] insert 3 -> 1
           if (target > nums[left] && target <= nums[right]) {
                return left + 1;
           } else if (target <= nums[left]) {
                if (left <= 1) {
                    return 0;
                } else {
                    return left - 1;
                }
          //if (target >= nums[right])
           } else {
                return right + 1;
           }
     }
}