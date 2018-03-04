 public String reverseVowels(String s) {
        if(s == null || s.length()==0) return s;
        // leetcode
        String vowels = "aeiouAEIOU";
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        //for (int i = start + 1; i < s.length(); i++) {
        while (start < end) {
            //l - e
            while (start < end &&!vowels.contains(s.charAt(start)+"")) {
                start++;
            }
            // e / d-o
            while (start < end && !vowels.contains(s.charAt(end)+"")) {
                end--;
            }
            // leotcede
            char temp = s.charAt(start);
            chars[start] = s.charAt(end);
            chars[end] = temp;
            
            start++;
            end--;
        }
        //
        return new String(chars);
    }