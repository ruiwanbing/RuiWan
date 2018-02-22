// 58. Length of Last Word
public int lengthOfLastWord(String s) {
     if (s == null || s.length() == 0) {
     	return 0;
     }
     //split to words
	 String[] words = s.split("\\s+");
	 if (words == null || words.length < 1) {
	 	return 0;
	 }
	 // find the last one and count
	 String last = words[words.length - 1];
	 return last.length();
}