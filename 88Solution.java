//version1: space O(m + n) time o(n)
public void merge(int[] nums1, int m, int[] nums2, int n) {
        // merge two sorted array to one array
        //init an array size m+n
        int[] newArray = new int[m + n];
        // compare put smaller into new array
        int count = 0;
        int i = 0;
        int j = 0;
        while(i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                newArray[count++] = nums1[i++];    
            } else{
                newArray[count++] = nums2[j++];
            }
        }
        while (i < m) {
            newArray[count++] = nums1[i++];
        }
        while (j < n) { 
            newArray[count++] = nums2[j++];
        }
        // copy to original one
        for (int k = 0; k < newArray.length; k++) {
            nums1[k] = newArray[k];
        }
        
    }
// version2: space O(m) time O(n)
// The difference is that Arrays.copyOf does not only copy elements, it also creates a new array. System.arrayCopy copies into an existing array.
// If we read the source code of Arrays.copyOf(), we can see that it uses System.arraycopy().
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = 0; 
    int j = 0;
    while (i < m && j < n) {
        if (nums1[i] > nums2[j]) {
            System.arrayCopy(nums1, i , nums1, i + 1, nums1.length - i);
            nums1[i] = nums2[j];
            j++;
        } else {
            i++;
        }
    }
    while (j < n) {
        System.arrayCopy(nums2, j, nums1, i, nums2.length - j);
    }
}