// 75. Sort Colors
public void sortColors(int[] nums) {
        // 1-pass
        int i = 0;
        int j = nums.length - 1;
        int index = 0;
        while (index <= j && i <= j) {
            if (nums[index] == 0) {
                swap(nums, index, i);
                index++;
                i++;
            } else if (nums[index] == 2) {
                swap(nums, index, j);
                j--;
            } else {
                index++;
            }
        }
}
private void swap(int[] nums, int f, int s) {
    int temp = nums[f];
    nums[f] = nums[s];
    nums[s] = temp;
}