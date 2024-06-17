import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty()) return true;

        if (!s.contains("()") && !s.contains("{}") && !s.contains("[]")) return false;

        Stack<Character> parStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') parStack.add(c);
            else {
                if (parStack.isEmpty()) return false;

                char opC = parStack.pop();
                if (opC == '(' && c != ')') return false;
                if (opC == '{' && c != '}') return false;
                if (opC == '[' && c != ']') return false;
            }
        }
        return parStack.isEmpty();
    }
}
