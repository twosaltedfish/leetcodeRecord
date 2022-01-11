import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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

    public static void main(String[] args) {
        Stack stack=new Stack();
        //1.empty()栈是否为空
        System.out.println(stack.empty());
        //2.peek()栈顶值    3.进栈push()
        stack.push(new Integer(1));
        stack.push("b");
        System.out.println(stack.toString());
        //4.pop()出栈
        stack.pop();
        System.out.println(stack.peek());
    }
}
