import java.util.HashSet;
import java.util.Set;

/**
 * @Description 存在重复元素:https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
 * @Author Lce
 * @Create 2021-12-02
 */
public class ContainsDuplicate {

    /**
     * java-hashset去重
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i]) == false) {
                return true;
            }
        }
        return false;
    }
}
