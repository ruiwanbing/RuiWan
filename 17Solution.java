//17. Letter Combinations of a Phone Number 
class Solution {
// Assumption: only digits input
private static String[] keys = {"","", "abc", "def","ghi","jkl", "mno", "pqrs", "tuv", "wxyz"} ;
public List<String> letterCombinations(String digits) {
	List<String>result = new ArrayList<>();
	if (digits == null || digits.length() == 0) {
		return result;
	}
	helper(result, "", 0, digits);
	return result;
  }
  private void helper(List<String>result, String combo, int startIdx, String digits) {
  	//base case:
  	if (combo.length() == digits.length()) {
  		result.add(combo);
  		return;
  	}

  	String letters = keys[(digits.charAt(startIdx)-'0')];
  	for (int i = 0; i < letters.length(); i++) {
  		combo += letters.charAt(i);
  		//!!! startIdx + 1
  		helper(result, combo, startIdx + 1, digits);
  		// remove the last digit
  		combo = combo.substring(0, combo.length() - 1);
  	}
  }
}