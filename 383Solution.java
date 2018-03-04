 // 383. Ransom Note
 // 类似first unique character in a string
 public boolean canConstruct(String ransomNote, String magazine) {
       // index -- 'a', value -- frequency
 	   if (magazine.length() == 0 && ransomNote.length() != 0) {
 	   	 return false;
 	   }
 	   int[] chars = new int[26];
 	   for (int i = 0; i < magazine.length(); i++) {
 	   		chars[magazine.charAt(i) - 'a']++;
 	   }
 	   for (int i = 0; i < ransomNote.length(); i++) {
 	   	    int curt = ransomNote.charAt(i) - 'a';
 	   	    chars[curt]--;
 	   	    if (chars[curt] < 0) {
 	   	    	return false;
 	   	    }
 	   }
 	   return true;
 }