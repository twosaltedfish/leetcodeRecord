import java.util.Arrays;

/**
 * @Description 旋转数组:https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 * @Author Lce
 * @Create 2021-12-01
 */
public class Rotate {
    /*
        给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
//        routate1(nums, k);
        System.out.println(6 % 2);
        routate2(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    /*
        用
        向右移(i+k)%length长度
     */

    /**
     * 用额外数组空间存放
     *
     * @param nums
     * @param k
     */
    public static void routate1(int[] nums, int k) {
        int length = nums.length;
        int[] newNums = new int[length];
        for (int i = 0; i < nums.length; i++) {
            newNums[(i + k) % length] = nums[i];
        }
        System.arraycopy(newNums, 0, nums, 0, length);
    }

    /**
     * 不用额外数组空间存放，直接操作数组
     *
     * @param nums
     * @param k
     */
    public static void routate2(int[] nums, int k) {
        int length = nums.length;
        //循环次数
        int n = length;
        //原点（当k是长度的因子时做判断）
        int i = 0;
        //起始位置
        int pos = 0;
        //起始覆盖元素
        int pre = nums[pos];
        //缓存值
        int temp = nums[pos];
        //当n为k值的因子时，即能除尽，没有余数，代表平移k/n圈，回到原来的位置，可以直接返回
        if (k % n == 0) {
            return;
        }
        while (n-- != 0) {
            //移动距离
            pos = (pos + k) % length;
            //保存被覆盖元素
            temp = nums[pos];
            //保存覆盖元素
            nums[pos] = pre;
            //保存被覆盖元素到覆盖元素原来位置
            pre = temp;
            //相等的时候就表面移动nk后回到原点，证明k是n的因子，则会出现数组有元素没有平移，需要将原点设置后一位进行平移
            if (pos == i) {
                //原点设为i+1
                pos = ++i;
                //起始覆盖元素
                pre = nums[pos];
            }
        }


    }


}
