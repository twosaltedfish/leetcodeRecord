package question;

/**
 * @Description 给你一个字符串 s，找到 s 中最长的回文子串。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Lce
 * @Create 2022-01-14
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(test(s));
    }

    /**
     * 暴力解法
     */
    public static String longestPalindrome1(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String subString = s.substring(i, j);
                if (isPalindrome(subString) && subString.length() > result.length()) {
                    result = subString;
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String subString) {
        int len = subString.length();
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            if (subString.charAt(low++) != subString.charAt(high--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 动态规划
     * 思路：利用dpTable，设i为字符串头索引，j为尾索引，dp[i][j]表示这个字符串是否是回文串，用true/false表示
     * 一个回文串头尾去掉，如果还有字符剩余，则一定为回文串，则状态转移方程为dp[i][j]=dp[i+1][j-1]，
     * 首先可以确定的是
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int length = 2; length <= len; length++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = length + i - 1;

                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }
                //头尾字符不相等，就一定不是回文串
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    //长度<=3，代表中间夹着一个或者两个相同的，为回文串
                    if (length <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && length > maxLen) {
                    maxLen = length;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static String test(String s) {
        int len = s.length();
        //边界值，直接返回
        if (len < 2) {
            return s;
        }
        int maxLength = 0;
        String maxString = s.substring(0, 1);
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i < len; i++) {
                int j = l + i - 1;
                if (j >= len) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    //头尾相同，长度小于等于3，代表中间有一个数或者两个相同数
                    if (l <= 3) {
                        dp[i][j] = true;
                    } else {
                        //头尾相同，如果里面为回文字符串则外面也为字符串
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j] && l > maxLength) {
                        maxLength = l;
                        maxString = s.substring(i, j + 1);
                    }
                }
            }
        }
        return maxString;
    }
}
