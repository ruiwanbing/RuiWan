 // String permutation
 public List<String> stringPermutation2(String str) {
   //input
   char[] chars = str.toCharArray();
   Arrays.sort(chars);
   // partial result
   String part = "";
   List<String> result = new ArrayList<>();
   // avoid duplicate result
   int[] visited = new int[chars.length];
   // recursive func
   helper(chars, part, result, visited);
   return result;
 }
 private void helper(char[] chars, String part , List<String> result, int[] visited) {
 	// base case: reach the end of input chars
 	if (part.length() == chars.length) {
 		result.add(part);
 		return;
 	}
 	// exec
 	for (int i = 0; i < chars.length; i++) {
 		// if the element is visited or it has the same value as previous
 		// skip
 		if (visited[i] == 1 || i != 0 && chars[i] == chars[i - 1] && visited[i - 1] == 0) {
 			continue;
 		}
 		// mark as visited and add the char to partial result
 		visited[i] = 1;
 		part += chars[i];
 		helper(chars, part, result, visited);
 		// go back the upper level
 	    part = part.substring(0, part.length() - 1);
 	    visited[i] = 0;
 	}

 }