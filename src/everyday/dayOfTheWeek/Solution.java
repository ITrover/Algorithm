package everyday.dayOfTheWeek;

/**
 * @author itrover
 * 1185. 一周中的第几天 https://leetcode-cn.com/problems/day-of-the-week/
 */
class Solution {
    private static final String[] WEEK = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public String dayOfTheWeek(int day, int month, int year) {
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        /* 输入年份之前的年份的天数贡献 */
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        /* 输入年份中，输入月份之前的月份的天数贡献 */
        for (int i = 0; i < month - 1; ++i) {
            days += monthDays[i];
        }
        // 当前年是闰年且月份大于2
        // 是否为闰年：四年一润，百年不润，四百年再润
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days += 1;
        }
        /* 输入月份中的天数贡献 */
        days += day;
        return WEEK[(days + 3) % 7];
    }
}
