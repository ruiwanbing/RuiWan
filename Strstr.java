public class Strstr {
	// implement String.indexof
	public int strstr(String s1, String s2) {
		// corner case: "" ""; "a" "";
		// find the same character first 
		// keep comparing
		for (int first = 0; ; first++) {
			for (int len = 0; ; len++) {
				// len goes to the end of str2 
				if (len == s2.length()) {
					return first;
				}
				// first + len goes beyond str1 
				// and cannot find the same char sequence
				if (first + len == s1.length()) {
					return -1;
				}
				// go to next first
				if (s1.charAt(first + len) != s2.charAt(len)) {
					break;
				}
				
			}
		}	
	}
}