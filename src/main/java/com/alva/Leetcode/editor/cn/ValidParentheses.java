package com.alva.Leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "()"
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 10⁴
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * <p>
 * Related Topics 栈 字符串 👍 4115 👎 0
 */

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        solution.isValid("(){}}{");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> dics = new HashMap<Character, Character>() {{
                put('(', ')');
                put('[', ']');
                put('{', '}');
            }};

            Stack<Character> stack = new Stack<>();

            if (s.length() > 0 && !dics.containsKey(s.charAt(0))) {
                return false;
            }
            for (Character c : s.toCharArray()) {
                // 左括号直接入栈
                if (dics.containsKey(c)) {
                    stack.push(c);
                } else if (stack.isEmpty() || dics.get(stack.pop()) != c) {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}