// 127. Word Ladder
 public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      Set<String> beginSet = new HashSet<>();
      Set<String> endSet = new HashSet<>();
      int count = 1;
      Set<String> used = new HashSet<>();
      beginSet.add(beginWord);
      endSet.add(endWord);

      Set<String> wordSet = new HashSet<>();
      for(String s : wordList) {
      		wordSet.add(s);
      }

      while (!beginSet.isEmpty() && !endSet.isEmpty()) {
      	// always start from the smaller set
      	if (beginSet.size() > endSet.size()) {
      		Set<String> set = beginSet;
      		beginSet = endSet;
      		endSet = set;
      	}
      	Set<String> temp = new HashSet<>();
      	for (String word: beginSet) {
      		char[] chs = word.toCharArray();
      		for (int i = 0; i < chs.length; i++) {
      			// construct the target word
	      		for (char c = 'a'; c <= 'z'; c++) {
	      			char old = chs[i];
	      			chs[i] = c;
	      			String target = String.valueOf(chs);
	      			// find corresponding word
	      			if (endSet.contains(target)) {
	      				return count + 1;
	      			}
	      			// no, add it to next level
	      			if (!used.contains(target) && wordSet.contains(target)) {
	      				temp.add(target);
	      				used.add(target);
	      			}
		      		//rollback
		      		chs[i] = old;
	      		}
      		}
      	}
      	beginSet = temp;
      	count++;
      }
      return 0;
 }