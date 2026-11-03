class Solution {
    Character getOpeningBracket(Character c) {
        if (c == ')') {
            return '(';
        }
        if (c == '}') {
            return '{';
        }
        if (c == ']') {
            return '[';
        }
        return null;
    }

    public boolean isValid(String s) {
        Stack<Character> bracketStack = new Stack<>();
        for (int i = 0; i < s.length(); i += 1) {
            Character c = s.charAt(i);
            if ((c == ')') || (c == '}') || (c == ']')) {
                Character cl = getOpeningBracket(c);
                if ((bracketStack.isEmpty()) || (cl != bracketStack.peek())) {
                    return false;
                }
                bracketStack.pop();
            } else {
                bracketStack.push(c);
            }
        }
        return bracketStack.isEmpty();
    }
}
