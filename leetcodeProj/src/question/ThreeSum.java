package question;

import java.util.*;

/**
 * @Description TODO
 * @Author Lce
 * @Create 2022-01-15
 */
public class ThreeSum {
    public static void main(String[] args) {
//        int[] i=
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        int target = 0;
        List<List<Integer>> list = new ArrayList<>();
        if (len < 3) {
            return list;
        }
        //0-num[i]-num[j]=
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len; j++) {
                int key = 0 - nums[i] - nums[j];
                if (map.containsKey(key)) {
                    List<Integer> integers = map.get(key);
                    integers.add(key);
                    list.add(integers);
                } else {
                    List<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[j]);
                    map.put(key, integers);
                }
            }
        }
        return list;
    }
}
