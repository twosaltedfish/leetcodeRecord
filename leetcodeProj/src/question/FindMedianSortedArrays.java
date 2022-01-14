package question;

/**
 * @Description 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Lce
 * @Create 2022-01-14
 */

/**
 * 如果为基数时，中位数=k=(m+n)/2 + 1
 * 如果为偶数时，中位数=(k+k-1)2=((m+n)/2+1+(m+n)/2)/2
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5}, nums2 = {6, 7, 8, 9, 10};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1Len = nums1.length;
        int n2Len = nums2.length;
        //恒定数组1长度小于数组2,这样保证数组长度为0时必为数组1
        if (n1Len > n2Len) {
            return findMedianSortedArrays(nums2, nums1);
        }
        //总长度
        int len = n1Len + n2Len;
        int midIndex = len / 2;
        //个数,第多少个
        int k = midIndex + 1;
        if (len % 2 != 0) {
            //奇数时，为第k个
            return findMedianSortedArrays(nums1, nums2, k);
        } else {
            //偶数时，为第k-1个+k个的平均数
            return (findMedianSortedArrays(nums1, nums2, k) + findMedianSortedArrays(nums1, nums2, k - 1)) / 2.00;
        }
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n1Index = 0;
        int n2Index = 0;

        while (true) {
            // 边界情况
            if (n1Index == n1) {
                return nums2[n2Index + k - 1];
            }
            if (n2Index == n2) {
                return nums1[n1Index + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[n1Index], nums2[n2Index]);
            }
            // 正常情况,这里对比的为k/2-1个，所以half=k/2
            int half = k / 2;
            //找出k/2-1索引位置,Math.min()求出来的是长度，获取索引需要-1
            int newIndex1 = Math.min(n1Index + half, n1) - 1;
            int newIndex2 = Math.min(n2Index + half, n2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            //取小的数就是将小的数以及之前的数全部去掉，形成一个新的数组
            if (pivot1 <= pivot2) {
                //求个数即为求长度，所以需要+1
                k = k - (newIndex1 - n1Index + 1);
                //二分后将分割线左边去掉，一数组的左指针指向右边的第一个
                n1Index = newIndex1 + 1;
            } else {
                //求个数即为求长度，所以需要+1
                k = k - (newIndex2 - n2Index + 1);
                //二分后将分割线左边去掉，二数组的左指针指向右边的第一个
                n2Index = newIndex2 + 1;
            }
        }
    }
}
