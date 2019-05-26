package cn.happyhbase.geekbang.algorithm.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * @author luke
 * @date 2019/5/26
 */
public class LeetCode20 {

    /**
     * "([{}])"
     "[({})]"
     "("
     ")"
     * @param args
     */
    public static void main(String[] args) {
        LeetCode20 leetCode20 = new LeetCode20();
        System.out.println(leetCode20.isValid("([{}])"));
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            Character ci = s.charAt(i);
            if (stack.empty()) {
                stack.push(ci);
            } else {
                Character firstElement = stack.peek();
                if (isPair(firstElement, ci)) {
                    stack.pop();
                } else {
                    stack.push(ci);
                }
            }
        }
        return stack.empty();
    }

    private boolean isPair(char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        }
        if (left == '{' && right == '}') {
            return true;
        }
        if (left == '[' && right == ']') {
            return true;
        }
        return false;
    }

}
