// 14. Longest Common Prefix
public String longestCommonPrefix(String[] strs) {
	if (strs == null || strs.length == 0) {
		return "";
	}
	// 先从一个String找起
	String pre = strs[0];
	int i = 1;
	
	while (i < strs.length) {
		// 如果不是从开头开始，不断减小这个String的size
		while (strs[i].indexOf(pre) != 0) {
			pre = pre.substring(0, pre.length() - 1);
		}
	// 这个String 找不到common， 换下一个String
		i++;
	}

    return pre;
}