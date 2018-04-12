// 320. Generalized Abbreviation
// subset
public List<String> generateAbbreviations(String word) {
	List<String> result = new ArrayList<>();
	helper(result, "", 0, 0, word);   
	return result;     
}
private void helper(List<String> result, String cur, int level, int count, String word) {
	if (level == word.length()) {
		if (count > 0) {
			cur += count;
		}
		result.add(cur);
	} else {
	helper(result, cur, level + 1, count + 1, word);
	helper(result, cur + (count != 0 ? count : "") + word.charAt(i), level + 1, 0, word);
	}
}