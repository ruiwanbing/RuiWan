//136. Single Number
// version1 extra space
//Assumption: only one number has frequency as 1; time O(n)
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        //number:frequency pair
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        //not found
        return Integer.MIN_VALUE;
    }
// version2 no extra space
// XOR A^A^B = B
public int singleNumber(int[] nums) {
    int result = 0;
    for (int n : nums) {
        result ^= n;
    }
    return result;
}