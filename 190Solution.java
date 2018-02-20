// 190. Reverse Bits
public int reverseBits(int n) {
	// n 32bits
	int result = 0;
	for (int i = 0; i < 32; i++) {
		// 0/1
		result += n & 1;
		// n = n/2 右移一位
		n >>>= 1;
		if (i < 31) {
			// 非最后一位 左移一位
			result <<= 1;
		}
	}
	return result;
}