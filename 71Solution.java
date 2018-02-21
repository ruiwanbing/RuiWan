// 71. Simplify Path
// /../
// //
// path = "/home/", => "/home"
// path = "/a/./b/../../c/", => "/c"
public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
	// split path by /
    String[] paths = path.split("/"); 
    // corner case: //
    if (paths.length < 1) {
    	return "/";
    }
	// put elements into stack
	for (int i = 0; i < paths.length; i++) {
	    // when . pass
		if (paths[i].equals(".") || paths[i].equals("")) {
			continue;
		// when .. pop
		} else if (paths[i].equals("..")) {
			if (!stack.isEmpty()) {
			    stack.pop();
			}
		} else {
			stack.push(paths[i]);
		}
	}
	// get all elements in reverse order
    String res = "";
    for (String dir : stack) {
    	res += "/" + dir;
    }
	return  res.equals("") ? "/" : res;
}