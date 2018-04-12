// 227. Basic Calculator II
class Solution {
    //Assumption:only non-negative integers, +, -, *, / and empty spaces
    //integer division should truncate toward zero
    //3+12*2 = 27
    //0+3+12*2 ---  
    //'+' -- push; '*' -- push(pop * num); '-'---push(-num); '/' -- push(pop/num)
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int len;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }
        //num - contacted num
        int num = 0;
        //sign - prev sign
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                // contact num
                // don't add -- (int) s.charAt(i)
                num = num * 10 + s.charAt(i) - '0';
            } 
            // exclude digits & empty space
            // last digit
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' '|| i == len - 1) {
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        // add results from each step
        int res  = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}