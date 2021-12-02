/**
 * @Description 只出现一次的数字：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
 * @Author Lce
 * @Create 2021-12-02
 */
public class SingleNumber {
    /*
    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     */
    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        /*
            利用数组异或原理(二进制)
            1^1=0   例子：4=二进制写法为100那么 4^4=100^100=000=0
            0^0=0
            1^0=1   例子：5=二进制写法为101那么 5^4^5=101^100^101=001^101=100=4
            a^a=0
            a^b^c=a^c^b（具有交换律）
            即若a=c，则a^b^c=a^c^b=b^a^c=b
            题目某个元素只出现一次以外，其余每个元素均出现两次
            则nums[0]^nums[1]^nums[2]...nums[i]=只出现一次的元素
         */
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
