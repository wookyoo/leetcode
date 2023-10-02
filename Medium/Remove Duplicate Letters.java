package Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class Letters {

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

// Took quite time to understand second example thus, I put my understanding of how intput needs to be managed under the loop
//
// example 2 sequence, [c b a c d c b c]
// rule - last peek or peek < current index charcter then no pop, no push
//
// 0 char 'c' - current stack empty,  stack is empty so just push 'c' to stack
// 1 char 'b' - current stack 'c',    stack peek 'c', not last 'c', and c > b so       pop 'c' and push 'b' to stack
// 2 char 'a' - current stack 'b',    stack peek 'b', not last 'b', and b > a so       pop 'b' and push 'a' to stack
// 3 char 'c' - current stack 'a',    stack peek 'a',     last 'a', and a < c so don't pop 'a' and push 'c' to stack
// 4 char 'd' - current stack 'ac',   stack peek 'c', not last 'c', and c < d so don't pop 'c' and push 'd' to stack
// 5 char 'c' - current stack 'acd',  stack peek 'd',     last 'd', and d > c so don't pop 'd'
// 6 char 'b' - current stack 'acd',  stack peek 'c', not last 'c', and c > b so       pop 'c' and push 'b' to stack
// 7 char 'c' - current stack 'acdb', stack peek 'b',     last 'b', and b < c so don't pop 'b' and push 'c' to stack
// no more char - current stack 'acdb'