// 191. Number of 1 Bits
 public int hammingWeight(int n) {
 	int ones = 0;
 	while (n != 0) {
 		// 利用(n&1)判断是否是1
 		ones += (n & 1);
 		// 右移一位
 		n = n >>> 1;
 	}
 	return ones;
 }