import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        for (String token : tokens) {
            char c = token.charAt(token.length() - 1);
            if (Character.isDigit(c))
                numStack.add(Integer.parseInt(token));
            else {
                int x2 = numStack.pop();
                int x1 = numStack.pop();
                numStack.add(applyOperation(x1, x2, c));
            }
        }

        return numStack.peek();
    }

    public int applyOperation(int x1, int x2, char opToken) {
        if (opToken == '+')
            return x1 + x2;
        else if (opToken == '-')
            return x1 - x2;
        else if (opToken == '*')
            return x1 * x2;
        return x1 / x2;
    }
}
