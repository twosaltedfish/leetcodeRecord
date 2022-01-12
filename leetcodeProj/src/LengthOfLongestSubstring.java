import java.util.HashSet;
import java.util.Set;

/**
 * @Description 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @Author Lce
 * @Create 2022-01-12
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcdb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        //左右指针
        int left = 0, right;
        //最大长度值
        int max = 0;
        //去重set
        HashSet set = new HashSet(s.length());
        //右指针不断向右移动
        for (right = 0; right < s.length(); right++) {
            //如果当前set有重复元素，去除左指针指向元素，左指针移动一位，重复该步骤，直到set无重复元素
            while (set.contains(s.charAt(right))) {
                //set去除当前left指向元素
                set.remove(s.charAt(left));
                //左指针移动一位
                left++;
            }
            //取最大值
            max = Math.max(max, right - left + 1);
            //添加元素到set
            set.add(s.charAt(right));
        }
        return max;
    }
}
