// 150. Evaluate Reverse Polish Notation
// Assumption: valid reverse polish notation
// 1 + 12 * 8 --- 1 12 8 + *
     public int evalRPN(String[] tokens) { 
            int a, b;
            Stack<Integer> stack = new Stack<>();
            for (String s : tokens) {
                if (s.equals("+")) {
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a + b);
                } else if (s.equals("-")) {
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                } else if (s.equals("*")) {
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                } else if (s.equals("/")) {
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                } else {
                    stack.push((Integer.parseInt(s)));
                }
            }
            return stack.pop();
         }