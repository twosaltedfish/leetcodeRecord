package algorithms;

/**
 * @Description 归并排序例子
 * @Author Lce
 * @Create 2022-01-13
 */
public class DivideAndConquer {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2, 9};
        //新建一个临时数组存放
        int[] tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, tmp);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 归并后合并
     *
     * @param arr  须排序数组
     * @param low  当前拆分后左数组低位
     * @param mid  左右数组的分割位 mid为左数组的高位，mid+1为右数组的低位
     * @param high 当前拆分后右数组的高位
     * @param tmp  临时数组，用于排序
     */
    public static void merge(int[] arr, int low, int mid, int high, int[] tmp) {
        System.out.println("low:" + low + " mid:" + mid + " high:" + high);
        int tmpIndex = 0;
        //左边序列和右边序列起始索引
        int left = low, right = mid + 1;
        //左边数组与右边数组同时比较，存放小的数去tmp数组
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                tmp[tmpIndex++] = arr[left++];
            } else {
                tmp[tmpIndex++] = arr[right++];
            }
        }
        //若左边序列还有剩余，则将其全部拷贝进tmp[]中
        while (left <= mid) {
            tmp[tmpIndex++] = arr[left++];
        }
        //若右边序列还有剩余，则将其全部拷贝进tmp[]中
        while (right <= high) {
            tmp[tmpIndex++] = arr[right++];
        }
        //将排序后的tmp赋值到arr数组里，由左数组低位low开始
        for (int t = 0; t < tmpIndex; t++) {
            arr[low + t] = tmp[t];
        }
        tmp = new int[arr.length];
    }

    /**
     * 归并排序
     *
     * @param arr  须排序数组
     * @param low  当前拆分后左数组低位
     * @param high 当前拆分后右数组的高位
     * @param tmp  临时数组，用于排序
     */
    public static void mergeSort(int[] arr, int low, int high, int[] tmp) {
        //low不小于high代表只有一个数，无需排序
        if (low < high) {
            //划分数组位置
            int mid = (low + high) / 2;
            //对左边序列进行归并排序，low为当前等待排序数组首位，high则为mid位置
            mergeSort(arr, low, mid, tmp);
            //对右边序列进行归并排序，low为mid+1位，high为当前等待排序数组末位
            mergeSort(arr, mid + 1, high, tmp);
            //合并两个有序序列
            merge(arr, low, mid, high, tmp);
        }
    }

}
