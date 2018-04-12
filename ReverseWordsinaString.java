//186. Reverse Words in a String II
public void reverseWords(char[] s) { 
	//reverse the string
	reverse(s, 0, s.length);
	//reverse each word
	int start = 0;
	for (int i = 0; i < s.length; i++) {
		if (s[i] == " ") {
			reverse(s, start, i - 1);
			start = i + 1;
		}
	}
	//reverse the last word
	reverse(s, start, s.length - 1);
}
public void reverse (char[] s, int start, int end) {
	while (start < end) {
		char tmp = s[start];
		s[start] = s[end];
		s[end] = tmp;
		start++;
		end--;
	}
}