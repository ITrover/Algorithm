package bytedance.validIPAddress;

/**
 * 468. 验证IP地址 https://leetcode-cn.com/problems/validate-ip-address/solution/
 * 分情况，校验所有可能
 * 正则表达式
 * @author itrover
 */
class Solution {

    static String IPv4 = "IPv4";
    static String IPv6 = "IPv6";
    static String NEITHER = "Neither";

    public String validIPAddress(String IP) {
        // 如果有'.'那么检查ipv4
        if (IP.contains(".")) {
            return validIPV4(IP);
        }
        // 如果有':'则检查ipv6
        if (IP.contains(":")) {
            return validIPV6(IP);
        }
        return NEITHER;
    }

    private String validIPV6(String ip) {
        if (ip.startsWith(":") || ip.endsWith(":")){
            return NEITHER;
        }
        String[] items = ip.split(":");
        if ((items.length != 8)) {
            return NEITHER;
        }
        for (String item : items) {
            if (item.length() == 0 || item.length() > 4) {
                return NEITHER;
            }
            for (int i = 0; i < item.length(); i++) {
                // 只能是0-9 || a - f
                char c = item.charAt(i);
                if (check(c)) {
                    continue;
                }
                return NEITHER;
            }
        }
        return IPv6;
    }

    private boolean check(char c) {
        return (c >= '0' && c <= '9') ||
                (c <= 'f' && c >= 'a') || (c <= 'F' && c >= 'A');
    }

    /**
     * 验证IPV4
     *
     * @param ip
     * @return
     */
    private String validIPV4(String ip) {
        if (ip.startsWith(".") || ip.endsWith(".")){
            return NEITHER;
        }
        String[] items = ip.split("\\.");
        if (items.length != 4) {
            return NEITHER;
        }
        for (String item : items) {
            // 空的，或者有多个字符，但是不能以0开头
            if (item.length() == 0 || (item.length() > 1 && item.startsWith("0"))) {
                return NEITHER;
            }
            try {
                int number = Integer.parseInt(item);
                if (number > 255 || number < 0) {
                    return NEITHER;
                }
            } catch (NumberFormatException e) {
                return NEITHER;
            }
        }
        return IPv4;
    }
}
