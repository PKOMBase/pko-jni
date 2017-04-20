package com.arithmetic.array;


public class MaxArray {
    public static void main(String[] args) {
        int[] array = new int[] { -10, 2, -10, 234, -33, 34, -500, 33, 55 };
        System.out.println(getMaxArraySum(array));
    }

    /**
     * 
     * 获取最大连续子数组的和
     *
     * @author sunjie at 2017年3月8日
     *
     * @param array
     * @return
     */
    private static int getMaxArraySum(int[] array) {
        // 若全是负数，则取最大负数
        int max = 0;
        int maxArray = 0;// 顺位相加的最大值,若小于零，则取0
        for (int i = 0; i < array.length; i++) {
            maxArray = Math.max(maxArray + array[i], 0);
            max = Math.max(max, maxArray);
        }

        return max;
    }
}
