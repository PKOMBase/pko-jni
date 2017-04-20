package com.arithmetic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapSort {

    public static void main(String[] args) {
        // N个元素顺序由大到小的变长数组，合并为一个有序数组，时间复杂度最小
        List<Integer[]> arrays = new ArrayList<Integer[]>();

        arrays.add(new Integer[] { 10, 8, 5, 4, 1 });
        arrays.add(new Integer[] { 11, 9, 6 });
        arrays.add(new Integer[] { 8, 5, 3, 2 });

        int length = 0;
        for (Integer[] array : arrays) {
            length += array.length;
        }

        Integer[] results = new Integer[length];

        // 合并results
        int k = 0;
        Integer[] l;
        Integer[] r;

        // while (en.hasMoreElements()) {
        // if (results.length >= length) {
        // return;
        // }
        // l = arrays.get(k);
        // r = arrays.get(arrays.size() - 1);
        // results = mergeSort(arrays.get(k), arrays.get(k + 1));
        //
        // }

        // // 2
        // int[][] a = { { 0, 0 }, { 1, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 }, { 1,
        // 3 } };
        // //
        //
        // int[][] b = { { 0, 1 }, { 1, 1 }, { 1, 2 } };
        //
        // // 3
        //
        // LinkedList<Integer> linkedList = new LinkedList<Integer>();
        // linkedList.add(1);
        // linkedList.add(2);
        // linkedList.add(3);
        // linkedList.add(4);
        // linkedList.add(5);
        // LinkedList<Integer> linkedList1 = new LinkedList<Integer>();
        // linkedList1.add(9);
        // linkedList1.add(3);
        // linkedList1.add(2);
        // linkedList1.add(9);
        // linkedList1.add(5);
        // System.out.println(linkedList.toString() + "+" +
        // linkedList1.toString());
        //
        // Collections.reverse(linkedList);
        // Collections.reverse(linkedList1);
        //
        // LinkedList<Integer> result = new LinkedList<Integer>();
        //
        // Integer add = 0;
        // Integer nextAdd = 0;
        // Integer poll = linkedList.poll();
        // Integer poll2 = linkedList1.poll();
        // while (!(poll == null && poll2 == null)) {
        // add = (poll == null ? 0 : poll) + (poll2 == null ? 0 : poll2) +
        // nextAdd;
        // if (add >= 10) {
        // nextAdd = 1;
        // } else {
        // nextAdd = 0;
        // }
        // result.push(add % 10);
        // poll = linkedList.poll();
        // poll2 = linkedList1.poll();
        // }
        // if (nextAdd == 1) {
        // result.push(nextAdd);
        // }
        // System.out.println("result:" + result.toString());
    }

    // private static Integer[] comArr(List<Integer[]> arrays) {
    //
    // comArr(arrays);
    // }

    private static Integer[] mergeSort(Integer[] leftArr, Integer[] rightArr) {
        int i = 0;
        int j = 0;
        Integer[] result = new Integer[leftArr.length + rightArr.length];

        while (i < leftArr.length && j < rightArr.length) {
            result[i + j] = leftArr[i] > rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length) {
            result[i + j] = leftArr[i++];
        }
        while (j < rightArr.length) {
            result[i + j] = rightArr[j++];
        }

        System.out.println(Arrays.asList(result));

        return result;
    }
}
