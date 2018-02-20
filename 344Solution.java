// 344. Reverse String
public class 344Solution {
	// 1. brutal way
	public String reverseString1(String s) { 
		StringBuilder result = new StringBuilder("");
		for (int i = s.length() - 1; i >= 0; i--) {
			result.append(s.charAt(i));
		} 
		return result.toString();
	}
	//2. two pointers
	public String reverseString2(String s) {
        char[] array = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            // 头尾交换
            swap(array, i, j);
        }
        StringBuilder result = new StringBuilder("");

        for (char c : array) {
            result.append(c);
        }
        return result.toString();
    }
    private void swap (char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    // 异或运算
    // a=ａ∧ｂ∧ｂ∧ａ∧ｂ，即a的值等于ａ∧ａ∧ｂ∧ｂ∧ｂ，等于ｂ
    public String reverseString3(String s) {
    	char[] a = s.toCharArray();
    	int i = 0;
    	int j = a.length - 1;
    	while (i < j) {
    		a[i] = (char) (a[i] ^ a[j]);
    		a[j] = (char) (a[i] ^ a[j]);
    		a[i] = (char) (a[i] ^ a[j]);
    		i++;
    		j--;
    	}
    	return new String(a);
    }
}