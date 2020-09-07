package swordToOffer.isNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * @author itrover
 * @date 2020/9/3
 * @description 剑指 Offer 20. 表示数值的字符串
 * 数字的格式
 * [[sign][integral-digits]][.[fractional-digits]][e|E[sign]exponential-digits]
 *
 * 状态转换，把所有情况考虑完
 * 使用有限状态机
 */
class Solution {
    enum State {
        // 1.开始状态
        START,
        // 2.开始符号
        SIGN_FIRST,
        // 3.小数点前面的数字
        NUMBER_BEFORE_DOT,
        // 4.整数后小数点
        DOT,
        // 5.前面无整数的小数点
        DOT_WITHOUT_NUMBER,
        // 6.小数点后数字
        NUMBER_AFTER_DOT,
        // 7.e
        E,
        // 8.e后面的符号
        SIGN_AFTER_E,
        // 9.最后的符号
        NUMBER_END
    }

    enum CharType {
        // 符号
        SIGN,
        // 数字
        NUMBER,
        // 小数点
        DOT,
        // e
        E,
        // 非法字符
        ILLEGAL
    }

    CharType toCharType(char c) {
        if (c >= '0' && c <= '9') {
            return CharType.NUMBER;
        }
        if (c == '+' || c == '-') {
            return CharType.SIGN;
        }
        if (c == '.') {
            return CharType.DOT;
        }
        if (c == 'e' || c == 'E') {
            return CharType.E;
        }
        return CharType.ILLEGAL;
    }

    public boolean isNumber(String s) {
        // 状态转移表
        Map[] transfer = {
                // 1.起始状态对应的下一状态
                new HashMap<CharType, State>() {{
                    put(CharType.SIGN, State.SIGN_FIRST);
                    put(CharType.NUMBER, State.NUMBER_BEFORE_DOT);
                    put(CharType.DOT, State.DOT_WITHOUT_NUMBER);
                }},
                // 2.起始符号对应的状态
                new HashMap<CharType, State>() {{
                    put(CharType.NUMBER, State.NUMBER_BEFORE_DOT);
                    put(CharType.DOT, State.DOT_WITHOUT_NUMBER);
                }},
                // 3.小数点前面数字对应的状态
                new HashMap<CharType, State>() {{
                    put(CharType.NUMBER, State.NUMBER_BEFORE_DOT);
                    put(CharType.DOT, State.DOT);
                    put(CharType.E, State.E);
                }},
                // 4.整数后dot对应的状态
                new HashMap<CharType, State>() {{
                    put(CharType.NUMBER, State.NUMBER_AFTER_DOT);
                    put(CharType.E, State.E);
                }},
                // 5.DOT_WITHOUT_NUMBER
                new HashMap<CharType, State>() {{
                    put(CharType.NUMBER, State.NUMBER_AFTER_DOT);
                }},
                // 6.小数点后数字
                new HashMap<CharType, State>() {{
                    put(CharType.NUMBER, State.NUMBER_AFTER_DOT);
                    put(CharType.E, State.E);
                }},
                // 7.e对应的状态
                new HashMap<CharType, State>() {{
                    put(CharType.SIGN, State.SIGN_AFTER_E);
                    put(CharType.NUMBER, State.NUMBER_END);
                }},
                // 8.e后面符号对应的状态
                new HashMap<CharType, State>() {{
                    put(CharType.NUMBER, State.NUMBER_END);
                }},
                // 9.最后面number对应的状态
                new HashMap<CharType, State>() {{
                    put(CharType.NUMBER, State.NUMBER_END);
                }}
        };
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        State state = State.START;
        for (int i = 0; i < s.length(); i++) {
            CharType charType = toCharType(s.charAt(i));
            if (!transfer[state.ordinal()].containsKey(charType)) {
                return false;
            }
            state = (State) transfer[state.ordinal()].get(charType);
        }
        // 只有四种情况末尾是合法的
        // 开始状态
        // 数字后的小数点
        // 前面的数字
        // 后面的数字
        return state == State.START ||
                state == State.DOT ||
                state == State.NUMBER_BEFORE_DOT ||
                state == State.NUMBER_AFTER_DOT ||
                state == State.NUMBER_END;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isNumber(""));
    }
}
