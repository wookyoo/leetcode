package Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        // example 1
        // String s = "bcabc";

        // example 2
        String s = "cbacdcbc";

        String result = removeDuplicateLetters(s);
        System.out.println(result);

    }
    
    public static String removeDuplicateLetters(String s) {
        Map<Character, Integer> lastIndexMap = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            lastIndexMap.put(s.charAt(i), i);
        }
        
        Set<Character> set = new HashSet<Character>();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                continue;
            }
            while(!stack.empty() && stack.peek() > c) {
                // System.out.println(i + " > " +  + lastIndexMap.get(stack.peek()) + " " + stack.peek() + " > " + c + " :" + (stack.peek() > c));
                if(lastIndexMap.get(stack.peek()) > i) {
                    char popChar = stack.pop();
                    set.remove(popChar);
                } else {
                    break;
                }
            }
            set.add(c);
            stack.push(c);
        }

        // Runtime 5ms, Beats 15.90% of users with Java
        // Memory 41.44MB, Beats 28.89% of users with Java
        // String result = "";
        // for(Character c: stack) {
        //     // System.out.println(c);
        //     result += c;
        // }

        // Runtime 4ms, Beats 30.17% of users with Java
        // Memory 41.60MB, Beats 17.88% of users with Java
        StringBuffer sb = new StringBuffer();
        while(!stack.empty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        return sb.toString();
    }
}

// This problem answer is same as 316. Remove Duplicate Letters (Medium)