package com.jsako;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2020/4/10 14:27
 * @Description: 快速排序
 */
public class Quicksort {

    public static void main(String[] args) {
        //构建数组
        int size = 5;
        List<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int value = new Random().nextInt(1000);
            arrList.add(value);
            System.out.print(value + ",");
        }
        System.out.println();
        IntStream intStream = arrList.stream().mapToInt(value -> value);
        int[] arr = intStream.toArray();


        //快速排序
        fastSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static void fastSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = swapByKey(arr, left, right);
            //排序左边
            fastSort(arr, left, middle - 1);
            //排序右边
            fastSort(arr, middle + 1, right);

        }


    }

    private static int swapByKey(int[] arr, int low, int high) {
        //以低位的第一位元素作为基准因子
        int key = arr[low];
        while (low != high) {
            //先从右边寻找
            while (low != high && arr[high] >= key) {
                high--;
            }
            arr[low] = arr[high];
            //再从左边寻找
            while (low != high && arr[low] < key) {
                low ++;
            }
            arr[high] = arr[low];

        }
        //中置位设置位基准因子
        arr[low] = key;
        return low;
    }

}
