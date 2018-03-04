// 186. Reverse Words in a String II
 public void reverseWords(char[] str) {
     // reverse String
 	 int n = str.length;
 	 reverse(str, 0, n - 1);
 	 // reverse each word
 	 reverseWord(str, n);
 }

private void reverse(char[] str, int i, int j) {
	while (i < j) {
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
		i++;
		j--;
	}
}
private void reverseWord(char[] str, int n) {
	int i = 0, j = 0;
	while (i < n ) {
		// i 在j前 或者 i位置是space
		if (i < j || i < n && str[i] == ' ') {
			i++;
		}
		// j 在i前 或者 j位置不是space
		if (j < i || j < n && str[j] != ' ') {
			j++;
		}
		
		reverse(str, i , j - 1);
	}
}