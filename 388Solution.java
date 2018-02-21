// 388. Longest Absolute File Path
// "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
// dir \tsubdir1 \t\tfile1.ext t\tsubsubdir1 \tsubdir2 \t\tsubsubdir2 \t\t\tfile2.ext
// dir/subdir2/subsubdir2/file2.ext -- 32
 public int lengthLongestPath(String input) {
 	// use stack to store length
 	Stack<Integer> stack = new Stack<>();
    // split by \n  using \t to indicate levels
    String[] paths = input.split("\n");
    stack.push(0);
    // while (level + 1 < stack.size()) pop
    int maxLen = 0;
    for (String path : paths) {
    	int level = path.lastIndexOf("\t") + 1;
    	// don't count \t
        // calc len = stack.peek + s.len - level + 1
    	while (level + 1 < stack.size()) {
    		stack.pop();
    	}
    	int len = stack.peek() + path.length() - level + 1;
    	stack.push(len);
    	// reach end with "." break
    	// get the global max
    	if (path.contains(".")) {
    			maxLen = Math.max(maxLen, len - 1);
    	}
    }
    return maxLen;
 }