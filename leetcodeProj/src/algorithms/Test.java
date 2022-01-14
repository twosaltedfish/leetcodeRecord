package algorithms;

/**
 * @Description 基本类型值传递例子
 * @Author Lce
 * @Create 2022-01-14
 */
public class Test {

    public static void counter(int count) {
        count = 2;

    }

    public static void changeA1(int[] ints) {
        int[] temp = {4, 5, 6};
        ints = temp;
    }

    public static void changeA2(int[] ints) {
        ints[0] = 4;
        ints[1] = 5;
        ints[2] = 6;
    }

    public static void main(String[] args) {
        // Output: 1
        // 基本数据类型没有改变。
        int count = 1;
        counter(count);
        System.out.println("count: " + count);
        int[] ints = {1, 2, 3};
        // Output: 1, 2, 3
        // 对数组赋值，不会改变原始数组。
        changeA1(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
        // Output: 4, 5, 6
        // 可以对数组插入新的数据项。
        System.out.println();
        changeA2(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }

}
