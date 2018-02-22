// 387. First Unique Character in a String
 public int firstUniqChar(String s) {
 	if (s == null || s.length() == 0) {
 		return -1;
 	}
 	int[] freq = new int[26];
 	// 数组a -- index对应字母, 数值对应frequency
 	for (int i = 0; i < s.length(); i++) {
 		freq[s.charAt(i) - 'a']++;
 	}
 	// 遍历string得到第一个 freq=1 的 character
 	for (int i = 0; i < s.length(); i++) {
 		if(freq[s.charAt(i) - 'a'] == 1) {
 			return i;
 		}
 	}
 	return -1;        
 }