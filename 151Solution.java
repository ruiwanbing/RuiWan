// 151. Reverse Words in a String
// This question has no clear rules to handle space. Bad!
public String reverseWords(String s) {
	if (s.length() == 0 || s.equals("\\s+")) {
		return "";
	}
    Stack<Character> st1 = new Stack<>();
    Stack<Character> st2 = new Stack<>();
    char[] chars = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
    	if (chars[i] != ' ') {
    		st1.push(chars[i]);
    	} else {
    		while (!st1.isEmpty()) {
    			st2.push(st1.pop());
    		}
    		st2.push(' ');
    	}
    }
    
	while (!st1.isEmpty()) {
		st2.push(st1.pop());
	}
    
    String reverse = "";
    while (!st2.isEmpty()) {
    	reverse += st2.pop();
    }
    return reverse;
}