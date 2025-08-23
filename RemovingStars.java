import java.util.*;

public class RemovingStars {
    public String removeStars(String s) {
        Deque<String> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            String c = Character.toString(s.charAt(i));
            if(c.equals("*")) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.append(stack.removeLast());
        }
        return result.toString();
    }
}
